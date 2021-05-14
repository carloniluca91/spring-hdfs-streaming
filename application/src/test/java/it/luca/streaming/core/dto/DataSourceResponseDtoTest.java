package it.luca.streaming.core.dto;

import it.luca.streaming.data.enumeration.IngestionOperationCode;
import it.luca.streaming.data.model.webdisp.WebdispSpecification;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class DataSourceResponseDtoTest {

    private final WebdispSpecification specification = new WebdispSpecification();

    @Test
    void withException() {

        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("ohiOhi ...");
        DataSourceResponseDto dataSourceResponseDto = new DataSourceResponseDto(specification, illegalArgumentException);
        assertEquals(IngestionOperationCode.KO, dataSourceResponseDto.getIngestionOperationCode());
        assertEquals(illegalArgumentException.getMessage(), dataSourceResponseDto.getIngestionOperationMessage());
    }

    @Test
    void withoutException() {

        DataSourceResponseDto dataSourceResponseDto = new DataSourceResponseDto(specification, null);
        assertEquals(IngestionOperationCode.OK, dataSourceResponseDto.getIngestionOperationCode());
        assertNotNull(dataSourceResponseDto.getIngestionOperationMessage());
    }
}