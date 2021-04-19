package it.luca.streaming.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Utils {

    public static <T> String mkString(String separator, List<T> values) {

        return toStringStream(values).collect(Collectors.joining(separator));
    }

    public static LocalDateTime now() {

        return LocalDateTime.now();
    }

    public static String now(String pattern) {

        return now().format(DateTimeFormatter.ofPattern(pattern));
    }

    public static <T> Stream<String> toStringStream(List<T> values) {

        return values.stream().map(String::valueOf);
    }
}
