package it.luca.streaming.core.model;

import it.luca.streaming.data.enumeration.IngestionOperationCode;
import it.luca.streaming.data.model.common.SourceSpecification;
import it.luca.streaming.data.utils.DatePattern;
import lombok.Data;

import java.sql.Timestamp;

import static it.luca.streaming.data.utils.Utils.*;

@Data
public class IngestionLogRecord {

    private final Timestamp ingestionTs = Timestamp.valueOf(now());
    private final String ingestionDt = now(DatePattern.DEFAULT_DATE);
    private final String dataSourceId;
    private final String dataSourceType;
    private final String inputDataClass;
    private final String avroRecordClass;
    private final String partitionColumn;
    private final String partitionValue;
    private final Integer partitionRecordCount;
    private final String ingestionOperationCode;
    private final String ingestionOperationExceptionClass;
    private final String ingestionOperationExceptionMessage;
    private final Timestamp insertTs = Timestamp.valueOf(now());
    private final String insertDt = now(DatePattern.DEFAULT_DATE);

    public IngestionLogRecord(SourceSpecification<?, ?, ?> sourceSpecification, Exception exception) {

        this(sourceSpecification, null, null, exception);
    }

    public <P> IngestionLogRecord(SourceSpecification<?, ?, P> sourceSpecification, P partitionValue, Integer partitionRecordCount, Exception exception) {

        this.dataSourceId = sourceSpecification.getDataSourceId().name();
        this.dataSourceType = sourceSpecification.getDataSourceType().name();
        inputDataClass = sourceSpecification.getInputDataClass().getName();
        avroRecordClass = sourceSpecification.getAvroRecordClass().getName();
        partitionColumn = sourceSpecification.getPartitionColumnName();
        this.partitionValue = orNull(partitionValue, String::valueOf);
        this.partitionRecordCount = partitionRecordCount;
        ingestionOperationCode = orElse(exception, e -> IngestionOperationCode.KO, IngestionOperationCode.OK).name();
        ingestionOperationExceptionClass = orNull(exception, e -> e.getClass().getName());
        ingestionOperationExceptionMessage = orNull(exception, Exception::getMessage);
    }
}
