CREATE TABLE IF NOT EXISTS <name>
PARTITIONED BY (<partitionClause>)
ROW FORMAT SERDE 'org.apache.hadoop.hive.serde2.avro.AvroSerDe'
STORED AS INPUTFORMAT 'org.apache.hadoop.hive.ql.io.avro.AvroContainerInputFormat'
OUTPUTFORMAT 'org.apache.hadoop.hive.ql.io.avro.AvroContainerOutputFormat'
LOCATION <location>
TBLPROPERTIES ('avro.schema.url'=<avroSchemaPath>);