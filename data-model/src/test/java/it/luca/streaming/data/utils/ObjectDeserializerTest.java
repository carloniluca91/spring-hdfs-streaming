package it.luca.streaming.data.utils;

import it.luca.streaming.data.enumeration.DataSourceType;
import it.luca.streaming.data.model.webdisp.WebdispWrapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ObjectDeserializerTest {

    private InputStream inputStream(String fileName) {

        String filePath = Paths.get("samples", fileName).toString();
        return getClass().getClassLoader().getResourceAsStream(filePath);
    }

    @Test
    public void webdisp() throws IOException {

        WebdispWrapper webdispWrapper = ObjectDeserializer.readValue(inputStream("webdisp.xml"), WebdispWrapper.class, DataSourceType.XML);
        assertNotNull(webdispWrapper);
        assertNotNull(webdispWrapper.getDataOraInvio());
        assertNotNull(webdispWrapper.getNomine());
        assertFalse(webdispWrapper.getNomine().isEmpty());
    }
}