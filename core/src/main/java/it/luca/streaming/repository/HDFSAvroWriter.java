package it.luca.streaming.repository;

import com.cloudera.impala.jdbc.DataSource;
import it.luca.streaming.dao.HiveDao;
import it.luca.streaming.dao.ImpalaDao;
import it.luca.streaming.enumeration.DataSourceId;
import lombok.extern.slf4j.Slf4j;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.specific.SpecificDatumWriter;
import org.apache.avro.specific.SpecificRecord;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.permission.FsPermission;
import org.apache.hadoop.security.UserGroupInformation;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.security.PrivilegedAction;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import static it.luca.streaming.utils.HDFSUtils.joinPaths;
import static it.luca.streaming.utils.Utils.*;

@Slf4j
@Component
public class HDFSAvroWriter {

    @Value("${hdfs.user}")
    private String hdfsUser;

    @Value("${hdfs.path.landingRoot}")
    private String landingRootPath;

    @Value("${hdfs.path.schemasRoot}")
    private String schemasRootPath;

    @Value("${hdfs.path.permissions}")
    private String pathPermissions;

    @Value("${jdbc.hive.url}")
    private String hiveJdbcUrl;

    @Value("${jdbc.hive.driver}")
    private String hiveJdbcDriver;

    @Value("${jdbc.impala.url}")
    private String impalaJdbcUrl;

    @Value("${jdbc.impala.driver}")
    private String impalaJdbcDriver;

    private Jdbi hiveJdbi;
    private Jdbi impalaJdbi;

    public <T, A extends SpecificRecord, P> void write(T payload, SourceSpecification<T, A, P> sourceSpecification) {

        DataSourceId dataSourceId = sourceSpecification.getDataSourceId();
        List<P> partitionValues = sourceSpecification.getPartitionValuesFunction().apply(payload);
        log.info("{} - Found {} partition value(s) for current batch: ({})",
                dataSourceId, partitionValues.size(), mkString("|", partitionValues));

        UserGroupInformation.createRemoteUser(hdfsUser).doAs((PrivilegedAction<Object>) () -> {
            try {
                // Instantiate FileSystem connection and Jdbi instances
                FileSystem fileSystem = FileSystem.get(URI.create(landingRootPath), new Configuration());
                initJdbiInstances();
                log.info("Initialized {} instance, Hive {} and Impala {}",
                        FileSystem.class.getSimpleName(), Jdbi.class.getSimpleName(), Jdbi.class.getSimpleName());

                // Create table's root path and
                String tablePath = joinPaths(landingRootPath, sourceSpecification.getTableName());
                createPathIfNotExists(fileSystem, tablePath, pathPermissions);
                createTableIfNotExists(sourceSpecification);
                DataFileWriter<A> dataFileWriter = new DataFileWriter<>(new SpecificDatumWriter<>(sourceSpecification.getAvroClass()));
                for (P partitionValue: partitionValues) {

                    // Create table's partition path
                    String tablePlusPartitionPath = joinPaths(tablePath, String.format("%s=%s", sourceSpecification.getPartitionColumn(), partitionValue));
                    createPathIfNotExists(fileSystem, tablePlusPartitionPath, pathPermissions);

                    // Write .avro file containing current partition's records
                    String fullFilePath = joinPaths(tablePlusPartitionPath, String.format("batch_%s.avro", now("yyyy_MM_dd_HH_mm_ss")));
                    List<A> avroRecords = sourceSpecification.getPartitionValueRecords().apply(payload, partitionValue);
                    log.info("{} - Saving {} Avro record(s) at HDFS path {}", dataSourceId, avroRecords.size(), tablePlusPartitionPath);
                    dataFileWriter.create(avroRecords.get(0).getSchema(), fileSystem.create(new Path(fullFilePath), false));
                    for (A avroRecord: avroRecords) {
                        dataFileWriter.append(avroRecord);
                    }
                    log.info("{} - Saved all of {} Avro record(s) at HDFS path {}", dataSourceId, avroRecords.size(), tablePlusPartitionPath);
                }

                // Close data writer and update metadata
                dataFileWriter.close();
                updateMetadata(partitionValues, sourceSpecification);
            } catch (Exception e) {
                log.error("{} - Caught exception while saving data. Stack trace:", dataSourceId, e);
            }
            return null;
        });
    }

