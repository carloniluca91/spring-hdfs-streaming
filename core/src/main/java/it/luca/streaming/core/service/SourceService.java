package it.luca.streaming.core.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import it.luca.streaming.core.dao.ImpalaDaoImpl;
import it.luca.streaming.core.exception.EmptyInputException;
import it.luca.streaming.core.model.ControllerResponse;
import it.luca.streaming.core.repository.HDFSClient;
import it.luca.streaming.core.repository.SourceSpecification;
import it.luca.streaming.data.enumeration.DataSourceId;
import it.luca.streaming.data.utils.ObjectDeserializer;
import lombok.extern.slf4j.Slf4j;
import org.apache.avro.specific.SpecificRecord;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SourceService {

    @Autowired
    private HDFSClient hdfsClient;

    @Autowired
    private ImpalaDaoImpl impalaDao;

    /**
     * Deserializes input data as as instance of T, convert such instance to a set of avro records of type A and store them on HDFS
     * @param input: input data
     * @param sourceSpecification: set of source's specification
     * @param <T>: type of deserialized input data
     * @param <A>: type of avro record to be generated from deserialized input data
     * @return ingestion operation report
     */

    public <T, A extends SpecificRecord> ControllerResponse store(String input, SourceSpecification<T, A, ?> sourceSpecification) {

        DataSourceId dataSourceId = sourceSpecification.getDataSourceId();
        Class<T> dataInputClass = sourceSpecification.getDataInputClass();
        Exception exception = null;
        try {
            if (!StringUtils.isBlank(input)) {
                log.info("{} - Call received. Input:\n\n{}\n", dataSourceId, input);
                T payload = ObjectDeserializer.readValue(input, dataInputClass, dataSourceId.getDataSourceType());
                hdfsClient.write(payload, sourceSpecification);
            } else {
                throw new EmptyInputException(dataSourceId);
            }
        } catch (Exception caughtException) {
            String errorMsg = (caughtException instanceof JsonProcessingException) | (caughtException instanceof EmptyInputException) ?
                    "Caught exception while processing given input" :
                    "Caught exception while saving deserialized data";
            log.error("{} - {}. Stack trace: ", dataSourceId, errorMsg, caughtException);
            exception = caughtException;
        }

        // Log ingestion operation
        impalaDao.saveIngestionLogRecord(dataSourceId, exception);
        return new ControllerResponse(dataSourceId, exception);
    }
}
