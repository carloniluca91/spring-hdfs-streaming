package it.luca.streaming.core.model;

import it.luca.streaming.core.utils.DatePattern;
import it.luca.streaming.data.enumeration.DataSourceId;
import lombok.Getter;

import java.util.Optional;

import static it.luca.streaming.core.utils.Utils.now;

@Getter
public class ControllerResponse {

    private final String messageTs;
    private final String messageDt;
    private final String dataSourceId;
    private final String dataSourceType;
    private final String statusCode;
    private final String statusMessage;

    public ControllerResponse(DataSourceId dataSourceId, Optional<Exception> optionalException) {

        messageTs = now(DatePattern.DEFAULT_TIMESTAMP);
        messageDt = now(DatePattern.DEFAULT_DATE);
        this.dataSourceId = dataSourceId.name();
        this.dataSourceType = dataSourceId.getDataSourceType().name();
        statusCode = optionalException.isPresent() ? "KO": "OK";
        statusMessage = optionalException.map(Exception::getMessage).orElse("Message received");
    }
}
