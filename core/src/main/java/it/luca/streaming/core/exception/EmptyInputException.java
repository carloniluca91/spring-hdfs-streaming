package it.luca.streaming.core.exception;

import it.luca.streaming.data.utils.DatePattern;
import it.luca.streaming.data.utils.Utils;
import it.luca.streaming.data.enumeration.DataSourceId;

import static it.luca.streaming.data.utils.Utils.now;

public class EmptyInputException extends Exception {

    public EmptyInputException(DataSourceId dataSourceId) {
        super(String.format("Received empty input from dataSource %s at %s", dataSourceId, Utils.now(DatePattern.DEFAULT_TIMESTAMP)));
    }
}
