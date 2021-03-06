package it.luca.streaming.core.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import it.luca.streaming.core.dao.ImpalaDaoImpl;
import it.luca.streaming.core.exception.EmptyInputException;
import it.luca.streaming.core.dto.DataSourceResponseDto;
import it.luca.streaming.core.dto.IngestionLogDto;
import it.luca.streaming.core.repository.HDFSClient;
import it.luca.streaming.data.enumeration.DataSourceId;
import it.luca.streaming.data.model.common.SourceSpecification;
import lombok.extern.slf4j.Slf4j;
import org.apache.avro.specific.SpecificRecord;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

import static it.luca.streaming.data.utils.ObjectDeserializer.readValue;
import static it.luca.streaming.data.utils.Utils.isPresent;

@Slf4j
@Component
public class IngestionService {

    @Autowired
    private HDFSClient hdfsClient;

    @Autowired
    private ImpalaDaoImpl impalaDao;

    /**
     * Deserializes input data as as instance of T, convert such instance to a set of avro records of type A and store them on HDFS
     * @param input input data
     * @param specification set of source's specification
     * @param <T> type of deserialized input data
     * @param <A> type of avro record to be generated from deserialized input data
     * @return ingestion operation report
     */

    public <T, A extends SpecificRecord, P> DataSourceResponseDto store(String input, SourceSpecification<T, A, P> specification) {

        DataSourceId dataSourceId = specification.getDataSourceId();
        List<IngestionLogDto> ingestionLogDtos = new ArrayList<>();
        T payload = null;
        Exception exception = null;

        // Try to deserialize input data
        try {
            if (!StringUtils.isBlank(input)) {
                log.info("{} - Call received. Input data:\n\n{}\n", dataSourceId, input);
                payload = readValue(input, specification.getInputDataClass(), specification.getDataSourceType());
            } else {
                throw new EmptyInputException(dataSourceId);
            }
        } catch (EmptyInputException | JsonProcessingException caughtException) {
            exception = caughtException;
            log.error("{} - Caught exception while processing input data. Stack trace: ", dataSourceId, caughtException);
            ingestionLogDtos.add(new IngestionLogDto(specification, caughtException));
        }

        if (isPresent(payload)) {

            // For each partition value, write related .avro records
            Map<P, List<A>> partitionRecordsMap = specification.getPartitionRecordsMap(payload);
            BiFunction<Map.Entry<P, List<A>>, Exception, IngestionLogDto> biFunction = (entry, excpt) ->
                    new IngestionLogDto(specification, entry.getKey(), entry.getValue().size(), excpt);
            for (Map.Entry<P, List<A>> entry : partitionRecordsMap.entrySet()) {

                P partitionValue = entry.getKey();
                List<A> partitionRecords = entry.getValue();
                try {
                    hdfsClient.write(partitionValue, partitionRecords, specification);
                    ingestionLogDtos.add(biFunction.apply(entry, null));
                } catch (Exception caughtException) {
                    exception = caughtException;
                    log.error("{} - Caught exception while saving deserialized data. Stack trace: ", dataSourceId, caughtException);
                    ingestionLogDtos.add(biFunction.apply(entry, caughtException));
                }
            }
        }

        // Log ingestion operation
        impalaDao.insertLogRecords(ingestionLogDtos);
        return new DataSourceResponseDto(specification, exception);
    }
}
