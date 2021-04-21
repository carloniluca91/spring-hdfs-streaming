package it.luca.streaming.core.repository;

import it.luca.streaming.core.utils.DatePattern;
import it.luca.streaming.data.enumeration.DataSourceId;
import lombok.extern.slf4j.Slf4j;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.specific.SpecificDatumWriter;
import org.apache.avro.specific.SpecificRecord;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.permission.FsPermission;
import org.apache.hadoop.security.UserGroupInformation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.security.PrivilegedAction;
import java.util.List;

import static it.luca.streaming.core.utils.HDFSUtils.joinPaths;
import static it.luca.streaming.core.utils.Utils.mkString;
import static it.luca.streaming.core.utils.Utils.now;

@Slf4j
@Component
public class HDFSClient {

    @Value("${hdfs.user}")
    private String hdfsUser;

    @Value("${hdfs.fsUri}")
    private String fsUri;

    @Value("${hdfs.path.landingRoot}")
    private String landingRootPath;

    @Value("${hdfs.path.schemasRoot}")
    private String schemasRootPath;

    @Value("${hdfs.path.permissions}")
    private String pathPermissions;

    public <T, A extends SpecificRecord, P> void write(T payload, SourceSpecification<T, A, P> sourceSpecification) {

        DataSourceId dataSourceId = sourceSpecification.getDataSourceId();
        List<P> partitionValues = sourceSpecification.getPartitionValuesFunction().apply(payload);
        log.info("{} - Found {} partition value(s) within current batch: ({})",
                dataSourceId, partitionValues.size(), mkString("|", partitionValues));

        UserGroupInformation userGroupInformation = UserGroupInformation.createRemoteUser(hdfsUser);
        userGroupInformation.doAs((PrivilegedAction<Object>) () -> {
            try {
                // Instantiate FileSystem connection and define table's root path
                FileSystem fileSystem = FileSystem.get(URI.create(fsUri), new Configuration());
                log.info("Initialized {} instance", FileSystem.class.getName());
                String tablePath = joinPaths(landingRootPath, sourceSpecification.getTableName());
                createPathIfNotExists(fileSystem, tablePath, pathPermissions);

                // Write data into respective partitions
                DataFileWriter<A> dataFileWriter = new DataFileWriter<>(new SpecificDatumWriter<>(sourceSpecification.getAvroClass()));
                for (P partitionValue: partitionValues) {

                    // Create table's partition path
                    String tablePlusPartitionPath = joinPaths(tablePath, String.format("%s=%s", sourceSpecification.getPartitionColumn(), partitionValue));
                    createPathIfNotExists(fileSystem, tablePlusPartitionPath, pathPermissions);

                    // Write .avro file containing current partition's records
                    String fileName = String.format("%s_%s.avro", dataSourceId.name().toLowerCase(), now(DatePattern.AVRO_FILE_TIMESTAMP));
                    Path avroFilePath = new Path(joinPaths(tablePlusPartitionPath, fileName));
                    List<A> avroRecords = sourceSpecification.getPartitionValueRecords().apply(payload, partitionValue);
                    log.info("{} - Saving {} Avro record(s) at HDFS path {}", dataSourceId, avroRecords.size(), tablePlusPartitionPath);
                    dataFileWriter.create(avroRecords.get(0).getSchema(), fileSystem.create(avroFilePath, false));
                    for (A avroRecord: avroRecords) {
                        dataFileWriter.append(avroRecord);
                    }
                    log.info("{} - Saved all of {} Avro record(s) at HDFS path {}", dataSourceId, avroRecords.size(), tablePlusPartitionPath);
                }
                // Close data writer
                dataFileWriter.close();
            } catch (Exception e) {
                log.error("{} - Caught exception while saving data. Stack trace:", dataSourceId, e);
            }
            return null;
        });
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
}
