package it.luca.streaming.core.utils;

import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {

    @Test
    void orElse() {

        String elseValue = "elseValue";
        String firstOutput = Utils.orElse((String) null, String::toLowerCase, elseValue);
        assertEquals(elseValue, firstOutput);

        String input = "ilBudello";
        Function<String, String> function = String::toUpperCase;
        String secondOutput = Utils.orElse(input, function, elseValue);
        assertEquals(function.apply(input), secondOutput);
    }

    @Test
    void orNull() {

        String firstOutput = Utils.orNull((String) null, String::toLowerCase);
        assertNull(firstOutput);

        String input = "ilBudello";
        Function<String, String> function = String::toUpperCase;
        String secondOutput = Utils.orNull(input, function);
        assertNotNull(secondOutput);
        assertEquals(function.apply(input), secondOutput);
    }
}