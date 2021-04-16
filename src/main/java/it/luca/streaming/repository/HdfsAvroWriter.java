package it.luca.streaming.repository;

import it.luca.streaming.enumeration.DataSourceId;
import it.luca.streaming.utils.Utils;
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
import java.util.stream.Collectors;

@Slf4j
@Component
public class HdfsAvroWriter {

    @Value("${hdfs.rootPath}")
    private String landingRootPath;

    @Value("${hdfs.user}")
    private String hdfsUser;

    private final Configuration configuration = new Configuration();

    public <T, A extends SpecificRecord, P> void write(T payload, SourceSpecification<T, A, P> sourceSpecification) {

        DataSourceId dataSourceId = sourceSpecification.getDataSourceId();
        List<P> partitioningValues = sourceSpecification.getTToPartitionValues().apply(payload);
        log.info("{} - Found {} partitioning value(s) for current batch: ({})",
                dataSourceId,
                partitioningValues.size(),
                partitioningValues.stream().map(String::valueOf)
                        .collect(Collectors.joining("|")));

        String hdfsSourceRoot = String.join("/", landingRootPath, dataSourceId.toString().toLowerCase());
        String partitioningColumn = sourceSpecification.getPartitioningColumn();
        UserGroupInformation userGroupInformation = UserGroupInformation.createRemoteUser(hdfsUser);
        userGroupInformation.doAs((PrivilegedAction<Object>) () -> {
            try {
                DataFileWriter<A> dataFileWriter = new DataFileWriter<>(new SpecificDatumWriter<>(sourceSpecification.getAvroClass()));
                FileSystem fileSystem = FileSystem.get(URI.create(landingRootPath), configuration);
                for (P partitioningValue: partitioningValues) {

                    String partitionFolder = String.format("%s=%s", partitioningColumn, partitioningValue);
                    String partitionPath = String.join("/", hdfsSourceRoot, partitionFolder);
                    fileSystem.mkdirs(new Path(partitionPath), FsPermission.valueOf("-rwx-rw-r-"));
                    String filePath = String.join("/", partitionPath, String.format("batch_%s.avro", Utils.now("yyyy_MM_dd_HH_mm_ss")));
                    List<A> avroRecords = sourceSpecification.getTToAvroRecordList().apply(payload, partitioningValue);
                    log.info("{} - Saving {} Avro record(s) (partition {}) at HDFS path {}",
                            dataSourceId, avroRecords.size(), partitionFolder, partitionPath);

                    dataFileWriter.create(avroRecords.get(0).getSchema(), fileSystem.create(new Path(filePath)));
                    for (A avroRecord: avroRecords) {
                        dataFileWriter.append(avroRecord);
                    }

                    log.info("{} - Saved all of {} Avro record(s) (partition {}) at HDFS path {}",
                            dataSourceId, avroRecords.size(), partitionFolder, partitionPath);
                    dataFileWriter.close();
                }
            } catch (IOException e) {
                log.error("{} - Caught exception while saving data. Stack trace:", dataSourceId, e);
            }
            return null;
        });
    }
}
