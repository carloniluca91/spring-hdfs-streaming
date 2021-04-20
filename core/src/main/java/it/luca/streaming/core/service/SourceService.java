package it.luca.streaming.core.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import it.luca.streaming.data.enumeration.DataSourceId;
import it.luca.streaming.core.exception.EmptyInputException;
import it.luca.streaming.core.repository.HDFSAvroWriter;
import it.luca.streaming.core.repository.SourceSpecification;
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
    private HDFSAvroWriter hdfsAvroWriter;

    public <T, A extends SpecificRecord> void store(String input, SourceSpecification<T, A, ?> sourceSpecification) {

        DataSourceId dataSourceId = sourceSpecification.getDataSourceId();
        Class<T> tClass = sourceSpecification.getTClass();
        try {
            if (!StringUtils.isBlank(input)) {
                log.info("{} - Received call. Input:\n\n{}\n", dataSourceId, input);
                T payload = readValue(input, tClass, dataSourceId.getDataSourceType());
                hdfsAvroWriter.write(payload, sourceSpecification);
            } else {
                throw new EmptyInputException(dataSourceId);
            }
        } catch (JsonProcessingException | EmptyInputException e) {
            log.error("{} - Caught exception while processing given input. Stack trace: ", dataSourceId, e);
        } catch (Exception e) {
            log.error("{} - Caught exception while saving data. Stack trace: ", dataSourceId, e);
        }
    }
}