    private void initJdbiInstances() throws ClassNotFoundException, SQLException {

        Class.forName(hiveJdbcDriver);
        Connection hiveJdbcConnection = DriverManager.getConnection(hiveJdbcUrl);
        hiveJdbi = Jdbi.create(hiveJdbcConnection).installPlugin(new SqlObjectPlugin());

        Class.forName(impalaJdbcDriver);
        DataSource dataSource = new com.cloudera.impala.jdbc.DataSource();
        dataSource.setURL(impalaJdbcUrl);
        impalaJdbi = Jdbi.create(dataSource).installPlugin(new SqlObjectPlugin());
    }

    private void createPathIfNotExists(FileSystem fileSystem, String pathString, String pathPermissions) throws IOException {

        Path path = new Path(pathString);
        if (!fileSystem.exists(path)) {
            log.warn("Path {} does not exist yet. Creating now with permissions {}", path, pathPermissions);
            fileSystem.mkdirs(path, FsPermission.valueOf(pathPermissions));
            log.info("Created path {} with permissions {}", path, pathPermissions);
        } else {
            log.info("Path {} exists already", path);
        }
    }

    private  <P> void createTableIfNotExists(SourceSpecification<?, ?, P> sourceSpecification) {

        DataSourceId dataSourceId = sourceSpecification.getDataSourceId();
        String tableName = sourceSpecification.getTableName();

        // Retrieve existing tables
        List<String> existingTables = impalaJdbi.withHandle(handle -> handle.attach(ImpalaDao.class).showTables());
        if (existingTables.stream().anyMatch(s -> s.equalsIgnoreCase(tableName))) {
            log.info("{} - Table {} already exists", dataSourceId, tableName);
        } else {

            // If table does not exist yet, create it using Hive Jdbi and execute invalidate metadata using Impala Jdbi
            String partitionClause = sourceSpecification.getPartitionClause();
            String tableLocation = joinPaths(landingRootPath, tableName);
            String avroSchemaLocation = joinPaths(schemasRootPath, sourceSpecification.getAvroSchemaFile());
            log.warn("{} - Table {} does not exist yet. Creating it now with partitionClause ({}), location {}, avro schema location {}",
                    dataSourceId, tableName, partitionClause, tableLocation, avroSchemaLocation);
            hiveJdbi.useHandle(handle -> handle.attach(HiveDao.class)
                    .createTable(tableName, partitionClause, tableLocation, avroSchemaLocation));
            log.info("{} - Created table {} with partitionClause ({}), location {}, avro schema location {}",
                    dataSourceId, tableName, partitionClause, tableLocation, avroSchemaLocation);
            impalaJdbi.useHandle(handle -> handle.attach(ImpalaDao.class).invalidateMetadata(tableName));
        }
    }

    private  <P> void updateMetadata(List<P> batchPartitionValues, SourceSpecification<?, ?, P> sourceSpecification) {

        DataSourceId dataSourceId = sourceSpecification.getDataSourceId();
        String tableName = sourceSpecification.getTableName();

        // Retrieve existing partition's values
        List<String> existingPartitionValues = impalaJdbi
                .withHandle(handle -> handle.attach(ImpalaDao.class)
                        .getPartitionValues(tableName, sourceSpecification.getPartitionColumn()));

        // New partition values brought by current batch
        List<String> newPartitionValues = toStreamOf(batchPartitionValues, String::valueOf)
                .filter(i -> !existingPartitionValues.contains(i))
                .collect(Collectors.toList());

        if (newPartitionValues.isEmpty()) {

            // Just refresh table using Impala Jdbi
            log.info("{} - All partitions embedded in current batch ({}) exist already",
                    dataSourceId, mkString("|", batchPartitionValues));
            impalaJdbi.useHandle(handle -> handle.attach(ImpalaDao.class).refresh(tableName));
        } else {

            // If new partitions have been added, run metastore check (MSCK) using Hive Jdbi and invalidate metadata using Impala Jdbi
            log.info("{} - New partitions embedded in current batch are ({}). Need to update table metadata",
                    dataSourceId, mkString("|", newPartitionValues));
            hiveJdbi.useHandle(handle -> handle.attach(HiveDao.class).msck(tableName));
            impalaJdbi.useHandle(handle -> handle.attach(ImpalaDao.class).invalidateMetadata(tableName));
            log.info("{} - Updated metadata for table {}", dataSourceId, tableName);
        }
    }
}
