package it.luca.streaming.core.model;

import it.luca.streaming.data.enumeration.DataSourceId;
import it.luca.streaming.data.enumeration.IngestionOperationCode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControllerResponseTest {

    @Test
    void withException() {

        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("ohiOhi ...");
        ControllerResponse controllerResponse = new ControllerResponse(DataSourceId.BANCLL_01, illegalArgumentException);
        assertEquals(IngestionOperationCode.KO, controllerResponse.getIngestionOperationCode());
        assertEquals(illegalArgumentException.getMessage(), controllerResponse.getIngestionOperationMessage());
    }

    @Test
    void withoutException() {

        ControllerResponse controllerResponse = new ControllerResponse(DataSourceId.BANCLL_01, null);
        assertEquals(IngestionOperationCode.KO, controllerResponse.getIngestionOperationCode());
        assertNotNull(controllerResponse.getIngestionOperationMessage());
    }
}