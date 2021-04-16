package it.luca.streaming.repository;

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
    private final String partitioningColumn;
    private final Function<T, List<P>> tToPartitionValues;
    private final BiFunction<T, P, List<A>> tToAvroRecordList;
}
