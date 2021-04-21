package it.luca.streaming.core.dao;

import com.cloudera.impala.jdbc.DataSource;
import it.luca.streaming.core.model.IngestionLogRecord;
import it.luca.streaming.data.enumeration.DataSourceId;
import lombok.extern.slf4j.Slf4j;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Slf4j
@Component
public class ImpalaDaoImpl {

    @Value("${impala.url}")
    private String impalaUrl;

    @Value("${impala.driver}")
    private String impalaDriver;

    @Value("${impala.db}")
    private String impalaDb;

    @Value("${impala.table.ingestionLog}")
    private String ingestionTable;

    private Jdbi impalaJdbi;

    @PostConstruct
    private void initJdbi() throws ClassNotFoundException {

        Class.forName(impalaDriver);
        DataSource dataSource = new DataSource();
        dataSource.setURL(impalaUrl);
        impalaJdbi = Jdbi.create(dataSource).installPlugin(new SqlObjectPlugin());
        log.info("Instantiated {} for Impala connection", Jdbi.class.getSimpleName());

        createDb();
        createTable();
    }

    public void saveIngestionLogRecord(DataSourceId dataSourceId, Exception exception) {

        String fqTableName = fqTableName(ingestionTable);
        IngestionLogRecord ingestionLogRecord = new IngestionLogRecord(dataSourceId, exception);
        impalaJdbi.useHandle(handle -> handle.attach(ImpalaDao.class).save(fqTableName, ingestionLogRecord));
        log.info("Saved instance of {}", IngestionLogRecord.class.getSimpleName());
    }

    private String fqTableName(String tableName) {
        return String.format("%s.%s", impalaDb, tableName);
    }

    private void createDb() {

        impalaJdbi.useHandle(handle -> {
            ImpalaDao impalaDao = handle.attach(ImpalaDao.class);
            List<String> existingDbs = impalaDao.showDatabases();
            if (existingDbs.stream().noneMatch(s -> s.equalsIgnoreCase(impalaDb))) {
                log.warn("Db {} does not exist yet. Creating it now", impalaDb);
                impalaDao.createDb(impalaDb);
                log.info("Created DB {}", impalaDb);
            }
        });
    }

    private void createTable() {

        impalaJdbi.useHandle(handle -> {
            ImpalaDao impalaDao = handle.attach(ImpalaDao.class);
            List<String> existingTables = impalaDao.showTablesIn(impalaDb);
            if (existingTables.stream().noneMatch(s -> s.equalsIgnoreCase(ingestionTable))) {
                String fqTableName = fqTableName(ingestionTable);
                log.warn("Table {} does not exist yet. Creating it now", fqTableName);
                impalaDao.createTable(fqTableName);
                log.info("Created table {}", fqTableName);
            }
        });
    }
}
