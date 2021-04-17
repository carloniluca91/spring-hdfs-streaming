package it.luca.streaming.dao;

import com.cloudera.impala.jdbc.DataSource;
import it.luca.streaming.enumeration.DataSourceId;
import it.luca.streaming.repository.SourceSpecification;
import lombok.extern.slf4j.Slf4j;
import org.jdbi.v3.core.Jdbi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static it.luca.streaming.utils.Utils.joinPathElements;

@Slf4j
@Component
public class CDHDao {

    @Value("${jdbc.hive.url}")
    private String hiveJdbcUrl;

    @Value("${jdbc.hive.driver}")
    private String hiveJdbcDriver;

    @Value("${jdbc.impala.url}")
    private String impalaJdbcUrl;

    @Value("${jdbc.impala.driver}")
    private String impalaJdbcDriver;

    @Value("${hdfs.path.landingRoot}")
    private String landingRootPath;

    @Value("${hdfs.path.schemasRoot}")
    private String schemasRootPath;

    private Jdbi hiveJdbi;
    private Jdbi impalaJdbi;

    @PostConstruct
    void initJdbiInstances() throws ClassNotFoundException, SQLException {

        Class.forName(hiveJdbcDriver);
        Connection hiveJdbcConnection = DriverManager.getConnection(hiveJdbcUrl);
        hiveJdbi = Jdbi.create(hiveJdbcConnection);
        log.info("Initialized Hive {} instance", Jdbi.class.getName());

        Class.forName(impalaJdbcDriver);
        DataSource dataSource = new com.cloudera.impala.jdbc.DataSource();
        dataSource.setURL(impalaJdbcUrl);
        impalaJdbi = Jdbi.create(dataSource);
        log.info("Initialized Impala {} instance", Jdbi.class.getName());
    }

    public <P> void createTableIfNotExists(SourceSpecification<?, ?, P> sourceSpecification) {

        DataSourceId dataSourceId = sourceSpecification.getDataSourceId();
        String tableName = sourceSpecification.getTableName();
        List<String> existingTables = impalaJdbi.withHandle(handle -> handle.attach(sourceSpecification.getImpalaDaoClass()).showTables());
        if (existingTables.stream().anyMatch(s -> s.equalsIgnoreCase(tableName))) {
            log.info("{} - Table {} already exists", dataSourceId, tableName);
        } else {
            String partitionClause = sourceSpecification.getPartitionClause();
            String tableLocation = joinPathElements(landingRootPath, tableName).toString();
            String avroSchemaLocation = joinPathElements(schemasRootPath, sourceSpecification.getAvroSchemaFile()).toString();
            log.warn("{} - Table {} does not exist yet. Creating it now with partitionClause ({}), location {}, avro schema location {}",
                    dataSourceId, tableName, partitionClause, tableLocation, avroSchemaLocation);
            hiveJdbi.useHandle(handle -> handle.attach(HiveDao.class)
                    .createTable(tableName, partitionClause, tableLocation, avroSchemaLocation));
            log.info("{} - Created table {} with partitionClause ({}), location {}, avro schema location {}",
                    dataSourceId, tableName, partitionClause, tableLocation, avroSchemaLocation);
        }
    }

    public <P> void updateMetadata(List<P> batchPartitionValues, SourceSpecification<?, ?, P> sourceSpecification) {

        DataSourceId dataSourceId = sourceSpecification.getDataSourceId();
        String tableName = sourceSpecification.getTableName();
        List<P> existingPartitionValues = impalaJdbi.withHandle(handle -> handle.attach(sourceSpecification.getImpalaDaoClass())
                .getPartitionValues(tableName, sourceSpecification.getPartitionColumn()));

        List<P> newPartitionValues = batchPartitionValues.stream()
                .filter(i -> !existingPartitionValues.contains(i))
                .collect(Collectors.toList());

        Function<List<P>, String> function = l -> l.stream().map(String::valueOf).collect(Collectors.joining("|"));
        if (newPartitionValues.isEmpty()) {
            log.info("{} - All partitions carried by current batch ({}) exist already", dataSourceId, function.apply(batchPartitionValues));
            impalaJdbi.useHandle(handle -> handle.attach(ImpalaDao.class).refresh(tableName));
        } else {
            log.info("{} - New partitions carried by current batch are ({})", dataSourceId, function.apply(newPartitionValues));
            hiveJdbi.useHandle(handle -> handle.attach(HiveDao.class).msck(tableName));
            impalaJdbi.useHandle(handle -> handle.attach(ImpalaDao.class).invalidateMetadata(tableName));
            log.info("{} - Updated metadata for table {}", dataSourceId, tableName);
        }
    }
}
