package it.luca.streaming.core.model;

import it.luca.streaming.core.utils.DatePattern;
import it.luca.streaming.data.enumeration.DataSourceId;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.util.Optional;

import static it.luca.streaming.core.utils.Utils.now;

@Getter
public class SourceResponse {

    private final String messageTs;
    private final String messageDt;
    private final String dataSourceId;
    private final String dataSourceType;
    private final String statusCode;
    private final String statusMessage;

    public SourceResponse(DataSourceId dataSourceId, Optional<Throwable> optionalException) {

        messageTs = now(DatePattern.DEFAULT_TIMESTAMP);
        messageDt = now(DatePattern.DEFAULT_DATE);
        this.dataSourceId = dataSourceId.name();
        this.dataSourceType = dataSourceId.getDataSourceType().name();
        statusCode = optionalException.isPresent() ? "KO": "OK";
        statusMessage = optionalException.map(Throwable::getMessage).orElse("Message received");
    }
}
