package it.luca.streaming.exception;

import it.luca.streaming.enumeration.DataSourceId;
import it.luca.streaming.utils.DatePattern;

import static it.luca.streaming.utils.Utils.now;

public class EmptyInputException extends Throwable {

    public EmptyInputException(DataSourceId dataSourceId) {
        super(String.format("Received empty input from dataSource %s at %s", dataSourceId, now(DatePattern.DEFAULT_TIMESTAMP)));
    }
}
