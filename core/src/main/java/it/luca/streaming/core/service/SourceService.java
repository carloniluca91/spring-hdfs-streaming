package it.luca.streaming.core.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import it.luca.streaming.data.enumeration.DataSourceId;
import it.luca.streaming.core.exception.EmptyInputException;
import it.luca.streaming.core.repository.HDFSClient;
import it.luca.streaming.core.repository.SourceSpecification;
import lombok.extern.slf4j.Slf4j;
import org.apache.avro.specific.SpecificRecord;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static it.luca.streaming.data.utils.ObjectDeserializer.readValue;

@Slf4j
@Component
public class SourceService {

    @Autowired
    private HDFSClient hdfsClient;

    public <T, A extends SpecificRecord> Optional<Exception> store(String input, SourceSpecification<T, A, ?> sourceSpecification) {

        DataSourceId dataSourceId = sourceSpecification.getDataSourceId();
        Class<T> tClass = sourceSpecification.getTClass();
        Optional<Exception> optionalException;
        try {
            if (!StringUtils.isBlank(input)) {
                log.info("{} - Received call. Input:\n\n{}\n", dataSourceId, input);
                T payload = readValue(input, tClass, dataSourceId.getDataSourceType());
                hdfsClient.write(payload, sourceSpecification);
                optionalException = Optional.empty();
            } else {
                throw new EmptyInputException(dataSourceId);
            }
        } catch (Exception e) {
            String errorMsg = (e instanceof JsonProcessingException) | (e instanceof EmptyInputException) ?
                    "Caught exception while processing given input" :
                    "Caught exception while saving deserialized data";
            log.error("{} - {}. Stack trace: ", dataSourceId, errorMsg, e);
            optionalException = Optional.of(e);
        }
        return optionalException;
    }
}
