package it.luca.streaming.core.repository;

import it.luca.streaming.data.enumeration.DataSourceId;
import it.luca.streaming.data.model.common.SourceSpecification;
import it.luca.streaming.data.utils.DatePattern;
import lombok.extern.slf4j.Slf4j;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.specific.SpecificDatumWriter;
import org.apache.avro.specific.SpecificRecord;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.FileUtil;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.permission.FsPermission;
import org.apache.hadoop.security.UserGroupInformation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URI;
import java.security.PrivilegedExceptionAction;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static it.luca.streaming.core.utils.HDFSUtils.joinPaths;
import static it.luca.streaming.data.utils.Utils.mkString;
import static it.luca.streaming.data.utils.Utils.now;

@Slf4j
@Component
public class HDFSClient {

    @Value("${hdfs.user}")
    private String hdfsUser;

    @Value("${hdfs.fsUri}")
    private String fsUri;

    @Value("${hdfs.path.landing}")
    private String landingPath;

    @Value("${hdfs.path.maxFiles}")
    private int maxFiles;

    @Value("${hdfs.path.permissions}")
    private String pathPermissions;

    private FileSystem fileSystem;
    private UserGroupInformation userGroupInformation;

    @PostConstruct
    private void init() throws IOException {

        String ENV_VARIABLE = "HADOOP_USER_NAME";
        System.setProperty(ENV_VARIABLE, hdfsUser);

        // Initialize FileSystem instance and UserGroupInformation for client access to HDFS
        fileSystem = FileSystem.get(URI.create(fsUri), new Configuration());
        userGroupInformation = UserGroupInformation.createRemoteUser(hdfsUser);
        log.info("Set environment variable {} to {}, initalized both {} instance and {} instance",
                ENV_VARIABLE, hdfsUser, FileSystem.class.getSimpleName(), UserGroupInformation.class.getSimpleName());
    }

    /**
     * Convert input data into some Avro records and store them on HDFS
     * @param payload: input data (deserialized)
     * @param sourceSpecification: source's specification
     * @param <T>: type of input data
     * @param <A>: type of Avro records
     * @param <P>: type of source's partition values
     */

    public <T, A extends SpecificRecord, P> void write(T payload, SourceSpecification<T, A, P> sourceSpecification) throws Exception {

        DataSourceId dataSourceId = sourceSpecification.getDataSourceId();
        List<P> partitionValues = sourceSpecification.getPartitionValues(payload);
        log.info("{} - Found {} partition value(s) within current batch: ({})",
                dataSourceId, partitionValues.size(), mkString("|", partitionValues));

        userGroupInformation.doAs((PrivilegedExceptionAction<Void>) () -> {

            String tablePath = joinPaths(landingPath, sourceSpecification.getTableName());
            createPathIfNotExists(fileSystem, tablePath);
            for (P partitionValue: partitionValues) {

                // Create table's partition path and write Avro record(s) belonging to such partition
                DataFileWriter<A> dataFileWriter = new DataFileWriter<>(new SpecificDatumWriter<>(sourceSpecification.getAvroRecordClass()));
                String partitionPath = joinPaths(tablePath, String.format("%s=%s", sourceSpecification.getPartitionColumnName(), partitionValue));
                createPathIfNotExists(fileSystem, partitionPath);
                String fileName = String.format("%s_%s.avro", dataSourceId.name().toLowerCase(), now(DatePattern.AVRO_FILE_TIMESTAMP));
                Path avroFilePath = new Path(joinPaths(partitionPath, fileName));

                // Retrieve Avro record(s) for such partition
                List<A> avroRecords = sourceSpecification.getAvroRecordsForPartition(payload, partitionValue);
                log.info("{} - Saving {} Avro record(s) on partition {}", dataSourceId, avroRecords.size(), partitionPath);
                dataFileWriter.create(avroRecords.get(0).getSchema(), fileSystem.create(avroFilePath, false));
                for (A avroRecord: avroRecords) {
                    dataFileWriter.append(avroRecord);
                }
                log.info("{} - Saved all of {} Avro record(s) on partition {}", dataSourceId, avroRecords.size(), partitionPath);
                dataFileWriter.close();
                mergePartitionFiles(partitionPath, dataSourceId, fileSystem);
            }
            return null;
        });
    }

    /**
     * Create path on HDFS with given permissions if it does not exist yet
     * @param fileSystem: instance of FileSystem
     * @param pathString: path to be created
     * @throws IOException if operation fails
     */

    private void createPathIfNotExists(FileSystem fileSystem, String pathString) throws IOException {

        Path path = new Path(pathString);
        if (!fileSystem.exists(path)) {
            log.warn("Path {} does not exist yet. Creating now with permissions {}", path, pathPermissions);
            fileSystem.mkdirs(path, FsPermission.valueOf(pathPermissions));
            log.info("Created path {} with permissions {}", path, pathPermissions);
        } else {
            log.info("Path {} exists already", path);
        }
    }

    private void mergePartitionFiles(String partitionPath, DataSourceId dataSourceId, FileSystem fileSystem) throws IOException {

        // Retrieve number of .avro files on given partitionPath
        Path partitionPathP = new Path(partitionPath);
        List<FileStatus> avroFileStatuses = Arrays.stream(fileSystem.listStatus(partitionPathP))
                .filter(x -> x.getPath().getName().endsWith(".avro"))
                .collect(Collectors.toList());
        int numberOfAvroFiles = avroFileStatuses.size();

        // If more than the maximum number of partition files
        if (numberOfAvroFiles > maxFiles) {

            /*
             * Merge .avro files
             * Use FileUtil.copyMerge(..., ..., ..., ..., deleteSource = false, ..., ...) in order to
             * merge multiple .avro files into a single .avro file on same partitionPath, mantaining input partitionPath.
             * This forces us to manually delete original .avro files right afterwards merging operation
             */

            String mergedFileName = String.format("%s_merged_%s.avro", dataSourceId.name().toLowerCase(), now(DatePattern.AVRO_FILE_TIMESTAMP));
            Path mergedFilePath = new Path(joinPaths(partitionPath, mergedFileName));
            log.info("Found {} .avro files within partition {}. Merging into file {}", numberOfAvroFiles, partitionPath, mergedFileName);
            FileUtil.copyMerge(fileSystem, partitionPathP, fileSystem, mergedFilePath, false, fileSystem.getConf(), null);
            String mergedFileSizeMB = String.format("%.3f", fileSystem.getFileStatus(mergedFilePath).getLen() / 1000000d);
            log.info("Merged {} .avro files from partition {} into file {} (size {} MB)", numberOfAvroFiles, partitionPath, mergedFileName,
                    mergedFileSizeMB);

            // Manually delete .avro files
            List<Path> pathsToDelete = avroFileStatuses.stream()
                    .map(FileStatus::getPath)
                    .collect(Collectors.toList());
            for (Path pathToDelete: pathsToDelete) {
                fileSystem.delete(pathToDelete, true);
            }
        } else {
            log.info("Detected {} files within partition {}. Maximum is {}, not merging them", numberOfAvroFiles, partitionPath, maxFiles);
        }
    }
}
