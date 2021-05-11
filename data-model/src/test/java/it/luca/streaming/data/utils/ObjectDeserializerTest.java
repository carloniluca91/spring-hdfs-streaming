package it.luca.streaming.data.utils;

import it.luca.streaming.data.enumeration.DataSourceType;
import it.luca.streaming.data.model.int002.Int002Wrapper;
import it.luca.streaming.data.model.jarvis.JarvisWrapper;
import it.luca.streaming.data.model.webdisp.WebdispWrapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;

import static it.luca.streaming.data.utils.ObjectDeserializer.readValue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ObjectDeserializerTest {

    private InputStream inputStream(String fileName) {

        String filePath = Paths.get("samples", fileName).toString();
        return getClass().getClassLoader().getResourceAsStream(filePath);
    }

    @Test
    void int002() throws IOException {

        Int002Wrapper int002Wrapper = readValue(inputStream("int002.json"), Int002Wrapper.class, DataSourceType.JSON);
        assertNotNull(int002Wrapper);
        assertNotNull(int002Wrapper.getCicli());
        assertFalse(int002Wrapper.getCicli().isEmpty());
    }
}