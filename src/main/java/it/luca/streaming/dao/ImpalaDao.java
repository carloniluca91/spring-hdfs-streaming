package it.luca.streaming.dao;

import org.jdbi.v3.sqlobject.customizer.Define;
import org.jdbi.v3.sqlobject.locator.UseClasspathSqlLocator;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.stringtemplate4.UseStringTemplateEngine;

import java.util.List;

@UseClasspathSqlLocator
@UseStringTemplateEngine
public interface ImpalaDao<P> {

    @SqlQuery
    List<P> getPartitionValues(@Define("name") String tableName,
                               @Define("partitionColumn") String partitionColumnName);

    @SqlUpdate
    void invalidateMetadata(@Define("name") String tableName);

    @SqlUpdate
    void refresh(@Define("name") String tableName);

    @SqlUpdate
    List<String> showTables();
}
