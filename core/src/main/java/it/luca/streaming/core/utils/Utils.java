package it.luca.streaming.core.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Utils {

    public static String className(Class<?> clazz) {
        return clazz.getSimpleName();
    }

    public static <T> String mkString(String separator, List<T> values) {

        return toStreamOf(values, String::valueOf)
                .collect(Collectors.joining(separator));
    }

    public static LocalDateTime now() {

        return LocalDateTime.now();
    }

    public static String now(String pattern) {

        return now().format(DateTimeFormatter.ofPattern(pattern));
    }

    public static <T, R> R orNull(T t, Function<T, R> trFunction) {

        return Optional.ofNullable(t)
                .map(trFunction)
                .orElse(null);
    }

    public static <T, R> Stream<R> toStreamOf(List<T> values, Function<T, R> trFunction) {

        return values.stream().map(trFunction);
    }
}
