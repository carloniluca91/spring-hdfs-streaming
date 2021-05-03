CREATE TABLE IF NOT EXISTS @impala.dbName@.@impala.log.tableName@ (

    ingestion_ts TIMESTAMP COMMENT 'Timestamp of ingested batch',
    ingestion_dt STRING COMMENT 'Date of ingested batch (pattern yyyy-MM-dd)',
    datasource_id STRING,
    datasource_type STRING COMMENT 'JSON|XML',
    input_data_class STRING COMMENT 'FQ class name of input data',
    avro_record_class STRING COMMENT 'FQ class name of Avro record',
    partition_column STRING COMMENT 'Partition column name',
    partition_value STRING COMMENT 'Partition column value',
    partition_record_count INT COMMENT 'Number of Avro records stored on this partition'
    ingestion_operation_cd STRING COMMENT 'OK|KO',
    ingestion_operation_exception STRING COMMENT 'FQ class name of ingestion exception',
    ingestion_operation_exception_msg STRING COMMENT 'Message of ingestion exception',
    insert_ts TIMESTAMP COMMENT 'Record insert timestamp'
)
PARTITIONED BY (insert_dt STRING COMMENT 'Record insert date. Pattern yyyy-MM-dd')
STORED AS PARQUET