package it.luca.streaming.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.hadoop.fs.Path;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Stream;

@Slf4j
public class Utils {

    public static Path joinPathElements(String... elements) {
        return joinPathElements(Stream.of(elements).map(Path::new).toArray(Path[]::new));
    }

    public static Path joinPathElements(Path... paths) {

        if (Optional.ofNullable(paths).isPresent()) {
            List<Path> pathList = Arrays.asList(paths);
            Path outputPath;
            switch (pathList.size()) {
                case 0: outputPath = null; break;
                case 1: outputPath = pathList.get(0); break;
                case 2: outputPath = Path.mergePaths(pathList.get(0), pathList.get(1)); break;
                default:
                    List<Path> pathSubList = new ArrayList<>(Collections.singletonList(Path.mergePaths(pathList.get(0), pathList.get(1))));
                    pathSubList.addAll(pathList.subList(2, pathList.size()));
                    outputPath = joinPathElements(pathSubList.toArray(new Path[0]));
            }

            return outputPath;
        } else return null;
    }

    public static LocalDateTime now() {

        return LocalDateTime.now();
    }

    public static String now(String pattern) {

        return now().format(DateTimeFormatter.ofPattern(pattern));
    }
}
