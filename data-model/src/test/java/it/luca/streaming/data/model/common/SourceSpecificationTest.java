package it.luca.streaming.data.model.common;

import it.luca.streaming.data.enumeration.DataSourceId;
import org.apache.avro.specific.SpecificRecord;

import java.io.IOException;
import java.nio.file.Paths;

import static it.luca.streaming.data.utils.ObjectDeserializer.readValue;

public abstract class SourceSpecificationTest<T, A extends SpecificRecord, P> {

    protected T instance;
    protected SourceSpecification<T, A, P> specification;

    public SourceSpecificationTest(String fileName,
                                   Class<T> tClass,
                                   DataSourceId dataSourceId,
                                   SourceSpecification<T, A, P> specification)
            throws IOException {

        String filePath = Paths.get("samples", fileName).toString();
        instance = readValue(getClass().getClassLoader().getResourceAsStream(filePath), tClass, dataSourceId.getDataSourceType());
        this.specification = specification;
    }

    public abstract void assertReadValue();

    public abstract void getDistinctPartitionValues();

    public abstract void getPartitionRecordsMap();
}