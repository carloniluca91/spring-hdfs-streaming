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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URI;
import java.security.PrivilegedAction;
import java.util.List;
import java.util.stream.Collectors;

import static it.luca.streaming.utils.Utils.joinPathElements;
import static it.luca.streaming.utils.Utils.now;

@Slf4j
@Component
public class HdfsAvroWriter {

    @Value("${hdfs.path.landingRoot}")
    private String landingRootPath;

    @Value("${hdfs.user}")
    private String hdfsUser;

    @Autowired
    private CDHDao cdhDao;

    private FileSystem fileSystem;
    private UserGroupInformation userGroupInformation;

    @PostConstruct
    private void init() throws IOException {

        fileSystem = FileSystem.get(URI.create(landingRootPath), new Configuration());
        userGroupInformation = UserGroupInformation.createRemoteUser(hdfsUser);
        log.info("Initialized both {} and {} instance", FileSystem.class.getName(), UserGroupInformation.class.getName());
    }

    public <T, A extends SpecificRecord, P> void write(T payload, SourceSpecification<T, A, P> sourceSpecification) {

        DataSourceId dataSourceId = sourceSpecification.getDataSourceId();
        List<P> partitionValues = sourceSpecification.getPartitionValuesFunction().apply(payload);
        log.info("{} - Found {} partitioning value(s) for current batch: ({})", dataSourceId, partitionValues.size(),
                partitionValues.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining("|")));

        userGroupInformation.doAs((PrivilegedAction<Object>) () -> {
            try {
                Path tablePath = joinPathElements(landingRootPath, sourceSpecification.getTableName());
                createPathIfNotExists(tablePath);
                DataFileWriter<A> dataFileWriter = new DataFileWriter<>(new SpecificDatumWriter<>(sourceSpecification.getAvroClass()));
                for (P partitioningValue: partitionValues) {

                    Path partitionPath = new Path(String.format("%s=%s", sourceSpecification.getPartitionColumn(), partitioningValue));
                    Path tablePlusPartitionPath = joinPathElements(tablePath, partitionPath);
                    createPathIfNotExists(tablePlusPartitionPath);
                    Path fullFilePath = joinPathElements(tablePlusPartitionPath, new Path(String.format("batch_%s.avro", now("yyyy_MM_dd_HH_mm_ss"))));
                    List<A> avroRecords = sourceSpecification.getPartitionValueRecords().apply(payload, partitioningValue);
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

    private boolean createPathIfNotExists(Path path) throws IOException {

        if (!fileSystem.exists(path)) {
            log.warn("Path {} does not exist yet. Creating now", path);
            fileSystem.mkdirs(path, FsPermission.valueOf("-rwx-r-x-r-x"));
            return true;
        } else {
            log.info("Path {} exists already", path);
            return false;
        }
    }
}
