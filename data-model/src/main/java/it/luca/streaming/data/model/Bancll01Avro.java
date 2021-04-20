package it.luca.streaming.data.model;

import org.apache.avro.specific.SpecificData;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class Bancll01Avro extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 5391683148896601066L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Bancll01Avro\",\"namespace\":\"it.luca.streaming.data\",\"fields\":[{\"name\":\"first_name\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"null\"]},{\"name\":\"last_name\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"null\"]},{\"name\":\"birth_date\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"null\"]},{\"name\":\"insert_ts\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"insert_dt\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<Bancll01Avro> ENCODER =
      new BinaryMessageEncoder<Bancll01Avro>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<Bancll01Avro> DECODER =
      new BinaryMessageDecoder<Bancll01Avro>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   */
  public static BinaryMessageDecoder<Bancll01Avro> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   */
  public static BinaryMessageDecoder<Bancll01Avro> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<Bancll01Avro>(MODEL$, SCHEMA$, resolver);
  }

  /** Serializes this Bancll01Avro to a ByteBuffer. */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /** Deserializes a Bancll01Avro from a ByteBuffer. */
  public static Bancll01Avro fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

   private java.lang.String first_name;
   private java.lang.String last_name;
   private java.lang.String birth_date;
   private java.lang.String insert_ts;
   private java.lang.String insert_dt;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public Bancll01Avro() {}

  /**
   * All-args constructor.
   * @param first_name The new value for first_name
   * @param last_name The new value for last_name
   * @param birth_date The new value for birth_date
   * @param insert_ts The new value for insert_ts
   * @param insert_dt The new value for insert_dt
   */
  public Bancll01Avro(java.lang.String first_name, java.lang.String last_name, java.lang.String birth_date, java.lang.String insert_ts, java.lang.String insert_dt) {
    this.first_name = first_name;
    this.last_name = last_name;
    this.birth_date = birth_date;
    this.insert_ts = insert_ts;
    this.insert_dt = insert_dt;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return first_name;
    case 1: return last_name;
    case 2: return birth_date;
    case 3: return insert_ts;
    case 4: return insert_dt;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: first_name = (java.lang.String)value$; break;
    case 1: last_name = (java.lang.String)value$; break;
    case 2: birth_date = (java.lang.String)value$; break;
    case 3: insert_ts = (java.lang.String)value$; break;
    case 4: insert_dt = (java.lang.String)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'first_name' field.
   * @return The value of the 'first_name' field.
   */
  public java.lang.String getFirstName() {
    return first_name;
  }

  /**
   * Sets the value of the 'first_name' field.
   * @param value the value to set.
   */
  public void setFirstName(java.lang.String value) {
    this.first_name = value;
  }

  /**
   * Gets the value of the 'last_name' field.
   * @return The value of the 'last_name' field.
   */
  public java.lang.String getLastName() {
    return last_name;
  }

  /**
   * Sets the value of the 'last_name' field.
   * @param value the value to set.
   */
  public void setLastName(java.lang.String value) {
    this.last_name = value;
  }

  /**
   * Gets the value of the 'birth_date' field.
   * @return The value of the 'birth_date' field.
   */
  public java.lang.String getBirthDate() {
    return birth_date;
  }

  /**
   * Sets the value of the 'birth_date' field.
   * @param value the value to set.
   */
  public void setBirthDate(java.lang.String value) {
    this.birth_date = value;
  }

  /**
   * Gets the value of the 'insert_ts' field.
   * @return The value of the 'insert_ts' field.
   */
  public java.lang.String getInsertTs() {
    return insert_ts;
  }

  /**
   * Sets the value of the 'insert_ts' field.
   * @param value the value to set.
   */
  public void setInsertTs(java.lang.String value) {
    this.insert_ts = value;
  }

  /**
   * Gets the value of the 'insert_dt' field.
   * @return The value of the 'insert_dt' field.
   */
  public java.lang.String getInsertDt() {
    return insert_dt;
  }

  /**
   * Sets the value of the 'insert_dt' field.
   * @param value the value to set.
   */
  public void setInsertDt(java.lang.String value) {
    this.insert_dt = value;
  }

  /**
   * Creates a new Bancll01Avro RecordBuilder.
   * @return A new Bancll01Avro RecordBuilder
   */
  public static Bancll01Avro.Builder newBuilder() {
    return new Bancll01Avro.Builder();
  }

  /**
   * Creates a new Bancll01Avro RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new Bancll01Avro RecordBuilder
   */
  public static Bancll01Avro.Builder newBuilder(Bancll01Avro.Builder other) {
    return new Bancll01Avro.Builder(other);
  }

  /**
   * Creates a new Bancll01Avro RecordBuilder by copying an existing Bancll01Avro instance.
   * @param other The existing instance to copy.
   * @return A new Bancll01Avro RecordBuilder
   */
  public static Bancll01Avro.Builder newBuilder(Bancll01Avro other) {
    return new Bancll01Avro.Builder(other);
  }

  /**
   * RecordBuilder for Bancll01Avro instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Bancll01Avro>
    implements org.apache.avro.data.RecordBuilder<Bancll01Avro> {

    private java.lang.String first_name;
    private java.lang.String last_name;
    private java.lang.String birth_date;
    private java.lang.String insert_ts;
    private java.lang.String insert_dt;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(Bancll01Avro.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.first_name)) {
        this.first_name = data().deepCopy(fields()[0].schema(), other.first_name);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.last_name)) {
        this.last_name = data().deepCopy(fields()[1].schema(), other.last_name);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.birth_date)) {
        this.birth_date = data().deepCopy(fields()[2].schema(), other.birth_date);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.insert_ts)) {
        this.insert_ts = data().deepCopy(fields()[3].schema(), other.insert_ts);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.insert_dt)) {
        this.insert_dt = data().deepCopy(fields()[4].schema(), other.insert_dt);
        fieldSetFlags()[4] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing Bancll01Avro instance
     * @param other The existing instance to copy.
     */
    private Builder(Bancll01Avro other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.first_name)) {
        this.first_name = data().deepCopy(fields()[0].schema(), other.first_name);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.last_name)) {
        this.last_name = data().deepCopy(fields()[1].schema(), other.last_name);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.birth_date)) {
        this.birth_date = data().deepCopy(fields()[2].schema(), other.birth_date);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.insert_ts)) {
        this.insert_ts = data().deepCopy(fields()[3].schema(), other.insert_ts);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.insert_dt)) {
        this.insert_dt = data().deepCopy(fields()[4].schema(), other.insert_dt);
        fieldSetFlags()[4] = true;
      }
    }

    /**
      * Gets the value of the 'first_name' field.
      * @return The value.
      */
    public java.lang.String getFirstName() {
      return first_name;
    }

    /**
      * Sets the value of the 'first_name' field.
      * @param value The value of 'first_name'.
      * @return This builder.
      */
    public Bancll01Avro.Builder setFirstName(java.lang.String value) {
      validate(fields()[0], value);
      this.first_name = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'first_name' field has been set.
      * @return True if the 'first_name' field has been set, false otherwise.
      */
    public boolean hasFirstName() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'first_name' field.
      * @return This builder.
      */
    public Bancll01Avro.Builder clearFirstName() {
      first_name = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'last_name' field.
      * @return The value.
      */
    public java.lang.String getLastName() {
      return last_name;
    }

    /**
      * Sets the value of the 'last_name' field.
      * @param value The value of 'last_name'.
      * @return This builder.
      */
    public Bancll01Avro.Builder setLastName(java.lang.String value) {
      validate(fields()[1], value);
      this.last_name = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'last_name' field has been set.
      * @return True if the 'last_name' field has been set, false otherwise.
      */
    public boolean hasLastName() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'last_name' field.
      * @return This builder.
      */
    public Bancll01Avro.Builder clearLastName() {
      last_name = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'birth_date' field.
      * @return The value.
      */
    public java.lang.String getBirthDate() {
      return birth_date;
    }

    /**
      * Sets the value of the 'birth_date' field.
      * @param value The value of 'birth_date'.
      * @return This builder.
      */
    public Bancll01Avro.Builder setBirthDate(java.lang.String value) {
      validate(fields()[2], value);
      this.birth_date = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'birth_date' field has been set.
      * @return True if the 'birth_date' field has been set, false otherwise.
      */
    public boolean hasBirthDate() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'birth_date' field.
      * @return This builder.
      */
    public Bancll01Avro.Builder clearBirthDate() {
      birth_date = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'insert_ts' field.
      * @return The value.
      */
    public java.lang.String getInsertTs() {
      return insert_ts;
    }

    /**
      * Sets the value of the 'insert_ts' field.
      * @param value The value of 'insert_ts'.
      * @return This builder.
      */
    public Bancll01Avro.Builder setInsertTs(java.lang.String value) {
      validate(fields()[3], value);
      this.insert_ts = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'insert_ts' field has been set.
      * @return True if the 'insert_ts' field has been set, false otherwise.
      */
    public boolean hasInsertTs() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'insert_ts' field.
      * @return This builder.
      */
    public Bancll01Avro.Builder clearInsertTs() {
      insert_ts = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'insert_dt' field.
      * @return The value.
      */
    public java.lang.String getInsertDt() {
      return insert_dt;
    }

    /**
      * Sets the value of the 'insert_dt' field.
      * @param value The value of 'insert_dt'.
      * @return This builder.
      */
    public Bancll01Avro.Builder setInsertDt(java.lang.String value) {
      validate(fields()[4], value);
      this.insert_dt = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'insert_dt' field has been set.
      * @return True if the 'insert_dt' field has been set, false otherwise.
      */
    public boolean hasInsertDt() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'insert_dt' field.
      * @return This builder.
      */
    public Bancll01Avro.Builder clearInsertDt() {
      insert_dt = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Bancll01Avro build() {
      try {
        Bancll01Avro record = new Bancll01Avro();
        record.first_name = fieldSetFlags()[0] ? this.first_name : (java.lang.String) defaultValue(fields()[0]);
        record.last_name = fieldSetFlags()[1] ? this.last_name : (java.lang.String) defaultValue(fields()[1]);
        record.birth_date = fieldSetFlags()[2] ? this.birth_date : (java.lang.String) defaultValue(fields()[2]);
        record.insert_ts = fieldSetFlags()[3] ? this.insert_ts : (java.lang.String) defaultValue(fields()[3]);
        record.insert_dt = fieldSetFlags()[4] ? this.insert_dt : (java.lang.String) defaultValue(fields()[4]);
        return record;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<Bancll01Avro>
    WRITER$ = (org.apache.avro.io.DatumWriter<Bancll01Avro>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<Bancll01Avro>
    READER$ = (org.apache.avro.io.DatumReader<Bancll01Avro>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}
