package it.luca.streaming.core.dao;

import it.luca.streaming.core.model.IngestionLogRecord;
import org.jdbi.v3.sqlobject.customizer.BindMethods;
import org.jdbi.v3.sqlobject.customizer.Define;
import org.jdbi.v3.sqlobject.locator.UseClasspathSqlLocator;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.stringtemplate4.UseStringTemplateEngine;

import java.util.List;

@UseClasspathSqlLocator
@UseStringTemplateEngine
public interface ImpalaDao {

    @SqlUpdate
    void createDb(@Define("name") String dbName);

    @SqlUpdate
    void createTable(@Define("fqTableName") String tableName);

    @SqlUpdate
    void save(@Define("fqTableName") String tableName, @BindMethods("record") IngestionLogRecord ingestionLogRecord);

    @SqlQuery
    List<String> showDatabases();

    @SqlQuery
    List<String> showTablesIn(@Define("dbName") String dbName);
}
