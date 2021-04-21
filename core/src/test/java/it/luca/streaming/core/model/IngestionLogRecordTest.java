package it.luca.streaming.core.model;

import it.luca.streaming.data.enumeration.DataSourceId;
import it.luca.streaming.data.enumeration.IngestionOperationCode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IngestionLogRecordTest {

    @Test
    void withoutException() {

        IngestionLogRecord ingestionLogRecord = new IngestionLogRecord(DataSourceId.BANCLL_01, null);
        assertEquals(IngestionOperationCode.OK, ingestionLogRecord.getIngestionOperationCode());
        assertNull(ingestionLogRecord.getIngestionOperationExceptionClass());
        assertNull(ingestionLogRecord.getIngestionOperationExceptionMessage());
    }

    @Test
    void withException() {

        IllegalArgumentException exception = new IllegalArgumentException("ohiOhi ...");
        IngestionLogRecord ingestionLogRecord = new IngestionLogRecord(DataSourceId.BANCLL_01, exception);
        assertEquals(IngestionOperationCode.KO, ingestionLogRecord.getIngestionOperationCode());
        assertNotNull(ingestionLogRecord.getIngestionOperationExceptionClass());
        assertEquals(exception.getClass().getName(), ingestionLogRecord.getIngestionOperationExceptionClass());
        assertNotNull(ingestionLogRecord.getIngestionOperationExceptionMessage());
        assertEquals(exception.getMessage(), ingestionLogRecord.getIngestionOperationExceptionMessage());
    }
}