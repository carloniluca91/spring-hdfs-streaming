package it.luca.streaming.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.permission.FsPermission;

import java.io.IOException;

@Slf4j
public class HDFSUtils {

    public static void createPathIfNotExists(FileSystem fileSystem, Path path, String pathPermissions) throws IOException {

        if (!fileSystem.exists(path)) {
            log.warn("Path {} does not exist yet. Creating now with permissions {}", path, pathPermissions);
            fileSystem.mkdirs(path, FsPermission.valueOf(pathPermissions));
            log.info("Created path {} with permissions {}", path, pathPermissions);
        } else {
            log.info("Path {} exists already", path);
        }
    }

    public static Path mergePaths(String first, String second) {

        return Path.mergePaths(new Path(first), new Path(second));
    }

    public static Path mergePaths(Path first, String second) {

        Path a = new Path(second);
        return Path.mergePaths(first, new Path(second));
    }
}
