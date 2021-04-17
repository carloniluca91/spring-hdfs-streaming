package it.luca.streaming.dao;

import org.jdbi.v3.sqlobject.customizer.Define;
import org.jdbi.v3.sqlobject.locator.UseClasspathSqlLocator;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.stringtemplate4.UseStringTemplateEngine;

@UseClasspathSqlLocator
@UseStringTemplateEngine
public interface HiveDao {

    @SqlUpdate
    void createTable(@Define("name") String tableName,
                     @Define("partitionClause") String partitionClause,
                     @Define("location") String tableLocation,
                     @Define("avroSchemaPath") String avroSchemaUrl);

    @SqlUpdate
    void msck(@Define("name") String tableName);
}
