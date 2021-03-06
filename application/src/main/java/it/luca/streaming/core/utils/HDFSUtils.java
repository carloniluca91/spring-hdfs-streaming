package it.luca.streaming.core.utils;

import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.Path;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

import static it.luca.streaming.data.utils.Utils.map;

public class HDFSUtils {

    /**
     * Join all path fragments in order to build a HDFS path with correct syntax
     * @param path: first path fragment
     * @param paths: other path fragments
     * @return string representing HDFS path (e.g. joinPaths("user", "cloudera") will output "/user/cloudera")
     */

    public static String joinPaths(String path, String... paths) {

        Function<String, String> addBeginningSlash = s -> s.startsWith(Path.SEPARATOR) | s.startsWith("hdfs://") ? s : Path.SEPARATOR + s;
        Function<String, String> cutBeginningSlash = s -> s.startsWith(Path.SEPARATOR) ? s.substring(1) : s;
        Function<String, String> cutFinalSlash = s -> s.endsWith(Path.SEPARATOR) ? s.substring(0, s.length() - 1) : s;
        List<String> allPaths = new ArrayList<>(Collections.singletonList(addBeginningSlash.andThen(cutFinalSlash).apply(path)));
        allPaths.addAll(map(paths, cutBeginningSlash.andThen(cutFinalSlash)));
        return String.join(Path.SEPARATOR, allPaths);
    }

    public static double fileSizeMb(FileStatus fileStatus) {

        double MEGABYTES = 1000000d;
        return fileStatus.getLen() / MEGABYTES;
    }
}
