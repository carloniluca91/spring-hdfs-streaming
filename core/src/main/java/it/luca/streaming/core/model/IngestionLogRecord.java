package it.luca.streaming.core.model;

import it.luca.streaming.data.utils.DatePattern;
import it.luca.streaming.data.enumeration.DataSourceId;
import it.luca.streaming.data.enumeration.IngestionOperationCode;
import lombok.Getter;

import java.sql.Timestamp;

import static it.luca.streaming.data.utils.Utils.*;

@Getter
public class IngestionLogRecord {

    private final Timestamp ingestionTs = Timestamp.valueOf(now());
    private final String ingestionDt = now(DatePattern.DEFAULT_DATE);
    private final String dataSourceId;
    private final String dataSourceType;
    private final IngestionOperationCode ingestionOperationCode;
    private final String ingestionOperationExceptionClass;
    private final String ingestionOperationExceptionMessage;

    public IngestionLogRecord(DataSourceId dataSourceId, Exception exception) {

        this.dataSourceId = dataSourceId.name();
        this.dataSourceType = dataSourceId.getDataSourceType().name();
        ingestionOperationCode = orElse(exception, e -> IngestionOperationCode.KO, IngestionOperationCode.OK);
        ingestionOperationExceptionClass = orNull(exception, e -> e.getClass().getName());
        ingestionOperationExceptionMessage = orNull(exception, Exception::getMessage);
    }
}
