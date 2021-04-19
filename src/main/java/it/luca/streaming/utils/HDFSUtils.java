package it.luca.streaming.utils;

import org.apache.hadoop.fs.Path;

public class HDFSUtils {

    public static Path mergePaths(String first, String second) {

        return Path.mergePaths(new Path(first), new Path(second));
    }

    public static Path mergePaths(Path first, String second) {

        return Path.mergePaths(first, new Path(second));
    }
}
