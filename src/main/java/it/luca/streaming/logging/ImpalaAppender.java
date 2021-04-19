package it.luca.streaming.logging;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;
import com.cloudera.impala.jdbc.DataSource;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static it.luca.streaming.utils.Utils.now;

public class ImpalaAppender extends AppenderBase<ILoggingEvent> {

    @Getter @Setter
    private String url;

    @Getter @Setter
    private String driverClass;

    @Getter @Setter
    private Integer batchSize;

    private Jdbi jdbi;
    private final List<LoggingRecord> loggingRecords = new ArrayList<>();

    @SneakyThrows
    @Override
    public void start() {

        super.start();
        Class.forName(driverClass);
        DataSource dataSource = new DataSource();
        dataSource.setURL(url);
        jdbi = Jdbi.create(dataSource).installPlugin(new SqlObjectPlugin());

        jdbi.useHandle(handle -> handle.attach(LoggingDao.class).createTable());
    }

    @Override
    public void stop() {

        super.stop();
        if (!loggingRecords.isEmpty()) {
            jdbi.useHandle(handle -> handle.attach(LoggingDao.class).save(loggingRecords));
        }
    }

    @Override
    protected void append(ILoggingEvent iLoggingEvent) {

        StackTraceElement stackTraceElement = iLoggingEvent.getCallerData()[0];
        Optional<Exception> optionalException = Arrays.stream(iLoggingEvent.getArgumentArray())
                .filter(o -> o instanceof Exception)
                .map(o -> (Exception) o)
                .findFirst();

        LoggingRecord loggingRecord = LoggingRecord.builder()
                .logTs(Timestamp.from(Instant.ofEpochMilli(iLoggingEvent.getTimeStamp())))
                .logMessage(iLoggingEvent.getMessage())
                .logLevel(iLoggingEvent.getLevel().toString())
                .exceptionClass(optionalException.map(e -> e.getClass().getName()).orElse(null))
                .exceptionMessage(optionalException.map(Exception::getMessage).orElse(null))
                .loggerName(iLoggingEvent.getLoggerName())
                .classFQName(stackTraceElement.getClassName())
                .methodName(stackTraceElement.getMethodName())
                .lineNumber(stackTraceElement.getLineNumber())
                .logDt(new Date(iLoggingEvent.getTimeStamp()))
                .month(now("yyyy-MM"))
                .build();

        loggingRecords.add(loggingRecord);
        if (loggingRecords.size() >= batchSize) {

            LocalDateTime localDateTime = LocalDateTime.now();
            LocalDate localDate = LocalDate.now();
            loggingRecords.forEach(l -> {
                l.setInsertTs(Timestamp.valueOf(localDateTime));
                l.setInsertDt(Date.valueOf(localDate));
            });

            jdbi.useHandle(handle -> handle.attach(LoggingDao.class).save(loggingRecords));
            loggingRecords.clear();
        }
    }
}
