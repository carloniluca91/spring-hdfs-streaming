package it.luca.streaming.core.dao;

import org.jdbi.v3.sqlobject.customizer.Define;
import org.jdbi.v3.sqlobject.locator.UseClasspathSqlLocator;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.stringtemplate4.UseStringTemplateEngine;

import java.util.List;

@UseClasspathSqlLocator
@UseStringTemplateEngine
public interface ImpalaDao {

    @SqlQuery
    List<String> getPartitionValues(@Define("name") String tableName,
                                    @Define("partitionColumn") String partitionColumnName);

    @SqlUpdate
    void invalidateMetadata(@Define("name") String tableName);

    @SqlUpdate
    void refresh(@Define("name") String tableName);

    @SqlQuery
    List<String> showTables();
}
