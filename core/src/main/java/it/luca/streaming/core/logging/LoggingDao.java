package it.luca.streaming.core.logging;

import org.jdbi.v3.sqlobject.customizer.BindMethods;
import org.jdbi.v3.sqlobject.locator.UseClasspathSqlLocator;
import org.jdbi.v3.sqlobject.statement.SqlBatch;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

@UseClasspathSqlLocator
public interface LoggingDao {

    @SqlUpdate
    void createTable();

    @SqlBatch
    void save(@BindMethods("record") List<LoggingRecord> loggingRecords);
}
