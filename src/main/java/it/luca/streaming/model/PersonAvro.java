package it.luca.streaming.model;

import org.apache.avro.specific.SpecificData;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class PersonAvro extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
    private static final long serialVersionUID = 7893264874248163998L;
    public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"PersonAvro\",\"namespace\":\"it.luca.streaming.model\",\"fields\":[{\"name\":\"firstName\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"null\"]},{\"name\":\"lastName\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"null\"]},{\"name\":\"birthDate\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"null\"]},{\"name\":\"InsertTs\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"InsertDt\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}}]}");
    public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

    private static SpecificData MODEL$ = new SpecificData();

    private static final BinaryMessageEncoder<PersonAvro> ENCODER =
            new BinaryMessageEncoder<PersonAvro>(MODEL$, SCHEMA$);

    private static final BinaryMessageDecoder<PersonAvro> DECODER =
            new BinaryMessageDecoder<PersonAvro>(MODEL$, SCHEMA$);

    /**
     * Return the BinaryMessageDecoder instance used by this class.
     */
    public static BinaryMessageDecoder<PersonAvro> getDecoder() {
        return DECODER;
    }

    /**
     * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
     * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
     */
    public static BinaryMessageDecoder<PersonAvro> createDecoder(SchemaStore resolver) {
        return new BinaryMessageDecoder<PersonAvro>(MODEL$, SCHEMA$, resolver);
    }

    /** Serializes this PersonAvro to a ByteBuffer. */
    public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
        return ENCODER.encode(this);
    }

    /** Deserializes a PersonAvro from a ByteBuffer. */
    public static PersonAvro fromByteBuffer(
            java.nio.ByteBuffer b) throws java.io.IOException {
        return DECODER.decode(b);
    }

    private java.lang.String firstName;
    private java.lang.String lastName;
    private java.lang.String birthDate;
    private java.lang.String InsertTs;
    private java.lang.String InsertDt;

    /**
     * Default constructor.  Note that this does not initialize fields
     * to their default values from the schema.  If that is desired then
     * one should use <code>newBuilder()</code>.
     */
    public PersonAvro() {}

    /**
     * All-args constructor.
     * @param firstName The new value for firstName
     * @param lastName The new value for lastName
     * @param birthDate The new value for birthDate
     * @param InsertTs The new value for InsertTs
     * @param InsertDt The new value for InsertDt
     */
    public PersonAvro(java.lang.String firstName, java.lang.String lastName, java.lang.String birthDate, java.lang.String InsertTs, java.lang.String InsertDt) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.InsertTs = InsertTs;
        this.InsertDt = InsertDt;
    }

    public org.apache.avro.Schema getSchema() { return SCHEMA$; }
    // Used by DatumWriter.  Applications should not call.
    public java.lang.Object get(int field$) {
        switch (field$) {
            case 0: return firstName;
            case 1: return lastName;
            case 2: return birthDate;
            case 3: return InsertTs;
            case 4: return InsertDt;
            default: throw new org.apache.avro.AvroRuntimeException("Bad index");
        }
    }

    // Used by DatumReader.  Applications should not call.
    @SuppressWarnings(value="unchecked")
    public void put(int field$, java.lang.Object value$) {
        switch (field$) {
            case 0: firstName = (java.lang.String)value$; break;
            case 1: lastName = (java.lang.String)value$; break;
            case 2: birthDate = (java.lang.String)value$; break;
            case 3: InsertTs = (java.lang.String)value$; break;
            case 4: InsertDt = (java.lang.String)value$; break;
            default: throw new org.apache.avro.AvroRuntimeException("Bad index");
        }
    }

    /**
     * Gets the value of the 'firstName' field.
     * @return The value of the 'firstName' field.
     */
    public java.lang.String getFirstName() {
        return firstName;
    }

    /**
     * Sets the value of the 'firstName' field.
     * @param value the value to set.
     */
    public void setFirstName(java.lang.String value) {
        this.firstName = value;
    }

    /**
     * Gets the value of the 'lastName' field.
     * @return The value of the 'lastName' field.
     */
    public java.lang.String getLastName() {
        return lastName;
    }

    /**
     * Sets the value of the 'lastName' field.
     * @param value the value to set.
     */
    public void setLastName(java.lang.String value) {
        this.lastName = value;
    }

    /**
     * Gets the value of the 'birthDate' field.
     * @return The value of the 'birthDate' field.
     */
    public java.lang.String getBirthDate() {
        return birthDate;
    }

    /**
     * Sets the value of the 'birthDate' field.
     * @param value the value to set.
     */
    public void setBirthDate(java.lang.String value) {
        this.birthDate = value;
    }

    /**
     * Gets the value of the 'InsertTs' field.
     * @return The value of the 'InsertTs' field.
     */
    public java.lang.String getInsertTs() {
        return InsertTs;
    }

    /**
     * Sets the value of the 'InsertTs' field.
     * @param value the value to set.
     */
    public void setInsertTs(java.lang.String value) {
        this.InsertTs = value;
    }

    /**
     * Gets the value of the 'InsertDt' field.
     * @return The value of the 'InsertDt' field.
     */
    public java.lang.String getInsertDt() {
        return InsertDt;
    }

    /**
     * Sets the value of the 'InsertDt' field.
     * @param value the value to set.
     */
    public void setInsertDt(java.lang.String value) {
        this.InsertDt = value;
    }

    /**
     * Creates a new PersonAvro RecordBuilder.
     * @return A new PersonAvro RecordBuilder
     */
    public static it.luca.streaming.model.PersonAvro.Builder newBuilder() {
        return new it.luca.streaming.model.PersonAvro.Builder();
    }

    /**
     * Creates a new PersonAvro RecordBuilder by copying an existing Builder.
     * @param other The existing builder to copy.
     * @return A new PersonAvro RecordBuilder
     */
    public static it.luca.streaming.model.PersonAvro.Builder newBuilder(it.luca.streaming.model.PersonAvro.Builder other) {
        return new it.luca.streaming.model.PersonAvro.Builder(other);
    }

    /**
     * Creates a new PersonAvro RecordBuilder by copying an existing PersonAvro instance.
     * @param other The existing instance to copy.
     * @return A new PersonAvro RecordBuilder
     */
    public static it.luca.streaming.model.PersonAvro.Builder newBuilder(it.luca.streaming.model.PersonAvro other) {
        return new it.luca.streaming.model.PersonAvro.Builder(other);
    }

    /**
     * RecordBuilder for PersonAvro instances.
     */
    public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<PersonAvro>
            implements org.apache.avro.data.RecordBuilder<PersonAvro> {

        private java.lang.String firstName;
        private java.lang.String lastName;
        private java.lang.String birthDate;
        private java.lang.String InsertTs;
        private java.lang.String InsertDt;

        /** Creates a new Builder */
        private Builder() {
            super(SCHEMA$);
        }

        /**
         * Creates a Builder by copying an existing Builder.
         * @param other The existing Builder to copy.
         */
        private Builder(it.luca.streaming.model.PersonAvro.Builder other) {
            super(other);
            if (isValidValue(fields()[0], other.firstName)) {
                this.firstName = data().deepCopy(fields()[0].schema(), other.firstName);
                fieldSetFlags()[0] = true;
            }
            if (isValidValue(fields()[1], other.lastName)) {
                this.lastName = data().deepCopy(fields()[1].schema(), other.lastName);
                fieldSetFlags()[1] = true;
            }
            if (isValidValue(fields()[2], other.birthDate)) {
                this.birthDate = data().deepCopy(fields()[2].schema(), other.birthDate);
                fieldSetFlags()[2] = true;
            }
            if (isValidValue(fields()[3], other.InsertTs)) {
                this.InsertTs = data().deepCopy(fields()[3].schema(), other.InsertTs);
                fieldSetFlags()[3] = true;
            }
            if (isValidValue(fields()[4], other.InsertDt)) {
                this.InsertDt = data().deepCopy(fields()[4].schema(), other.InsertDt);
                fieldSetFlags()[4] = true;
            }
        }

        /**
         * Creates a Builder by copying an existing PersonAvro instance
         * @param other The existing instance to copy.
         */
        private Builder(it.luca.streaming.model.PersonAvro other) {
            super(SCHEMA$);
            if (isValidValue(fields()[0], other.firstName)) {
                this.firstName = data().deepCopy(fields()[0].schema(), other.firstName);
                fieldSetFlags()[0] = true;
            }
            if (isValidValue(fields()[1], other.lastName)) {
                this.lastName = data().deepCopy(fields()[1].schema(), other.lastName);
                fieldSetFlags()[1] = true;
            }
            if (isValidValue(fields()[2], other.birthDate)) {
                this.birthDate = data().deepCopy(fields()[2].schema(), other.birthDate);
                fieldSetFlags()[2] = true;
            }
            if (isValidValue(fields()[3], other.InsertTs)) {
                this.InsertTs = data().deepCopy(fields()[3].schema(), other.InsertTs);
                fieldSetFlags()[3] = true;
            }
            if (isValidValue(fields()[4], other.InsertDt)) {
                this.InsertDt = data().deepCopy(fields()[4].schema(), other.InsertDt);
                fieldSetFlags()[4] = true;
            }
        }

        /**
         * Gets the value of the 'firstName' field.
         * @return The value.
         */
        public java.lang.String getFirstName() {
            return firstName;
        }

        /**
         * Sets the value of the 'firstName' field.
         * @param value The value of 'firstName'.
         * @return This builder.
         */
        public it.luca.streaming.model.PersonAvro.Builder setFirstName(java.lang.String value) {
            validate(fields()[0], value);
            this.firstName = value;
            fieldSetFlags()[0] = true;
            return this;
        }

        /**
         * Checks whether the 'firstName' field has been set.
         * @return True if the 'firstName' field has been set, false otherwise.
         */
        public boolean hasFirstName() {
            return fieldSetFlags()[0];
        }


        /**
         * Clears the value of the 'firstName' field.
         * @return This builder.
         */
        public it.luca.streaming.model.PersonAvro.Builder clearFirstName() {
            firstName = null;
            fieldSetFlags()[0] = false;
            return this;
        }

        /**
         * Gets the value of the 'lastName' field.
         * @return The value.
         */
        public java.lang.String getLastName() {
            return lastName;
        }

        /**
         * Sets the value of the 'lastName' field.
         * @param value The value of 'lastName'.
         * @return This builder.
         */
        public it.luca.streaming.model.PersonAvro.Builder setLastName(java.lang.String value) {
            validate(fields()[1], value);
            this.lastName = value;
            fieldSetFlags()[1] = true;
            return this;
        }

        /**
         * Checks whether the 'lastName' field has been set.
         * @return True if the 'lastName' field has been set, false otherwise.
         */
        public boolean hasLastName() {
            return fieldSetFlags()[1];
        }


        /**
         * Clears the value of the 'lastName' field.
         * @return This builder.
         */
        public it.luca.streaming.model.PersonAvro.Builder clearLastName() {
            lastName = null;
            fieldSetFlags()[1] = false;
            return this;
        }

        /**
         * Gets the value of the 'birthDate' field.
         * @return The value.
         */
        public java.lang.String getBirthDate() {
            return birthDate;
        }

        /**
         * Sets the value of the 'birthDate' field.
         * @param value The value of 'birthDate'.
         * @return This builder.
         */
        public it.luca.streaming.model.PersonAvro.Builder setBirthDate(java.lang.String value) {
            validate(fields()[2], value);
            this.birthDate = value;
            fieldSetFlags()[2] = true;
            return this;
        }

        /**
         * Checks whether the 'birthDate' field has been set.
         * @return True if the 'birthDate' field has been set, false otherwise.
         */
        public boolean hasBirthDate() {
            return fieldSetFlags()[2];
        }


        /**
         * Clears the value of the 'birthDate' field.
         * @return This builder.
         */
        public it.luca.streaming.model.PersonAvro.Builder clearBirthDate() {
            birthDate = null;
            fieldSetFlags()[2] = false;
            return this;
        }

        /**
         * Gets the value of the 'InsertTs' field.
         * @return The value.
         */
        public java.lang.String getInsertTs() {
            return InsertTs;
        }

        /**
         * Sets the value of the 'InsertTs' field.
         * @param value The value of 'InsertTs'.
         * @return This builder.
         */
        public it.luca.streaming.model.PersonAvro.Builder setInsertTs(java.lang.String value) {
            validate(fields()[3], value);
            this.InsertTs = value;
            fieldSetFlags()[3] = true;
            return this;
        }

        /**
         * Checks whether the 'InsertTs' field has been set.
         * @return True if the 'InsertTs' field has been set, false otherwise.
         */
        public boolean hasInsertTs() {
            return fieldSetFlags()[3];
        }


        /**
         * Clears the value of the 'InsertTs' field.
         * @return This builder.
         */
        public it.luca.streaming.model.PersonAvro.Builder clearInsertTs() {
            InsertTs = null;
            fieldSetFlags()[3] = false;
            return this;
        }

        /**
         * Gets the value of the 'InsertDt' field.
         * @return The value.
         */
        public java.lang.String getInsertDt() {
            return InsertDt;
        }

        /**
         * Sets the value of the 'InsertDt' field.
         * @param value The value of 'InsertDt'.
         * @return This builder.
         */
        public it.luca.streaming.model.PersonAvro.Builder setInsertDt(java.lang.String value) {
            validate(fields()[4], value);
            this.InsertDt = value;
            fieldSetFlags()[4] = true;
            return this;
        }

        /**
         * Checks whether the 'InsertDt' field has been set.
         * @return True if the 'InsertDt' field has been set, false otherwise.
         */
        public boolean hasInsertDt() {
            return fieldSetFlags()[4];
        }


        /**
         * Clears the value of the 'InsertDt' field.
         * @return This builder.
         */
        public it.luca.streaming.model.PersonAvro.Builder clearInsertDt() {
            InsertDt = null;
            fieldSetFlags()[4] = false;
            return this;
        }

        @Override
        @SuppressWarnings("unchecked")
        public PersonAvro build() {
            try {
                PersonAvro record = new PersonAvro();
                record.firstName = fieldSetFlags()[0] ? this.firstName : (java.lang.String) defaultValue(fields()[0]);
                record.lastName = fieldSetFlags()[1] ? this.lastName : (java.lang.String) defaultValue(fields()[1]);
                record.birthDate = fieldSetFlags()[2] ? this.birthDate : (java.lang.String) defaultValue(fields()[2]);
                record.InsertTs = fieldSetFlags()[3] ? this.InsertTs : (java.lang.String) defaultValue(fields()[3]);
                record.InsertDt = fieldSetFlags()[4] ? this.InsertDt : (java.lang.String) defaultValue(fields()[4]);
                return record;
            } catch (java.lang.Exception e) {
                throw new org.apache.avro.AvroRuntimeException(e);
            }
        }
    }

    @SuppressWarnings("unchecked")
    private static final org.apache.avro.io.DatumWriter<PersonAvro>
            WRITER$ = (org.apache.avro.io.DatumWriter<PersonAvro>)MODEL$.createDatumWriter(SCHEMA$);

    @Override public void writeExternal(java.io.ObjectOutput out)
            throws java.io.IOException {
        WRITER$.write(this, SpecificData.getEncoder(out));
    }

    @SuppressWarnings("unchecked")
    private static final org.apache.avro.io.DatumReader<PersonAvro>
            READER$ = (org.apache.avro.io.DatumReader<PersonAvro>)MODEL$.createDatumReader(SCHEMA$);

    @Override public void readExternal(java.io.ObjectInput in)
            throws java.io.IOException {
        READER$.read(this, SpecificData.getDecoder(in));
    }

}
