package it.luca.streaming.core.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Utils {

    public static <T> String mkString(String separator, List<T> values) {

        return values.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(separator));
    }

    public static LocalDateTime now() {

        return LocalDateTime.now();
    }

    public static String now(String pattern) {

        return now().format(DateTimeFormatter.ofPattern(pattern));
    }

    public static <T, R> R orElse(T t, Function<T, R> function, R elseValue) {

        return Optional.ofNullable(t)
                .map(function)
                .orElse(elseValue);
    }

    public static <T, R> R orNull(T t, Function<T, R> function) {

        return orElse(t, function, null);
    }

}
