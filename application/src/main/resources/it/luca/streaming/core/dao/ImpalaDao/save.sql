INSERT INTO <fqTableName> PARTITION (insert_dt)
VALUES (
:record.getIngestionTs,
:record.getIngestionDt,
:record.getDataSourceId,
:record.getDataSourceType,
:record.getIngestionOperationCode,
:record.getIngestionOperationExceptionClass,
:record.getIngestionOperationExceptionMessage,
now(),
from_timestamp(now(), 'yyyy-MM-dd'))