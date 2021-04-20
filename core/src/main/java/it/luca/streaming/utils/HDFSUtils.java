package it.luca.streaming.utils;

import org.apache.hadoop.fs.Path;

import java.util.function.Function;

public class HDFSUtils {

    public static String joinPaths(String first, String second) {

        Function<String, String> function = s -> s.endsWith("/") ? s.substring(0, s.length() - 1) : s;
        return String.join(Path.SEPARATOR, function.apply(first), function.apply(second));
    }
}
