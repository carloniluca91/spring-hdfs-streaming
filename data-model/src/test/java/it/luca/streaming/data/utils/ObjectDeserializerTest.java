package it.luca.streaming.data.utils;

import it.luca.streaming.data.enumeration.DataSourceType;
import it.luca.streaming.data.model.Bancll01XML;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ObjectDeserializerTest {

    private InputStream inputStream(String fileName) {

        return getClass().getClassLoader().getResourceAsStream(fileName);
    }

    @Test
    public void bancll01() throws IOException {

        Bancll01XML bancll01XML = ObjectDeserializer.readValue(inputStream("bancll01.xml"), Bancll01XML.class, DataSourceType.XML);
        assertNotNull(bancll01XML.getDtBusinessDate());
        assertNotNull(bancll01XML.getPeople());
        assertFalse(bancll01XML.getPeople().isEmpty());
    }
}