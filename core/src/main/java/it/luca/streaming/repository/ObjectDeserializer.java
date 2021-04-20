package it.luca.streaming.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import it.luca.streaming.enumeration.DataSourceType;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ObjectDeserializer {

    private final static ObjectMapper objectMapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    private final static XmlMapper xmlMapper = new XmlMapper();

    public static <T> T readValue(String content, Class<T> valueType, DataSourceType dataSourceType) throws JsonProcessingException {

        String className = valueType.getSimpleName();
        log.info("Deserializing input {} content as instance of {}", dataSourceType, className);
        T payload = (dataSourceType == DataSourceType.JSON) ?
                objectMapper.readValue(content, valueType) :
                xmlMapper.readValue(content, valueType);

        log.info("Deserialized input {} content as instance of {}", dataSourceType, className);
        return payload;
    }
}
