package it.luca.streaming.core.model;

import it.luca.streaming.data.enumeration.IngestionOperationCode;
import it.luca.streaming.data.model.webdisp.WebdispSpecification;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IngestionLogRecordTest {

    @Test
    void withoutException() {

        IngestionLogRecord ingestionLogRecord = new IngestionLogRecord(new WebdispSpecification(), null);
        assertEquals(IngestionOperationCode.OK.name(), ingestionLogRecord.getIngestionOperationCode());
        assertNull(ingestionLogRecord.getIngestionOperationExceptionClass());
        assertNull(ingestionLogRecord.getIngestionOperationExceptionMessage());
    }

    @Test
    void withException() {

        IllegalArgumentException exception = new IllegalArgumentException("ohiOhi ...");
        IngestionLogRecord ingestionLogRecord = new IngestionLogRecord(new WebdispSpecification(), exception);
        assertEquals(IngestionOperationCode.KO.name(), ingestionLogRecord.getIngestionOperationCode());
        assertNotNull(ingestionLogRecord.getIngestionOperationExceptionClass());
        assertEquals(exception.getClass().getName(), ingestionLogRecord.getIngestionOperationExceptionClass());
        assertNotNull(ingestionLogRecord.getIngestionOperationExceptionMessage());
        assertEquals(exception.getMessage(), ingestionLogRecord.getIngestionOperationExceptionMessage());
    }
}