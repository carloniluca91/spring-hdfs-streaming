package it.luca.streaming.data.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Utils {

    public static <T> List<T> filter(T[] tArray, Predicate<T> predicate) {

        return filter(Arrays.asList(tArray), predicate);
    }

    public static <T> List<T> filter(List<T> tList, Predicate<T> predicate) {

        return tList.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    public static String gasDay(String date, String pattern) {

        LocalDateTime localDateTime = LocalDateTime.parse(date, DateTimeFormatter.ofPattern(pattern));
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DatePattern.DEFAULT_DATE);
        return localDateTime.getHour() < 6 ?
                localDateTime.minusDays(1).format(dateTimeFormatter) :
                localDateTime.format(dateTimeFormatter);
    }

    public static <T> boolean isPresent(T input) {

        return Optional.ofNullable(input).isPresent();
    }

    public static <T, R> List<R> map(List<T> tList, Function<T, R> function) {

        return tList.stream()
                .map(function)
                .collect(Collectors.toList());
    }

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
