package it.luca.streaming.core.logging;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.sql.Timestamp;

@Builder
public class LoggingRecord {

    private final Timestamp logTs;
    private final String logMessage;
    private final String logLevel;
    private final String exceptionClass;
    private final String exceptionMessage;
    private final String loggerName;
    private final String classFQName;
    private final String methodName;
    private final Integer lineNumber;
    private final Date logDt;
    private final String month;

    @Getter @Setter
    private Timestamp insertTs;

    @Getter @Setter
    private Date insertDt;
}
