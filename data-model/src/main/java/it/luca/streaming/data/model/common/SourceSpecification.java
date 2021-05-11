package it.luca.streaming.data.model.common;

import it.luca.streaming.data.enumeration.DataSourceId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.avro.specific.SpecificRecord;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static it.luca.streaming.data.utils.Utils.mkString;

@Slf4j
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

    public Map<P, List<A>> getPartitionRecordsMap(T input) {

        Map<P, List<A>> map = new LinkedHashMap<>();
        List<P> distinctPartitionValues = getDistinctPartitionValues(input);
        log.info("{} - Found {} partition value(s) ({}) within current sample",
                dataSourceId, distinctPartitionValues.size(), mkString("|", distinctPartitionValues));

        distinctPartitionValues.forEach(partitionValue -> {
            List<A> avroRecords = getAvroRecordsForPartition(input, partitionValue);
            map.put(partitionValue, avroRecords);
        });

        return map;
    }

    public List<P> getDistinctPartitionValues(T input) {

        return getPartitionValues(input).stream()
                .distinct()
                .collect(Collectors.toList());
    }

    protected abstract List<A> getAvroRecordsForPartition(T input, P partitionValue);

    protected abstract List<P> getPartitionValues(T input);
}
