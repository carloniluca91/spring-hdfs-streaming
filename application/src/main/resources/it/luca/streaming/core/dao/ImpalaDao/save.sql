INSERT INTO @impala.dbName@.@impala.log.tableName@ PARTITION (insert_dt)
VALUES (
:record.getIngestionTs,
:record.getIngestionDt,
:record.getDataSourceId,
:record.getDataSourceType,
:record.getInputDataClass,
:record.getAvroRecordClass,
:record.getPartitionColumn,
:record.getPartitionValue,
:record.getPartitionRecordCount,
:record.getIngestionOperationCode,
:record.getIngestionOperationExceptionClass,
:record.getIngestionOperationExceptionMessage,
:record.getInsertTs,
:record.getInsertDt)