package it.luca.streaming.data.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import it.luca.streaming.data.enumeration.DataSourceType;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;

@Slf4j
public class ObjectDeserializer {

    private final static ObjectMapper jsonMapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    private final static ObjectMapper xmlMapper = new XmlMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    public static <T> T readValue(String content, Class<T> valueType, DataSourceType dataSourceType) throws JsonProcessingException {

        String className = valueType.getSimpleName();
        log.info("Deserializing input {} content as instance of {}", dataSourceType, className);
        T payload = (dataSourceType == DataSourceType.JSON) ?
                jsonMapper.readValue(content, valueType) :
                xmlMapper.readValue(content, valueType);

        log.info("Deserialized input {} content as instance of {}", dataSourceType, className);
        return payload;
    }

    public static <T> T readValue(InputStream inputStream, Class<T> valueType, DataSourceType dataSourceType) throws IOException {

        String className = valueType.getSimpleName();
        log.info("Deserializing input {} content as instance of {}", dataSourceType, className);
        T payload = (dataSourceType == DataSourceType.JSON) ?
                jsonMapper.readValue(inputStream, valueType) :
                xmlMapper.readValue(inputStream, valueType);

        log.info("Deserialized input {} content as instance of {}", dataSourceType, className);
        return payload;
    }
}
