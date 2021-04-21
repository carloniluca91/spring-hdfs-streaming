package it.luca.streaming.core.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import it.luca.streaming.core.dao.ImpalaDaoImpl;
import it.luca.streaming.core.exception.EmptyInputException;
import it.luca.streaming.core.model.ControllerResponse;
import it.luca.streaming.core.repository.HDFSClient;
import it.luca.streaming.core.repository.SourceSpecification;
import it.luca.streaming.data.enumeration.DataSourceId;
import lombok.extern.slf4j.Slf4j;
import org.apache.avro.specific.SpecificRecord;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static it.luca.streaming.data.utils.ObjectDeserializer.readValue;

@Slf4j
@Component
public class SourceService {

    @Autowired
    private HDFSClient hdfsClient;

    @Autowired
    private ImpalaDaoImpl impalaDao;

    public <T, A extends SpecificRecord> ControllerResponse store(String input, SourceSpecification<T, A, ?> sourceSpecification) {

        DataSourceId dataSourceId = sourceSpecification.getDataSourceId();
        Class<T> tClass = sourceSpecification.getTClass();
        try {
            if (!StringUtils.isBlank(input)) {
                log.info("{} - Received call. Input:\n\n{}\n", dataSourceId, input);
                T payload = readValue(input, tClass, dataSourceId.getDataSourceType());
                hdfsClient.write(payload, sourceSpecification);
                impalaDao.saveIngestionLogRecord(dataSourceId, null);
                return new ControllerResponse(dataSourceId, null);
            } else {
                throw new EmptyInputException(dataSourceId);
            }
        } catch (Exception exception) {
            String errorMsg = (exception instanceof JsonProcessingException) | (exception instanceof EmptyInputException) ?
                    "Caught exception while processing given input" :
                    "Caught exception while saving deserialized data";
            log.error("{} - {}. Stack trace: ", dataSourceId, errorMsg, exception);
            impalaDao.saveIngestionLogRecord(dataSourceId, exception);
            return new ControllerResponse(dataSourceId, exception);
        }
    }
}
