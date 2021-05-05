INSERT OVERWRITE @impala.db.name@.@impala.log.tableName@ PARTITION (insert_dt)
SELECT *
FROM @impala.db.name@.@impala.log.tableName@
WHERE insert_dt = :today