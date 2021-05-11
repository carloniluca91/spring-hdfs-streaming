package it.luca.streaming.data.model.common;

import it.luca.streaming.data.enumeration.DataSourceId;
import it.luca.streaming.data.enumeration.DataSourceType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.avro.specific.SpecificRecord;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static it.luca.streaming.data.utils.Utils.mkString;

/**
 * Class representing storage specifications of a source
 * @param <T> type of input data
 * @param <A> type of Avro data to be stored
 * @param <P> type of partition values to be retrieved from an instance of type T
 */

@Slf4j
@Getter
@AllArgsConstructor
public abstract class SourceSpecification<T, A extends SpecificRecord, P> {

    protected final DataSourceId dataSourceId;
    protected final DataSourceType dataSourceType;
    protected final String partitionColumnName;
    protected final Class<T> inputDataClass;
    protected final Class<A> avroRecordClass;

    public String getTableName() {

        return "t_rwd_" + dataSourceId.name().toLowerCase();
    }

    /**
     * Retrieves partitions and related Avro records from input data
     * @param input instance of type T
     * @return a map where key is a partition value and value is the list of Avro records to be stored on that partition
     */

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

    /**
     * Get distinct partition values from input data
     * @param input instance of type T
     * @return distinct list of partition values
     */

    public List<P> getDistinctPartitionValues(T input) {

        return getPartitionValues(input).stream()
                .distinct()
                .collect(Collectors.toList());
    }

    /**
     * Retrieves the Avro records from input batch for given partition value
     * @param input instance of type T
     * @param partitionValue instance of type A
     * @return list of Avro records to be stored on given partition value
     */

    protected abstract List<A> getAvroRecordsForPartition(T input, P partitionValue);

    /**
     * Compute partition values of given batch
     * @param input data batch
     * @return non-distinct list of partition values
     */

    protected abstract List<P> getPartitionValues(T input);
}
