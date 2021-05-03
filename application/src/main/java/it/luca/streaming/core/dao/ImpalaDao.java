package it.luca.streaming.core.dao;

import it.luca.streaming.core.model.IngestionLogRecord;
import org.jdbi.v3.sqlobject.customizer.BindMethods;
import org.jdbi.v3.sqlobject.locator.UseClasspathSqlLocator;
import org.jdbi.v3.sqlobject.statement.SqlBatch;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

@UseClasspathSqlLocator
public interface ImpalaDao {

    @SqlUpdate
    void createDb();

    @SqlUpdate
    void createTable();

    @SqlBatch
    void save(@BindMethods("record") List<IngestionLogRecord> ingestionLogRecords);

    @SqlQuery
    List<String> showDatabases();

    @SqlQuery
    List<String> showTables();
}
