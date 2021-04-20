package it.luca.streaming.core.exception;

import it.luca.streaming.core.utils.DatePattern;
import it.luca.streaming.core.utils.Utils;
import it.luca.streaming.data.enumeration.DataSourceId;

import static it.luca.streaming.core.utils.Utils.now;

public class EmptyInputException extends Throwable {

    public EmptyInputException(DataSourceId dataSourceId) {
        super(String.format("Received empty input from dataSource %s at %s", dataSourceId, Utils.now(DatePattern.DEFAULT_TIMESTAMP)));
    }
}
