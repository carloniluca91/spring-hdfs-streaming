package it.luca.streaming.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HDFSUtilsTest {

    private final String FIRST = "/user/cloudera";
    private final String SECOND = "applications";
    private final String expected = String.format("%s/%s", FIRST, SECOND);

    @Test
    public void joinPaths() {

        assertEquals(expected, HDFSUtils.joinPaths(FIRST, SECOND));
    }
}