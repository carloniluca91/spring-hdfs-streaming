package it.luca.streaming.repository;

import it.luca.streaming.dao.ImpalaDao;
import it.luca.streaming.enumeration.DataSourceId;
import lombok.Builder;
import lombok.Getter;
import org.apache.avro.specific.SpecificRecord;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

@Getter
@Builder
public class SourceSpecification<T, A extends SpecificRecord, P> {

    private final DataSourceId dataSourceId;
    private final Class<T> tClass;
    private final Class<A> avroClass;
    private final String tableName;
    private final String partitionColumn;
    private final String partitionColumnType;
    private final Class<? extends ImpalaDao<P>> impalaDaoClass;
    private final String avroSchemaFile;
    private final Function<T, List<P>> partitionValuesFunction;
    private final BiFunction<T, P, List<A>> partitionValueRecords;

    public String getPartitionClause() {
        return partitionColumn + " " + partitionColumnType;
    }
}
