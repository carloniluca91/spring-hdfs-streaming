package it.luca.streaming.core.utils;

import org.apache.hadoop.fs.Path;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HDFSUtils {

    /**
     * Join all path fragments in order to build a HDFS path with correct syntax
     * @param path: first path fragment
     * @param paths: other path fragments
     * @return string representing HDFS path (e.g. joinPaths("user", "cloudera") will output "/user/cloudera")
     */

    public static String joinPaths(String path, String... paths) {

        Function<String, String> addBeginningSlash = s -> s.startsWith(Path.SEPARATOR) ? s : Path.SEPARATOR + s;
        Function<String, String> cutBeginningSlash = s -> s.startsWith(Path.SEPARATOR) ? s.substring(1) : s;
        Function<String, String> cutFinalSlash = s -> s.endsWith(Path.SEPARATOR) ? s.substring(0, s.length() - 1) : s;
        List<String> allPaths = new ArrayList<>(Collections.singletonList(addBeginningSlash.andThen(cutFinalSlash).apply(path)));
        allPaths.addAll(Stream.of(paths)
                .map(cutBeginningSlash.andThen(cutFinalSlash))
                .collect(Collectors.toList()));
        return String.join(Path.SEPARATOR, allPaths);
    }
}
