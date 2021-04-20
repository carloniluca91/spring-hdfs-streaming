package it.luca.streaming.data.utils;

import it.luca.streaming.data.enumeration.DataSourceType;
import it.luca.streaming.data.model.PeopleWrapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;


import static it.luca.streaming.data.utils.ObjectDeserializer.readValue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ObjectDeserializerTest {

    private InputStream inputStream(String fileName) {

        return getClass().getClassLoader().getResourceAsStream(fileName);
    }

    @Test
    public void bancll01() throws IOException {

        PeopleWrapper peopleWrapper = readValue(inputStream("bancll01.xml"), PeopleWrapper.class, DataSourceType.XML);
        assertNotNull(peopleWrapper.getDtBusinessDate());
        assertNotNull(peopleWrapper.getPeople());
        assertFalse(peopleWrapper.getPeople().isEmpty());
    }
}