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
import org.apache.hadoop.security.UserGroupInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.security.PrivilegedAction;
import java.util.List;

import static it.luca.streaming.utils.HDFSUtils.createPathIfNotExists;
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
    private String pathPermissions;

    @Autowired
    private CDHDao cdhDao;

    public <T, A extends SpecificRecord, P> void write(T payload, SourceSpecification<T, A, P> sourceSpecification) {

        DataSourceId dataSourceId = sourceSpecification.getDataSourceId();
        List<P> partitionValues = sourceSpecification.getPartitionValuesFunction().apply(payload);
        log.info("{} - Found {} partition value(s) for current batch: ({})",
                dataSourceId, partitionValues.size(), mkString("|", partitionValues));

        UserGroupInformation userGroupInformation = UserGroupInformation.createRemoteUser(hdfsUser);
        userGroupInformation.doAs((PrivilegedAction<Object>) () -> {
            try {
                // Open FileSystem connection
                FileSystem fileSystem = FileSystem.get(URI.create(landingRootPath), new Configuration());
                log.info("Initialized both {} and {} instance", UserGroupInformation.class.getName(), FileSystem.class.getName());

                // Create table's root path
                Path tablePath = mergePaths(landingRootPath, sourceSpecification.getTableName());
                createPathIfNotExists(fileSystem, tablePath, pathPermissions);
                DataFileWriter<A> dataFileWriter = new DataFileWriter<>(new SpecificDatumWriter<>(sourceSpecification.getAvroClass()));
                for (P partitionValue: partitionValues) {

                    // Create table's partition path
                    Path tablePlusPartitionPath = mergePaths(tablePath, String.format("%s=%s", sourceSpecification.getPartitionColumn(), partitionValue));
                    createPathIfNotExists(fileSystem, tablePlusPartitionPath, pathPermissions);

                    // Write .avro file containing current partition's records
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

        cdhDao.createTableIfNotExists(sourceSpecification);
        cdhDao.updateMetadata(partitionValues, sourceSpecification);
    }
}
