package it.luca.streaming.core.repository;

import it.luca.streaming.data.enumeration.DataSourceId;
import lombok.Builder;
import lombok.Getter;
import org.apache.avro.specific.SpecificRecord;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Class that synthesizes source's specifications
 * @param <T>: type of deserialized source data
 * @param <A>: type of Avro records to be generated
 * @param <P>: type of source partition values
 */

@Getter
@Builder
public class SourceSpecification<T, A extends SpecificRecord, P> {

    private final DataSourceId dataSourceId;
    private final Class<T> dataInputClass;
    private final Class<A> avroRecordClass;
    private final String partitionColumnName;

    // Function that, given a batch of input data, returns its distinct partition values
    private final Function<T, List<P>> partitionValuesFunction;

    // Function that, given a batch of input data and a partition value, returns the set of Avro records belonging to such partition
    private final BiFunction<T, P, List<A>> partitionValueRecords;

    public String getTableName() {

        return dataSourceId.name().toLowerCase();
    }
}
