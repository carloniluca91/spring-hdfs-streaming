package it.luca.streaming.repository;

import it.luca.streaming.dao.CDHDao;
import it.luca.streaming.enumeration.DataSourceId;
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
import java.security.PrivilegedAction;
import java.util.List;

import static it.luca.streaming.utils.HDFSUtils.mergePaths;
import static it.luca.streaming.utils.Utils.mkString;
import static it.luca.streaming.utils.Utils.now;

@Slf4j
@Component
public class HDFSAvroWriter {

    @Value("${hdfs.user}")
    private String hdfsUser;

    @Value("${hdfs.path.landingRoot}")
    private String landingRootPath;

    @Value("${hdfs.path.permissions}")
    private String hdfsPathPermissions;

    public <T, A extends SpecificRecord, P> void write(T payload, SourceSpecification<T, A, P> sourceSpecification) {

        DataSourceId dataSourceId = sourceSpecification.getDataSourceId();
        List<P> partitionValues = sourceSpecification.getPartitionValuesFunction().apply(payload);
        log.info("{} - Found {} partition value(s) for current batch: ({})",
                dataSourceId, partitionValues.size(), mkString("|", partitionValues));

        UserGroupInformation userGroupInformation = UserGroupInformation.createRemoteUser(hdfsUser);
        userGroupInformation.doAs((PrivilegedAction<Object>) () -> {
            try {
                FileSystem fileSystem = FileSystem.get(URI.create(landingRootPath), new Configuration());
                log.info("Initialized both {} and {} instance", UserGroupInformation.class.getName(), FileSystem.class.getName());
                Path tablePath = mergePaths(landingRootPath, sourceSpecification.getTableName());
                createPathIfNotExists(fileSystem, tablePath);
                DataFileWriter<A> dataFileWriter = new DataFileWriter<>(new SpecificDatumWriter<>(sourceSpecification.getAvroClass()));
                for (P partitionValue: partitionValues) {

                    Path tablePlusPartitionPath = mergePaths(tablePath, String.format("%s=%s", sourceSpecification.getPartitionColumn(), partitionValue));
                    createPathIfNotExists(fileSystem, tablePlusPartitionPath);
                    Path fullFilePath = mergePaths(tablePlusPartitionPath, String.format("batch_%s.avro", now("yyyy_MM_dd_HH_mm_ss")));
                    List<A> avroRecords = sourceSpecification.getPartitionValueRecords().apply(payload, partitionValue);
                    log.info("{} - Saving {} Avro record(s) at HDFS path {}", dataSourceId, avroRecords.size(), tablePlusPartitionPath);
                    dataFileWriter.create(avroRecords.get(0).getSchema(), fileSystem.create(fullFilePath, false));
                    for (A avroRecord: avroRecords) {
                        dataFileWriter.append(avroRecord);
                    }
                    log.info("{} - Saved all of {} Avro record(s) at HDFS path {}", dataSourceId, avroRecords.size(), tablePlusPartitionPath);
                }
                dataFileWriter.close();
            } catch (IOException e) {
                log.error("{} - Caught exception while saving data. Stack trace:", dataSourceId, e);
            }
            return null;
        });

        CDHDao cdhDao = new CDHDao();
        cdhDao.createTableIfNotExists(sourceSpecification);
        cdhDao.updateMetadata(partitionValues, sourceSpecification);
    }

    private void createPathIfNotExists(FileSystem fileSystem, Path path) throws IOException {

        if (!fileSystem.exists(path)) {
            log.warn("Path {} does not exist yet. Creating now with permissions {}", path, hdfsPathPermissions);
            fileSystem.mkdirs(path, FsPermission.valueOf(hdfsPathPermissions));
            log.info("Created path {} with permissions {}", path, hdfsPathPermissions);
        } else {
            log.info("Path {} exists already", path);
        }
    }
}
