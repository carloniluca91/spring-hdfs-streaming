package it.luca.streaming.core.utils;

import org.apache.hadoop.fs.Path;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HDFSUtilsTest {

    @Test
    void joinPaths() {

        final String FIRST = "user";
        final String SECOND = "cloudera";
        final String SEPARATOR = Path.SEPARATOR;
        final String expected = SEPARATOR + FIRST + SEPARATOR + SECOND;

        assertEquals(expected, HDFSUtils.joinPaths(FIRST, SECOND));
        assertEquals(expected, HDFSUtils.joinPaths(SEPARATOR + FIRST, SECOND));
        assertEquals(expected, HDFSUtils.joinPaths(FIRST, SEPARATOR + SECOND));
        assertEquals(expected, HDFSUtils.joinPaths(SEPARATOR + FIRST + SEPARATOR, SECOND));
        assertEquals(expected, HDFSUtils.joinPaths(FIRST, SEPARATOR + SECOND + SEPARATOR));
    }
}