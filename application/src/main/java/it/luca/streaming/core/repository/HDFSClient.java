package it.luca.streaming.core.repository;

import it.luca.streaming.data.model.common.SourceSpecification;
import it.luca.streaming.data.utils.DatePattern;
import it.luca.streaming.data.enumeration.DataSourceId;
import lombok.extern.slf4j.Slf4j;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.specific.SpecificDatumWriter;
import org.apache.avro.specific.SpecificRecord;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.permission.FsPermission;
import org.apache.hadoop.security.UserGroupInformation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.security.PrivilegedExceptionAction;
import java.util.List;

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

    @Value("${hdfs.path.permissions}")
    private String pathPermissions;

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

        // Initialize FileSystem instance and UserGroupInformation for client access to HDFS
        FileSystem fileSystem = FileSystem.get(URI.create(fsUri), new Configuration());
        log.info("Initialized {} instance", FileSystem.class.getName());
        UserGroupInformation userGroupInformation = UserGroupInformation.createRemoteUser(hdfsUser);
        userGroupInformation.doAs((PrivilegedExceptionAction<Void>) () -> {

            String tablePath = joinPaths(landingPath, sourceSpecification.getTableName());
            createPathIfNotExists(fileSystem, tablePath);
            DataFileWriter<A> dataFileWriter = new DataFileWriter<>(new SpecificDatumWriter<>(sourceSpecification.getAvroRecordClass()));
            for (P partitionValue: partitionValues) {

                // Create table's partition path and write Avro record(s) belonging to such partition
                String tablePlusPartitionPath = joinPaths(tablePath, String.format("%s=%s", sourceSpecification.getPartitionColumnName(), partitionValue));
                createPathIfNotExists(fileSystem, tablePlusPartitionPath);
                String fileName = String.format("%s_%s.avro", dataSourceId.name().toLowerCase(), now(DatePattern.AVRO_FILE_TIMESTAMP));
                Path avroFilePath = new Path(joinPaths(tablePlusPartitionPath, fileName));

                // Retrieve Avro record(s) for such partition
                List<A> avroRecords = sourceSpecification.getAvroRecordsForPartition(payload, partitionValue);
                log.info("{} - Saving {} Avro record(s) at HDFS path {}", dataSourceId, avroRecords.size(), tablePlusPartitionPath);
                dataFileWriter.create(avroRecords.get(0).getSchema(), fileSystem.create(avroFilePath, false));
                for (A avroRecord: avroRecords) {
                    dataFileWriter.append(avroRecord);
                }
                log.info("{} - Saved all of {} Avro record(s) at HDFS path {}", dataSourceId, avroRecords.size(), tablePlusPartitionPath);
            }

            dataFileWriter.close();
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
}
