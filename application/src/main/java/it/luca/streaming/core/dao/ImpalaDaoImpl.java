package it.luca.streaming.core.dao;

import com.cloudera.impala.jdbc.DataSource;
import it.luca.streaming.core.model.IngestionLogRecord;
import it.luca.streaming.data.utils.DatePattern;
import lombok.extern.slf4j.Slf4j;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

import static it.luca.streaming.data.utils.Utils.now;

@Slf4j
@Component
@EnableScheduling
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
        log.info("Initialized {} for Impala connection", Jdbi.class.getSimpleName());

        createDb();
        createTable();
    }

    /**
     * Insert given batch of IngestionLogRecords
     * @param ingestionLogRecords records to save
     */

    public void insertLogRecords(List<IngestionLogRecord> ingestionLogRecords) {

        String className = IngestionLogRecord.class.getSimpleName();
        try {
            if (!ingestionLogRecords.isEmpty()) {
                impalaJdbi.useHandle(handle -> handle.attach(ImpalaDao.class).save(ingestionLogRecords));
                log.info("Saved {} instance(s) of {}", ingestionLogRecords.size(), className);
            } else {
                log.warn("Received no {} to insert", className);
            }
        } catch (Exception e) {
            log.error("Caught exception while saving instance of {}. Stack trace: ", className, e);
        }
    }

    private void createDb() {

        impalaJdbi.useHandle(handle -> {
            ImpalaDao impalaDao = handle.attach(ImpalaDao.class);
            if (impalaDao.showDatabases().stream()
                    .noneMatch(s -> s.equalsIgnoreCase(impalaDb))) {
                log.warn("Db {} does not exist yet. Creating it now", impalaDb);
                impalaDao.createDb();
                log.info("Created DB {}", impalaDb);
            }
        });
    }

    private void createTable() {

        impalaJdbi.useHandle(handle -> {
            ImpalaDao impalaDao = handle.attach(ImpalaDao.class);
            if (impalaDao.showTables().stream()
                    .noneMatch(s -> s.equalsIgnoreCase(ingestionTable))) {
                String fqTableName = String.format("%s.%s", impalaDb, ingestionTable);
                log.warn("Table {} does not exist yet. Creating it now", fqTableName);
                impalaDao.createTable();
                log.info("Created table {}", fqTableName);
            }
        });
    }

    /**
     * Reduces the number of files in logTable's today partition every 30 minutes
     */

    @Scheduled(initialDelay = 120000, fixedRate = 1800000)
    private void insertOverwriteToday() {

        String today = now(DatePattern.DEFAULT_DATE);
        log.info("Reducing number of files on {}, partition = {} with INSERT OVERWRITE", ingestionTable, today);
        impalaJdbi.useHandle(handle -> handle.attach(ImpalaDao.class).insertOverwrite(today));
        log.info("Reduced number of files on {}, partition = {} with INSERT OVERWRITE", ingestionTable, today);
    }
}
