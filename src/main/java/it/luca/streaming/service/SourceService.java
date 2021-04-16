package it.luca.streaming.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import it.luca.streaming.enumeration.DataSourceId;
import it.luca.streaming.exception.EmptyInputException;
import it.luca.streaming.repository.HdfsAvroWriter;
import it.luca.streaming.repository.SourceDeserializer;
import it.luca.streaming.repository.SourceSpecification;
import lombok.extern.slf4j.Slf4j;
import org.apache.avro.specific.SpecificRecord;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SourceService {

    @Autowired
    private HdfsAvroWriter hdfsAvroWriter;

    public <T, A extends SpecificRecord> void store(String input, SourceSpecification<T, A, ?> sourceSpecification) {

        DataSourceId dataSourceId = sourceSpecification.getDataSourceId();
        Class<T> tClass = sourceSpecification.getTClass();
        try {
            if (!StringUtils.isBlank(input)) {
                log.info("{} - Received call. Input:\n\n{}\n", dataSourceId, input);
                T payload = SourceDeserializer.readValue(input, tClass, dataSourceId.getDataSourceType());
                hdfsAvroWriter.write(payload, sourceSpecification);
            } else {
                throw new EmptyInputException(dataSourceId);
            }
        } catch (JsonProcessingException | EmptyInputException e) {
            log.warn("{} - Caught exception while processing given input. Stack trace: ", dataSourceId, e);
        }
    }
}
