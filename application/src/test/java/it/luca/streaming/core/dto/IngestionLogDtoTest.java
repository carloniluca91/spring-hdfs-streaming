package it.luca.streaming.core.dto;

import it.luca.streaming.data.enumeration.IngestionOperationCode;
import it.luca.streaming.data.model.webdisp.WebdispSpecification;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IngestionLogDtoTest {

    @Test
    void withoutException() {

        IngestionLogDto ingestionLogDto = new IngestionLogDto(new WebdispSpecification(), null);
        assertEquals(IngestionOperationCode.OK.name(), ingestionLogDto.getIngestionOperationCode());
        assertNull(ingestionLogDto.getIngestionOperationExceptionClass());
        assertNull(ingestionLogDto.getIngestionOperationExceptionMessage());
    }

    @Test
    void withException() {

        IllegalArgumentException exception = new IllegalArgumentException("ohiOhi ...");
        IngestionLogDto ingestionLogDto = new IngestionLogDto(new WebdispSpecification(), exception);
        assertEquals(IngestionOperationCode.KO.name(), ingestionLogDto.getIngestionOperationCode());
        assertNotNull(ingestionLogDto.getIngestionOperationExceptionClass());
        assertEquals(exception.getClass().getName(), ingestionLogDto.getIngestionOperationExceptionClass());
        assertNotNull(ingestionLogDto.getIngestionOperationExceptionMessage());
        assertEquals(exception.getMessage(), ingestionLogDto.getIngestionOperationExceptionMessage());
    }
}