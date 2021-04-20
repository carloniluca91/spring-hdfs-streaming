CREATE TABLE IF NOT EXISTS t_ingestion_log (

    log_ts TIMESTAMP COMMENT 'Log event timestamp',
    log_message STRING,
    log_level STRING,
    exception_class_name STRING COMMENT 'Fully qualified exception class name',
    exception_message STRING,
    logger_name STRING COMMENT 'Logger name',
    class_name STRING COMMENT 'Fully qualified class name that issued log event',
    method_name STRING COMMENT 'Method that issued log event',
    line_number INT COMMENT 'Log event line number',
    log_dt STRING COMMENT 'Log event date'
)
PARTITIONED BY (month STRING)
STORED AS PARQUET