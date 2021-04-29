package it.luca.streaming.data.model.common;

import it.luca.streaming.data.enumeration.DataSourceId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.avro.specific.SpecificRecord;

import java.util.List;

@Getter
@AllArgsConstructor
public abstract class SourceSpecification<T, A extends SpecificRecord, P> {

    protected final DataSourceId dataSourceId;
    protected final String partitionColumnName;
    protected final Class<T> inputDataClass;
    protected final Class<A> avroRecordClass;

    public String getTableName() {

        return "t_rwd_" + dataSourceId.name().toLowerCase();
    }

    public abstract List<A> getAvroRecordsForPartition(T input, P partitionValue);

    public abstract List<P> getPartitionValues(T input);
}
