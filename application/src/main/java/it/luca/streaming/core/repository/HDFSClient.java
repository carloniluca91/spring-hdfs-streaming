package it.luca.streaming.core.repository;

import it.luca.streaming.data.enumeration.DataSourceId;
import it.luca.streaming.data.model.common.SourceSpecification;
import it.luca.streaming.data.utils.DatePattern;
import lombok.extern.slf4j.Slf4j;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.specific.SpecificDatumWriter;
import org.apache.avro.specific.SpecificRecord;
import org.apache.avro.tool.ConcatTool;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.permission.FsPermission;
import org.apache.hadoop.security.UserGroupInformation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URI;
import java.security.PrivilegedExceptionAction;
import java.util.List;

import static it.luca.streaming.core.utils.HDFSUtils.fileSizeMb;
import static it.luca.streaming.core.utils.HDFSUtils.joinPaths;
import static it.luca.streaming.data.utils.Utils.*;

@Slf4j
@Component
public class HDFSClient {

    @Value("${hdfs.user}")
    private String hdfsUser;

    @Value("${hdfs.fsUri}")
    private String fsUri;

    @Value("${hdfs.path.landing}")
    private String landingPath;

    @Value("${hdfs.file.maxSizeMb}")
    private int maxFileSizeMb;

    @Value("${hdfs.file.maxNumber}")
    private int maxSmallFilesNumber;

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
     * Write given batch of Avro records on given partition on HDFS
     * @param partitionValue partition value
     * @param avroRecords Avro records batch
     * @param sourceSpecification sourceSpecification
     * @param <A> Avro record type (must extend SpecificRecord)
     * @param <P> partition value type
     * @throws Exception if writing operation fails
     */

    public <A extends SpecificRecord, P> void write(P partitionValue, List<A> avroRecords, SourceSpecification<?, A, P> sourceSpecification)
            throws Exception {

        DataSourceId dataSourceId = sourceSpecification.getDataSourceId();
        userGroupInformation.doAs((PrivilegedExceptionAction<Void>) () -> {

            String tableHDFSPath = joinPaths(landingPath, sourceSpecification.getTableName());
            createPathIfNotExists(tableHDFSPath);

            // Create table's partition path
            DataFileWriter<A> dataFileWriter = new DataFileWriter<>(new SpecificDatumWriter<>(sourceSpecification.getAvroRecordClass()));
            String partitionClause = String.format("%s=%s", sourceSpecification.getPartitionColumnName(), partitionValue);
            String partitionHDFSPath = joinPaths(tableHDFSPath, partitionClause);
            createPathIfNotExists(partitionHDFSPath);

            // Write Avro records
            log.info("{} - Saving {} Avro record(s) on partition {}", dataSourceId, avroRecords.size(), partitionClause);
            String fileName = String.format("%s_%s.avro", dataSourceId.name().toLowerCase(), now(DatePattern.AVRO_FILE_TIMESTAMP));
            Path avroFileHDFSPath = new Path(joinPaths(partitionHDFSPath, fileName));
            dataFileWriter.create(avroRecords.get(0).getSchema(), fileSystem.create(avroFileHDFSPath, false));
            for (A avroRecord: avroRecords) {
                dataFileWriter.append(avroRecord);
            }
            log.info("{} - Saved all of {} Avro record(s) on partition {}", dataSourceId, avroRecords.size(), partitionClause);
            dataFileWriter.close();
            mergeFiles(partitionHDFSPath, dataSourceId);
            return null;
        });
    }

    /**
     * Create path on HDFS with given permissions if it does not exist yet
     * @param pathString path to be created
     * @throws IOException if operation fails
     */

    private void createPathIfNotExists(String pathString) throws IOException {

        Path path = new Path(pathString);
        if (!fileSystem.exists(path)) {
            log.warn("Path {} does not exist yet. Creating now with permissions {}", path, pathPermissions);
            fileSystem.mkdirs(path, FsPermission.valueOf(pathPermissions));
            log.info("Created path {} with permissions {}", path, pathPermissions);
        } else {
            log.info("Path {} exists already", path);
        }
    }

    /**
     * Merge small Avro files within given HDFS path
     * @param partitionPath HDFS path where Avro files stand
     * @param dataSourceId dataSourceId
     * @throws Exception if anything goes wrong
     */

    private void mergeFiles(String partitionPath, DataSourceId dataSourceId) throws Exception {

        // Retrieve number of .avro files on given partitionPath smaller than maxFileSizeMb
        String dataSourceName = dataSourceId.name();
        Path partitionHDFSPath = new Path(partitionPath);
        List<FileStatus> smallAvroFiles = filter(fileSystem.listStatus(partitionHDFSPath),
                x -> x.getPath().getName().endsWith(".avro") & fileSizeMb(x) < maxFileSizeMb);

        int numberOfFilesToMerge = smallAvroFiles.size();
        if (numberOfFilesToMerge >= maxSmallFilesNumber) {

            List<String> pathsOfAvroFilesToMerge = map(smallAvroFiles, x -> x.getPath().toString());
            String mergedFileName = String.format("%s_merged_%s.avro", dataSourceName.toLowerCase(), now(DatePattern.AVRO_FILE_TIMESTAMP));
            String mergedFileHDFSPath = joinPaths(fsUri, partitionPath, mergedFileName);
            pathsOfAvroFilesToMerge.add(mergedFileHDFSPath);
            log.info("{} - Merging {} .avro files into .avro file {}", dataSourceName, numberOfFilesToMerge, mergedFileHDFSPath);

            /* Return codes of ConcatTool operation
            * 0 for success
            * 1 if the schemas of the input files differ
            * 2 if the non-reserved input metadata differs
            * 3 if the input files are encoded with more than one codec.
             */

            int returnCode = new ConcatTool().run(System.in, System.out, System.err, pathsOfAvroFilesToMerge);
            if (returnCode == 0) {
                String mergedFileSizeMb = String.format("%.3f", fileSizeMb(fileSystem.getFileStatus(new Path(mergedFileHDFSPath))));
                log.info("{} - Successfully merged {} .avro files into file {} (size {} MB)",
                        dataSourceName, numberOfFilesToMerge, mergedFileHDFSPath, mergedFileSizeMb);
            } else {

                String errorRationale;
                switch (returnCode) {
                    case 1: errorRationale = "Schema of input files differ"; break;
                    case 2: errorRationale = "Non-reserved input metadata differs"; break;
                    case 3: errorRationale = "Input files are encoded with more than one codec"; break;
                    default: errorRationale = "Unknown"; break;
                }

                log.error("{} - Got an error return code from .avro files merging operation. Return code {} (rationale: {})",
                        dataSourceName, returnCode, errorRationale);
            }

            // Manually delete original .avro files (now being merged)
            List<Path> avroFilesToDelete = map(smallAvroFiles, FileStatus::getPath);
            for (Path pathToDelete: avroFilesToDelete) {
                fileSystem.delete(pathToDelete, true);
            }
        } else {
            log.info("{} - Found not enough .avro files to merge", dataSourceName);
        }
    }
}