package it.luca.streaming.core.model;

import it.luca.streaming.core.utils.DatePattern;
import it.luca.streaming.data.enumeration.DataSourceId;
import lombok.Getter;

import java.util.Optional;

import static it.luca.streaming.core.utils.Utils.now;
import static it.luca.streaming.core.utils.Utils.orElse;

@Getter
public class ControllerResponse {

    private final String messageTs;
    private final String messageDt;
    private final String dataSourceId;
    private final String dataSourceType;
    private final String statusCode;
    private final String statusMessage;

    public ControllerResponse(DataSourceId dataSourceId, Exception exception) {

        messageTs = now(DatePattern.DEFAULT_TIMESTAMP);
        messageDt = now(DatePattern.DEFAULT_DATE);
        this.dataSourceId = dataSourceId.name();
        this.dataSourceType = dataSourceId.getDataSourceType().name();
        statusCode = orElse(exception, e -> "KO", "OK");
        statusMessage = orElse(exception, Exception::getMessage, "Message received");
    }
}
