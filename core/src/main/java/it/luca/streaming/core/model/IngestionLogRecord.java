package it.luca.streaming.core.model;

import it.luca.streaming.core.utils.DatePattern;
import it.luca.streaming.data.enumeration.DataSourceId;
import lombok.Getter;

import java.sql.Timestamp;
import java.util.Optional;

import static it.luca.streaming.core.utils.Utils.now;

@Getter
public class IngestionLogRecord {

    private final Timestamp ingestionTs = Timestamp.valueOf(now());
    private final String ingestionDt = now(DatePattern.DEFAULT_DATE);
    private final String dataSourceId;
    private final String dataSourceType;
    private final String ingestionOperationCode;
    private final String ingestionOperationExceptionClass;
    private final String ingestionOperationExceptionMessage;
    private final Timestamp insertTs = Timestamp.valueOf(now());
    private final String insertDt = now(DatePattern.DEFAULT_DATE);

    public IngestionLogRecord(DataSourceId dataSourceId, Optional<Exception> optionalException) {

        this.dataSourceId = dataSourceId.name();
        this.dataSourceType = dataSourceId.getDataSourceType().name();
        ingestionOperationCode = optionalException.isPresent() ? "KO": "OK";
        ingestionOperationExceptionClass = optionalException.map(exception -> exception.getClass().getName()).orElse(null);
        ingestionOperationExceptionMessage = optionalException.map(Throwable::getMessage).orElse(null);
    }
}
