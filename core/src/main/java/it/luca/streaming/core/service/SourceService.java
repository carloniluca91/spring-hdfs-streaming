package it.luca.streaming.core.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import it.luca.streaming.core.model.SourceResponse;
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

    public <T, A extends SpecificRecord> SourceResponse store(String input, SourceSpecification<T, A, ?> sourceSpecification) {

        DataSourceId dataSourceId = sourceSpecification.getDataSourceId();
        Class<T> tClass = sourceSpecification.getTClass();
        SourceResponse sourceResponse;
        try {
            if (!StringUtils.isBlank(input)) {
                log.info("{} - Received call. Input:\n\n{}\n", dataSourceId, input);
                T payload = readValue(input, tClass, dataSourceId.getDataSourceType());
                hdfsClient.write(payload, sourceSpecification);
                sourceResponse = new SourceResponse(dataSourceId, Optional.empty());
            } else {
                throw new EmptyInputException(dataSourceId);
            }
        } catch (JsonProcessingException | EmptyInputException e) {
            log.error("{} - Caught exception while processing given input. Stack trace: ", dataSourceId, e);
            sourceResponse = new SourceResponse(dataSourceId, Optional.of(e));
        } catch (Exception e) {
            sourceResponse = new SourceResponse(dataSourceId, Optional.of(e));
            log.error("{} - Caught exception while saving data. Stack trace: ", dataSourceId, e);
        }

        return sourceResponse;
    }
}
