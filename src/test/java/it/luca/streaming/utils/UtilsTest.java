package it.luca.streaming.utils;

import org.apache.hadoop.fs.Path;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UtilsTest {

    @Test
    void joinPathElements() {

        String firstElement = "/user";
        String secondElement = "/cloudera";
        String[] elements = {firstElement, secondElement, "/applications"};
        assertEquals(new Path(firstElement), Utils.joinPathElements(firstElement));
        assertEquals(new Path("/user/cloudera"), Utils.joinPathElements(firstElement, secondElement));
        assertEquals(new Path("/user/cloudera/applications"), Utils.joinPathElements(elements));
    }
}