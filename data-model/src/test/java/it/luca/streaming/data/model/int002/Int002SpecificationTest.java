package it.luca.streaming.data.model.int002;

import it.luca.streaming.data.enumeration.DataSourceId;
import it.luca.streaming.data.model.common.SourceSpecificationTest;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class Int002SpecificationTest extends SourceSpecificationTest<Int002Wrapper, Int002Avro, String> {

    public Int002SpecificationTest() throws IOException {
        super("int002.json", Int002Wrapper.class, DataSourceId.INT002, new Int002Specification());
    }

    @Test
    @Override
    public void assertReadValue() {

        assertNotNull(instance);
        assertNotNull(instance.getCicli());
        assertFalse(instance.getCicli().isEmpty());
    }

    @Test
    @Override
    public void getDistinctPartitionValues() {

        List<String> partitionValues = specification.getDistinctPartitionValues(instance);

    }

    @Test
    @Override
    public void getPartitionRecordsMap() {

    }
}