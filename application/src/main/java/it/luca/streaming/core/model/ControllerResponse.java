package it.luca.streaming.core.model;

import it.luca.streaming.data.utils.DatePattern;
import it.luca.streaming.data.enumeration.DataSourceId;
import it.luca.streaming.data.enumeration.IngestionOperationCode;
import lombok.Getter;

import static it.luca.streaming.data.utils.Utils.now;
import static it.luca.streaming.data.utils.Utils.orElse;

@Getter
public class ControllerResponse {

    private final String messageTs;
    private final String messageDt;
    private final String dataSourceId;
    private final String dataSourceType;
    private final IngestionOperationCode ingestionOperationCode;
    private final String ingestionOperationMessage;

    public ControllerResponse(DataSourceId dataSourceId, Exception exception) {

        messageTs = now(DatePattern.DEFAULT_TIMESTAMP);
        messageDt = now(DatePattern.DEFAULT_DATE);
        this.dataSourceId = dataSourceId.name();
        this.dataSourceType = dataSourceId.getDataSourceType().name();
        ingestionOperationCode = orElse(exception, e -> IngestionOperationCode.KO, IngestionOperationCode.OK);
        ingestionOperationMessage = orElse(exception, Exception::getMessage, "Message received");
    }
}
