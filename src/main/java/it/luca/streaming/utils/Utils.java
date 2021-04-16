package it.luca.streaming.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utils {

    public static LocalDateTime now() {

        return LocalDateTime.now();
    }

    public static String now(String pattern) {

        return now().format(DateTimeFormatter.ofPattern(pattern));
    }
}
