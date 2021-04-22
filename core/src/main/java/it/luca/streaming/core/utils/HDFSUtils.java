package it.luca.streaming.core.utils;

import org.apache.hadoop.fs.Path;

import java.util.function.Function;

public class HDFSUtils {

    public static String joinPaths(String first, String second) {

        Function<String, String> cutFinalSlash = s -> s.endsWith("/") ? s.substring(0, s.length() - 1) : s;
        Function<String, String> cutBeginningSlash = s -> s.startsWith("/") ? s.substring(1) : s;
        return String.join(Path.SEPARATOR, cutFinalSlash.apply(first), cutBeginningSlash.andThen(cutFinalSlash).apply(second));
    }
}
