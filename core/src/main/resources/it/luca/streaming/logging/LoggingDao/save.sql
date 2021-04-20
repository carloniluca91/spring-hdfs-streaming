INSERT INTO t_ingestion_log PARTITION (month) VALUES (
:record.getLogTs,
:record.getLogMessage,
:record.getLogLevel,
:record.getExceptionClass,
:record.getExceptionMessage,
:record.getLoggerName,
:record.getClassFQName,
:record.getMethodName,
:record.getLineNumber,
:record.getLogDt,
:record.getMonth)