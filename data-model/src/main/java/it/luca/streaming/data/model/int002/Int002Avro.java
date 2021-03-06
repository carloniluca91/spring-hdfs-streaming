package it.luca.streaming.data.model.int002;

import org.apache.avro.specific.SpecificData;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class Int002Avro extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 410985956894290697L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Int002Avro\",\"namespace\":\"it.luca.streaming.data.model.int002\",\"fields\":[{\"name\":\"giorno_ora_riferimento\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"null\"]},{\"name\":\"uDM1\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"null\"]},{\"name\":\"uDM2\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"null\"]},{\"name\":\"uDM3\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"null\"]},{\"name\":\"uDM4\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"null\"]},{\"name\":\"descrizione\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"null\"]},{\"name\":\"tipologia\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"null\"]},{\"name\":\"codice_remi\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"null\"]},{\"name\":\"valore_1\",\"type\":[\"double\",\"null\"]},{\"name\":\"progressivo_1\",\"type\":[\"double\",\"null\"]},{\"name\":\"valore_2\",\"type\":[\"double\",\"null\"]},{\"name\":\"progressivo_2\",\"type\":[\"double\",\"null\"]},{\"name\":\"PCS\",\"type\":[\"double\",\"null\"]},{\"name\":\"valore_3\",\"type\":[\"double\",\"null\"]},{\"name\":\"progressivo_3\",\"type\":[\"double\",\"null\"]},{\"name\":\"valore_4\",\"type\":[\"double\",\"null\"]},{\"name\":\"progressivo_4\",\"type\":[\"double\",\"null\"]},{\"name\":\"pCS25_0\",\"type\":[\"double\",\"null\"]},{\"name\":\"wobbe25_15\",\"type\":[\"double\",\"null\"]},{\"name\":\"wobbe25_0\",\"type\":[\"double\",\"null\"]},{\"name\":\"ts_inserimento\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"dt_inserimento\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<Int002Avro> ENCODER =
      new BinaryMessageEncoder<Int002Avro>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<Int002Avro> DECODER =
      new BinaryMessageDecoder<Int002Avro>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   */
  public static BinaryMessageDecoder<Int002Avro> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   */
  public static BinaryMessageDecoder<Int002Avro> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<Int002Avro>(MODEL$, SCHEMA$, resolver);
  }

  /** Serializes this Int002Avro to a ByteBuffer. */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /** Deserializes a Int002Avro from a ByteBuffer. */
  public static Int002Avro fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

   private java.lang.String giorno_ora_riferimento;
   private java.lang.String uDM1;
   private java.lang.String uDM2;
   private java.lang.String uDM3;
   private java.lang.String uDM4;
   private java.lang.String descrizione;
   private java.lang.String tipologia;
   private java.lang.String codice_remi;
   private java.lang.Double valore_1;
   private java.lang.Double progressivo_1;
   private java.lang.Double valore_2;
   private java.lang.Double progressivo_2;
   private java.lang.Double PCS;
   private java.lang.Double valore_3;
   private java.lang.Double progressivo_3;
   private java.lang.Double valore_4;
   private java.lang.Double progressivo_4;
   private java.lang.Double pCS25_0;
   private java.lang.Double wobbe25_15;
   private java.lang.Double wobbe25_0;
   private java.lang.String ts_inserimento;
   private java.lang.String dt_inserimento;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public Int002Avro() {}

  /**
   * All-args constructor.
   * @param giorno_ora_riferimento The new value for giorno_ora_riferimento
   * @param uDM1 The new value for uDM1
   * @param uDM2 The new value for uDM2
   * @param uDM3 The new value for uDM3
   * @param uDM4 The new value for uDM4
   * @param descrizione The new value for descrizione
   * @param tipologia The new value for tipologia
   * @param codice_remi The new value for codice_remi
   * @param valore_1 The new value for valore_1
   * @param progressivo_1 The new value for progressivo_1
   * @param valore_2 The new value for valore_2
   * @param progressivo_2 The new value for progressivo_2
   * @param PCS The new value for PCS
   * @param valore_3 The new value for valore_3
   * @param progressivo_3 The new value for progressivo_3
   * @param valore_4 The new value for valore_4
   * @param progressivo_4 The new value for progressivo_4
   * @param pCS25_0 The new value for pCS25_0
   * @param wobbe25_15 The new value for wobbe25_15
   * @param wobbe25_0 The new value for wobbe25_0
   * @param ts_inserimento The new value for ts_inserimento
   * @param dt_inserimento The new value for dt_inserimento
   */
  public Int002Avro(java.lang.String giorno_ora_riferimento, java.lang.String uDM1, java.lang.String uDM2, java.lang.String uDM3, java.lang.String uDM4, java.lang.String descrizione, java.lang.String tipologia, java.lang.String codice_remi, java.lang.Double valore_1, java.lang.Double progressivo_1, java.lang.Double valore_2, java.lang.Double progressivo_2, java.lang.Double PCS, java.lang.Double valore_3, java.lang.Double progressivo_3, java.lang.Double valore_4, java.lang.Double progressivo_4, java.lang.Double pCS25_0, java.lang.Double wobbe25_15, java.lang.Double wobbe25_0, java.lang.String ts_inserimento, java.lang.String dt_inserimento) {
    this.giorno_ora_riferimento = giorno_ora_riferimento;
    this.uDM1 = uDM1;
    this.uDM2 = uDM2;
    this.uDM3 = uDM3;
    this.uDM4 = uDM4;
    this.descrizione = descrizione;
    this.tipologia = tipologia;
    this.codice_remi = codice_remi;
    this.valore_1 = valore_1;
    this.progressivo_1 = progressivo_1;
    this.valore_2 = valore_2;
    this.progressivo_2 = progressivo_2;
    this.PCS = PCS;
    this.valore_3 = valore_3;
    this.progressivo_3 = progressivo_3;
    this.valore_4 = valore_4;
    this.progressivo_4 = progressivo_4;
    this.pCS25_0 = pCS25_0;
    this.wobbe25_15 = wobbe25_15;
    this.wobbe25_0 = wobbe25_0;
    this.ts_inserimento = ts_inserimento;
    this.dt_inserimento = dt_inserimento;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return giorno_ora_riferimento;
    case 1: return uDM1;
    case 2: return uDM2;
    case 3: return uDM3;
    case 4: return uDM4;
    case 5: return descrizione;
    case 6: return tipologia;
    case 7: return codice_remi;
    case 8: return valore_1;
    case 9: return progressivo_1;
    case 10: return valore_2;
    case 11: return progressivo_2;
    case 12: return PCS;
    case 13: return valore_3;
    case 14: return progressivo_3;
    case 15: return valore_4;
    case 16: return progressivo_4;
    case 17: return pCS25_0;
    case 18: return wobbe25_15;
    case 19: return wobbe25_0;
    case 20: return ts_inserimento;
    case 21: return dt_inserimento;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: giorno_ora_riferimento = (java.lang.String)value$; break;
    case 1: uDM1 = (java.lang.String)value$; break;
    case 2: uDM2 = (java.lang.String)value$; break;
    case 3: uDM3 = (java.lang.String)value$; break;
    case 4: uDM4 = (java.lang.String)value$; break;
    case 5: descrizione = (java.lang.String)value$; break;
    case 6: tipologia = (java.lang.String)value$; break;
    case 7: codice_remi = (java.lang.String)value$; break;
    case 8: valore_1 = (java.lang.Double)value$; break;
    case 9: progressivo_1 = (java.lang.Double)value$; break;
    case 10: valore_2 = (java.lang.Double)value$; break;
    case 11: progressivo_2 = (java.lang.Double)value$; break;
    case 12: PCS = (java.lang.Double)value$; break;
    case 13: valore_3 = (java.lang.Double)value$; break;
    case 14: progressivo_3 = (java.lang.Double)value$; break;
    case 15: valore_4 = (java.lang.Double)value$; break;
    case 16: progressivo_4 = (java.lang.Double)value$; break;
    case 17: pCS25_0 = (java.lang.Double)value$; break;
    case 18: wobbe25_15 = (java.lang.Double)value$; break;
    case 19: wobbe25_0 = (java.lang.Double)value$; break;
    case 20: ts_inserimento = (java.lang.String)value$; break;
    case 21: dt_inserimento = (java.lang.String)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'giorno_ora_riferimento' field.
   * @return The value of the 'giorno_ora_riferimento' field.
   */
  public java.lang.String getGiornoOraRiferimento() {
    return giorno_ora_riferimento;
  }

  /**
   * Sets the value of the 'giorno_ora_riferimento' field.
   * @param value the value to set.
   */
  public void setGiornoOraRiferimento(java.lang.String value) {
    this.giorno_ora_riferimento = value;
  }

  /**
   * Gets the value of the 'uDM1' field.
   * @return The value of the 'uDM1' field.
   */
  public java.lang.String getUDM1() {
    return uDM1;
  }

  /**
   * Sets the value of the 'uDM1' field.
   * @param value the value to set.
   */
  public void setUDM1(java.lang.String value) {
    this.uDM1 = value;
  }

  /**
   * Gets the value of the 'uDM2' field.
   * @return The value of the 'uDM2' field.
   */
  public java.lang.String getUDM2() {
    return uDM2;
  }

  /**
   * Sets the value of the 'uDM2' field.
   * @param value the value to set.
   */
  public void setUDM2(java.lang.String value) {
    this.uDM2 = value;
  }

  /**
   * Gets the value of the 'uDM3' field.
   * @return The value of the 'uDM3' field.
   */
  public java.lang.String getUDM3() {
    return uDM3;
  }

  /**
   * Sets the value of the 'uDM3' field.
   * @param value the value to set.
   */
  public void setUDM3(java.lang.String value) {
    this.uDM3 = value;
  }

  /**
   * Gets the value of the 'uDM4' field.
   * @return The value of the 'uDM4' field.
   */
  public java.lang.String getUDM4() {
    return uDM4;
  }

  /**
   * Sets the value of the 'uDM4' field.
   * @param value the value to set.
   */
  public void setUDM4(java.lang.String value) {
    this.uDM4 = value;
  }

  /**
   * Gets the value of the 'descrizione' field.
   * @return The value of the 'descrizione' field.
   */
  public java.lang.String getDescrizione() {
    return descrizione;
  }

  /**
   * Sets the value of the 'descrizione' field.
   * @param value the value to set.
   */
  public void setDescrizione(java.lang.String value) {
    this.descrizione = value;
  }

  /**
   * Gets the value of the 'tipologia' field.
   * @return The value of the 'tipologia' field.
   */
  public java.lang.String getTipologia() {
    return tipologia;
  }

  /**
   * Sets the value of the 'tipologia' field.
   * @param value the value to set.
   */
  public void setTipologia(java.lang.String value) {
    this.tipologia = value;
  }

  /**
   * Gets the value of the 'codice_remi' field.
   * @return The value of the 'codice_remi' field.
   */
  public java.lang.String getCodiceRemi() {
    return codice_remi;
  }

  /**
   * Sets the value of the 'codice_remi' field.
   * @param value the value to set.
   */
  public void setCodiceRemi(java.lang.String value) {
    this.codice_remi = value;
  }

  /**
   * Gets the value of the 'valore_1' field.
   * @return The value of the 'valore_1' field.
   */
  public java.lang.Double getValore1() {
    return valore_1;
  }

  /**
   * Sets the value of the 'valore_1' field.
   * @param value the value to set.
   */
  public void setValore1(java.lang.Double value) {
    this.valore_1 = value;
  }

  /**
   * Gets the value of the 'progressivo_1' field.
   * @return The value of the 'progressivo_1' field.
   */
  public java.lang.Double getProgressivo1() {
    return progressivo_1;
  }

  /**
   * Sets the value of the 'progressivo_1' field.
   * @param value the value to set.
   */
  public void setProgressivo1(java.lang.Double value) {
    this.progressivo_1 = value;
  }

  /**
   * Gets the value of the 'valore_2' field.
   * @return The value of the 'valore_2' field.
   */
  public java.lang.Double getValore2() {
    return valore_2;
  }

  /**
   * Sets the value of the 'valore_2' field.
   * @param value the value to set.
   */
  public void setValore2(java.lang.Double value) {
    this.valore_2 = value;
  }

  /**
   * Gets the value of the 'progressivo_2' field.
   * @return The value of the 'progressivo_2' field.
   */
  public java.lang.Double getProgressivo2() {
    return progressivo_2;
  }

  /**
   * Sets the value of the 'progressivo_2' field.
   * @param value the value to set.
   */
  public void setProgressivo2(java.lang.Double value) {
    this.progressivo_2 = value;
  }

  /**
   * Gets the value of the 'PCS' field.
   * @return The value of the 'PCS' field.
   */
  public java.lang.Double getPCS() {
    return PCS;
  }

  /**
   * Sets the value of the 'PCS' field.
   * @param value the value to set.
   */
  public void setPCS(java.lang.Double value) {
    this.PCS = value;
  }

  /**
   * Gets the value of the 'valore_3' field.
   * @return The value of the 'valore_3' field.
   */
  public java.lang.Double getValore3() {
    return valore_3;
  }

  /**
   * Sets the value of the 'valore_3' field.
   * @param value the value to set.
   */
  public void setValore3(java.lang.Double value) {
    this.valore_3 = value;
  }

  /**
   * Gets the value of the 'progressivo_3' field.
   * @return The value of the 'progressivo_3' field.
   */
  public java.lang.Double getProgressivo3() {
    return progressivo_3;
  }

  /**
   * Sets the value of the 'progressivo_3' field.
   * @param value the value to set.
   */
  public void setProgressivo3(java.lang.Double value) {
    this.progressivo_3 = value;
  }

  /**
   * Gets the value of the 'valore_4' field.
   * @return The value of the 'valore_4' field.
   */
  public java.lang.Double getValore4() {
    return valore_4;
  }

  /**
   * Sets the value of the 'valore_4' field.
   * @param value the value to set.
   */
  public void setValore4(java.lang.Double value) {
    this.valore_4 = value;
  }

  /**
   * Gets the value of the 'progressivo_4' field.
   * @return The value of the 'progressivo_4' field.
   */
  public java.lang.Double getProgressivo4() {
    return progressivo_4;
  }

  /**
   * Sets the value of the 'progressivo_4' field.
   * @param value the value to set.
   */
  public void setProgressivo4(java.lang.Double value) {
    this.progressivo_4 = value;
  }

  /**
   * Gets the value of the 'pCS25_0' field.
   * @return The value of the 'pCS25_0' field.
   */
  public java.lang.Double getPCS250() {
    return pCS25_0;
  }

  /**
   * Sets the value of the 'pCS25_0' field.
   * @param value the value to set.
   */
  public void setPCS250(java.lang.Double value) {
    this.pCS25_0 = value;
  }

  /**
   * Gets the value of the 'wobbe25_15' field.
   * @return The value of the 'wobbe25_15' field.
   */
  public java.lang.Double getWobbe2515() {
    return wobbe25_15;
  }

  /**
   * Sets the value of the 'wobbe25_15' field.
   * @param value the value to set.
   */
  public void setWobbe2515(java.lang.Double value) {
    this.wobbe25_15 = value;
  }

  /**
   * Gets the value of the 'wobbe25_0' field.
   * @return The value of the 'wobbe25_0' field.
   */
  public java.lang.Double getWobbe250() {
    return wobbe25_0;
  }

  /**
   * Sets the value of the 'wobbe25_0' field.
   * @param value the value to set.
   */
  public void setWobbe250(java.lang.Double value) {
    this.wobbe25_0 = value;
  }

  /**
   * Gets the value of the 'ts_inserimento' field.
   * @return The value of the 'ts_inserimento' field.
   */
  public java.lang.String getTsInserimento() {
    return ts_inserimento;
  }

  /**
   * Sets the value of the 'ts_inserimento' field.
   * @param value the value to set.
   */
  public void setTsInserimento(java.lang.String value) {
    this.ts_inserimento = value;
  }

  /**
   * Gets the value of the 'dt_inserimento' field.
   * @return The value of the 'dt_inserimento' field.
   */
  public java.lang.String getDtInserimento() {
    return dt_inserimento;
  }

  /**
   * Sets the value of the 'dt_inserimento' field.
   * @param value the value to set.
   */
  public void setDtInserimento(java.lang.String value) {
    this.dt_inserimento = value;
  }

  /**
   * Creates a new Int002Avro RecordBuilder.
   * @return A new Int002Avro RecordBuilder
   */
  public static it.luca.streaming.data.model.int002.Int002Avro.Builder newBuilder() {
    return new it.luca.streaming.data.model.int002.Int002Avro.Builder();
  }

  /**
   * Creates a new Int002Avro RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new Int002Avro RecordBuilder
   */
  public static it.luca.streaming.data.model.int002.Int002Avro.Builder newBuilder(it.luca.streaming.data.model.int002.Int002Avro.Builder other) {
    return new it.luca.streaming.data.model.int002.Int002Avro.Builder(other);
  }

  /**
   * Creates a new Int002Avro RecordBuilder by copying an existing Int002Avro instance.
   * @param other The existing instance to copy.
   * @return A new Int002Avro RecordBuilder
   */
  public static it.luca.streaming.data.model.int002.Int002Avro.Builder newBuilder(it.luca.streaming.data.model.int002.Int002Avro other) {
    return new it.luca.streaming.data.model.int002.Int002Avro.Builder(other);
  }

  /**
   * RecordBuilder for Int002Avro instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Int002Avro>
    implements org.apache.avro.data.RecordBuilder<Int002Avro> {

    private java.lang.String giorno_ora_riferimento;
    private java.lang.String uDM1;
    private java.lang.String uDM2;
    private java.lang.String uDM3;
    private java.lang.String uDM4;
    private java.lang.String descrizione;
    private java.lang.String tipologia;
    private java.lang.String codice_remi;
    private java.lang.Double valore_1;
    private java.lang.Double progressivo_1;
    private java.lang.Double valore_2;
    private java.lang.Double progressivo_2;
    private java.lang.Double PCS;
    private java.lang.Double valore_3;
    private java.lang.Double progressivo_3;
    private java.lang.Double valore_4;
    private java.lang.Double progressivo_4;
    private java.lang.Double pCS25_0;
    private java.lang.Double wobbe25_15;
    private java.lang.Double wobbe25_0;
    private java.lang.String ts_inserimento;
    private java.lang.String dt_inserimento;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(it.luca.streaming.data.model.int002.Int002Avro.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.giorno_ora_riferimento)) {
        this.giorno_ora_riferimento = data().deepCopy(fields()[0].schema(), other.giorno_ora_riferimento);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.uDM1)) {
        this.uDM1 = data().deepCopy(fields()[1].schema(), other.uDM1);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.uDM2)) {
        this.uDM2 = data().deepCopy(fields()[2].schema(), other.uDM2);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.uDM3)) {
        this.uDM3 = data().deepCopy(fields()[3].schema(), other.uDM3);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.uDM4)) {
        this.uDM4 = data().deepCopy(fields()[4].schema(), other.uDM4);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.descrizione)) {
        this.descrizione = data().deepCopy(fields()[5].schema(), other.descrizione);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.tipologia)) {
        this.tipologia = data().deepCopy(fields()[6].schema(), other.tipologia);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.codice_remi)) {
        this.codice_remi = data().deepCopy(fields()[7].schema(), other.codice_remi);
        fieldSetFlags()[7] = true;
      }
      if (isValidValue(fields()[8], other.valore_1)) {
        this.valore_1 = data().deepCopy(fields()[8].schema(), other.valore_1);
        fieldSetFlags()[8] = true;
      }
      if (isValidValue(fields()[9], other.progressivo_1)) {
        this.progressivo_1 = data().deepCopy(fields()[9].schema(), other.progressivo_1);
        fieldSetFlags()[9] = true;
      }
      if (isValidValue(fields()[10], other.valore_2)) {
        this.valore_2 = data().deepCopy(fields()[10].schema(), other.valore_2);
        fieldSetFlags()[10] = true;
      }
      if (isValidValue(fields()[11], other.progressivo_2)) {
        this.progressivo_2 = data().deepCopy(fields()[11].schema(), other.progressivo_2);
        fieldSetFlags()[11] = true;
      }
      if (isValidValue(fields()[12], other.PCS)) {
        this.PCS = data().deepCopy(fields()[12].schema(), other.PCS);
        fieldSetFlags()[12] = true;
      }
      if (isValidValue(fields()[13], other.valore_3)) {
        this.valore_3 = data().deepCopy(fields()[13].schema(), other.valore_3);
        fieldSetFlags()[13] = true;
      }
      if (isValidValue(fields()[14], other.progressivo_3)) {
        this.progressivo_3 = data().deepCopy(fields()[14].schema(), other.progressivo_3);
        fieldSetFlags()[14] = true;
      }
      if (isValidValue(fields()[15], other.valore_4)) {
        this.valore_4 = data().deepCopy(fields()[15].schema(), other.valore_4);
        fieldSetFlags()[15] = true;
      }
      if (isValidValue(fields()[16], other.progressivo_4)) {
        this.progressivo_4 = data().deepCopy(fields()[16].schema(), other.progressivo_4);
        fieldSetFlags()[16] = true;
      }
      if (isValidValue(fields()[17], other.pCS25_0)) {
        this.pCS25_0 = data().deepCopy(fields()[17].schema(), other.pCS25_0);
        fieldSetFlags()[17] = true;
      }
      if (isValidValue(fields()[18], other.wobbe25_15)) {
        this.wobbe25_15 = data().deepCopy(fields()[18].schema(), other.wobbe25_15);
        fieldSetFlags()[18] = true;
      }
      if (isValidValue(fields()[19], other.wobbe25_0)) {
        this.wobbe25_0 = data().deepCopy(fields()[19].schema(), other.wobbe25_0);
        fieldSetFlags()[19] = true;
      }
      if (isValidValue(fields()[20], other.ts_inserimento)) {
        this.ts_inserimento = data().deepCopy(fields()[20].schema(), other.ts_inserimento);
        fieldSetFlags()[20] = true;
      }
      if (isValidValue(fields()[21], other.dt_inserimento)) {
        this.dt_inserimento = data().deepCopy(fields()[21].schema(), other.dt_inserimento);
        fieldSetFlags()[21] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing Int002Avro instance
     * @param other The existing instance to copy.
     */
    private Builder(it.luca.streaming.data.model.int002.Int002Avro other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.giorno_ora_riferimento)) {
        this.giorno_ora_riferimento = data().deepCopy(fields()[0].schema(), other.giorno_ora_riferimento);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.uDM1)) {
        this.uDM1 = data().deepCopy(fields()[1].schema(), other.uDM1);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.uDM2)) {
        this.uDM2 = data().deepCopy(fields()[2].schema(), other.uDM2);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.uDM3)) {
        this.uDM3 = data().deepCopy(fields()[3].schema(), other.uDM3);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.uDM4)) {
        this.uDM4 = data().deepCopy(fields()[4].schema(), other.uDM4);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.descrizione)) {
        this.descrizione = data().deepCopy(fields()[5].schema(), other.descrizione);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.tipologia)) {
        this.tipologia = data().deepCopy(fields()[6].schema(), other.tipologia);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.codice_remi)) {
        this.codice_remi = data().deepCopy(fields()[7].schema(), other.codice_remi);
        fieldSetFlags()[7] = true;
      }
      if (isValidValue(fields()[8], other.valore_1)) {
        this.valore_1 = data().deepCopy(fields()[8].schema(), other.valore_1);
        fieldSetFlags()[8] = true;
      }
      if (isValidValue(fields()[9], other.progressivo_1)) {
        this.progressivo_1 = data().deepCopy(fields()[9].schema(), other.progressivo_1);
        fieldSetFlags()[9] = true;
      }
      if (isValidValue(fields()[10], other.valore_2)) {
        this.valore_2 = data().deepCopy(fields()[10].schema(), other.valore_2);
        fieldSetFlags()[10] = true;
      }
      if (isValidValue(fields()[11], other.progressivo_2)) {
        this.progressivo_2 = data().deepCopy(fields()[11].schema(), other.progressivo_2);
        fieldSetFlags()[11] = true;
      }
      if (isValidValue(fields()[12], other.PCS)) {
        this.PCS = data().deepCopy(fields()[12].schema(), other.PCS);
        fieldSetFlags()[12] = true;
      }
      if (isValidValue(fields()[13], other.valore_3)) {
        this.valore_3 = data().deepCopy(fields()[13].schema(), other.valore_3);
        fieldSetFlags()[13] = true;
      }
      if (isValidValue(fields()[14], other.progressivo_3)) {
        this.progressivo_3 = data().deepCopy(fields()[14].schema(), other.progressivo_3);
        fieldSetFlags()[14] = true;
      }
      if (isValidValue(fields()[15], other.valore_4)) {
        this.valore_4 = data().deepCopy(fields()[15].schema(), other.valore_4);
        fieldSetFlags()[15] = true;
      }
      if (isValidValue(fields()[16], other.progressivo_4)) {
        this.progressivo_4 = data().deepCopy(fields()[16].schema(), other.progressivo_4);
        fieldSetFlags()[16] = true;
      }
      if (isValidValue(fields()[17], other.pCS25_0)) {
        this.pCS25_0 = data().deepCopy(fields()[17].schema(), other.pCS25_0);
        fieldSetFlags()[17] = true;
      }
      if (isValidValue(fields()[18], other.wobbe25_15)) {
        this.wobbe25_15 = data().deepCopy(fields()[18].schema(), other.wobbe25_15);
        fieldSetFlags()[18] = true;
      }
      if (isValidValue(fields()[19], other.wobbe25_0)) {
        this.wobbe25_0 = data().deepCopy(fields()[19].schema(), other.wobbe25_0);
        fieldSetFlags()[19] = true;
      }
      if (isValidValue(fields()[20], other.ts_inserimento)) {
        this.ts_inserimento = data().deepCopy(fields()[20].schema(), other.ts_inserimento);
        fieldSetFlags()[20] = true;
      }
      if (isValidValue(fields()[21], other.dt_inserimento)) {
        this.dt_inserimento = data().deepCopy(fields()[21].schema(), other.dt_inserimento);
        fieldSetFlags()[21] = true;
      }
    }

    /**
      * Gets the value of the 'giorno_ora_riferimento' field.
      * @return The value.
      */
    public java.lang.String getGiornoOraRiferimento() {
      return giorno_ora_riferimento;
    }

    /**
      * Sets the value of the 'giorno_ora_riferimento' field.
      * @param value The value of 'giorno_ora_riferimento'.
      * @return This builder.
      */
    public it.luca.streaming.data.model.int002.Int002Avro.Builder setGiornoOraRiferimento(java.lang.String value) {
      validate(fields()[0], value);
      this.giorno_ora_riferimento = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'giorno_ora_riferimento' field has been set.
      * @return True if the 'giorno_ora_riferimento' field has been set, false otherwise.
      */
    public boolean hasGiornoOraRiferimento() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'giorno_ora_riferimento' field.
      * @return This builder.
      */
    public it.luca.streaming.data.model.int002.Int002Avro.Builder clearGiornoOraRiferimento() {
      giorno_ora_riferimento = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'uDM1' field.
      * @return The value.
      */
    public java.lang.String getUDM1() {
      return uDM1;
    }

    /**
      * Sets the value of the 'uDM1' field.
      * @param value The value of 'uDM1'.
      * @return This builder.
      */
    public it.luca.streaming.data.model.int002.Int002Avro.Builder setUDM1(java.lang.String value) {
      validate(fields()[1], value);
      this.uDM1 = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'uDM1' field has been set.
      * @return True if the 'uDM1' field has been set, false otherwise.
      */
    public boolean hasUDM1() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'uDM1' field.
      * @return This builder.
      */
    public it.luca.streaming.data.model.int002.Int002Avro.Builder clearUDM1() {
      uDM1 = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'uDM2' field.
      * @return The value.
      */
    public java.lang.String getUDM2() {
      return uDM2;
    }

    /**
      * Sets the value of the 'uDM2' field.
      * @param value The value of 'uDM2'.
      * @return This builder.
      */
    public it.luca.streaming.data.model.int002.Int002Avro.Builder setUDM2(java.lang.String value) {
      validate(fields()[2], value);
      this.uDM2 = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'uDM2' field has been set.
      * @return True if the 'uDM2' field has been set, false otherwise.
      */
    public boolean hasUDM2() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'uDM2' field.
      * @return This builder.
      */
    public it.luca.streaming.data.model.int002.Int002Avro.Builder clearUDM2() {
      uDM2 = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'uDM3' field.
      * @return The value.
      */
    public java.lang.String getUDM3() {
      return uDM3;
    }

    /**
      * Sets the value of the 'uDM3' field.
      * @param value The value of 'uDM3'.
      * @return This builder.
      */
    public it.luca.streaming.data.model.int002.Int002Avro.Builder setUDM3(java.lang.String value) {
      validate(fields()[3], value);
      this.uDM3 = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'uDM3' field has been set.
      * @return True if the 'uDM3' field has been set, false otherwise.
      */
    public boolean hasUDM3() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'uDM3' field.
      * @return This builder.
      */
    public it.luca.streaming.data.model.int002.Int002Avro.Builder clearUDM3() {
      uDM3 = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'uDM4' field.
      * @return The value.
      */
    public java.lang.String getUDM4() {
      return uDM4;
    }

    /**
      * Sets the value of the 'uDM4' field.
      * @param value The value of 'uDM4'.
      * @return This builder.
      */
    public it.luca.streaming.data.model.int002.Int002Avro.Builder setUDM4(java.lang.String value) {
      validate(fields()[4], value);
      this.uDM4 = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'uDM4' field has been set.
      * @return True if the 'uDM4' field has been set, false otherwise.
      */
    public boolean hasUDM4() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'uDM4' field.
      * @return This builder.
      */
    public it.luca.streaming.data.model.int002.Int002Avro.Builder clearUDM4() {
      uDM4 = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'descrizione' field.
      * @return The value.
      */
    public java.lang.String getDescrizione() {
      return descrizione;
    }

    /**
      * Sets the value of the 'descrizione' field.
      * @param value The value of 'descrizione'.
      * @return This builder.
      */
    public it.luca.streaming.data.model.int002.Int002Avro.Builder setDescrizione(java.lang.String value) {
      validate(fields()[5], value);
      this.descrizione = value;
      fieldSetFlags()[5] = true;
      return this;
    }

    /**
      * Checks whether the 'descrizione' field has been set.
      * @return True if the 'descrizione' field has been set, false otherwise.
      */
    public boolean hasDescrizione() {
      return fieldSetFlags()[5];
    }


    /**
      * Clears the value of the 'descrizione' field.
      * @return This builder.
      */
    public it.luca.streaming.data.model.int002.Int002Avro.Builder clearDescrizione() {
      descrizione = null;
      fieldSetFlags()[5] = false;
      return this;
    }

    /**
      * Gets the value of the 'tipologia' field.
      * @return The value.
      */
    public java.lang.String getTipologia() {
      return tipologia;
    }

    /**
      * Sets the value of the 'tipologia' field.
      * @param value The value of 'tipologia'.
      * @return This builder.
      */
    public it.luca.streaming.data.model.int002.Int002Avro.Builder setTipologia(java.lang.String value) {
      validate(fields()[6], value);
      this.tipologia = value;
      fieldSetFlags()[6] = true;
      return this;
    }

    /**
      * Checks whether the 'tipologia' field has been set.
      * @return True if the 'tipologia' field has been set, false otherwise.
      */
    public boolean hasTipologia() {
      return fieldSetFlags()[6];
    }


    /**
      * Clears the value of the 'tipologia' field.
      * @return This builder.
      */
    public it.luca.streaming.data.model.int002.Int002Avro.Builder clearTipologia() {
      tipologia = null;
      fieldSetFlags()[6] = false;
      return this;
    }

    /**
      * Gets the value of the 'codice_remi' field.
      * @return The value.
      */
    public java.lang.String getCodiceRemi() {
      return codice_remi;
    }

    /**
      * Sets the value of the 'codice_remi' field.
      * @param value The value of 'codice_remi'.
      * @return This builder.
      */
    public it.luca.streaming.data.model.int002.Int002Avro.Builder setCodiceRemi(java.lang.String value) {
      validate(fields()[7], value);
      this.codice_remi = value;
      fieldSetFlags()[7] = true;
      return this;
    }

    /**
      * Checks whether the 'codice_remi' field has been set.
      * @return True if the 'codice_remi' field has been set, false otherwise.
      */
    public boolean hasCodiceRemi() {
      return fieldSetFlags()[7];
    }


    /**
      * Clears the value of the 'codice_remi' field.
      * @return This builder.
      */
    public it.luca.streaming.data.model.int002.Int002Avro.Builder clearCodiceRemi() {
      codice_remi = null;
      fieldSetFlags()[7] = false;
      return this;
    }

    /**
      * Gets the value of the 'valore_1' field.
      * @return The value.
      */
    public java.lang.Double getValore1() {
      return valore_1;
    }

    /**
      * Sets the value of the 'valore_1' field.
      * @param value The value of 'valore_1'.
      * @return This builder.
      */
    public it.luca.streaming.data.model.int002.Int002Avro.Builder setValore1(java.lang.Double value) {
      validate(fields()[8], value);
      this.valore_1 = value;
      fieldSetFlags()[8] = true;
      return this;
    }

    /**
      * Checks whether the 'valore_1' field has been set.
      * @return True if the 'valore_1' field has been set, false otherwise.
      */
    public boolean hasValore1() {
      return fieldSetFlags()[8];
    }


    /**
      * Clears the value of the 'valore_1' field.
      * @return This builder.
      */
    public it.luca.streaming.data.model.int002.Int002Avro.Builder clearValore1() {
      valore_1 = null;
      fieldSetFlags()[8] = false;
      return this;
    }

    /**
      * Gets the value of the 'progressivo_1' field.
      * @return The value.
      */
    public java.lang.Double getProgressivo1() {
      return progressivo_1;
    }

    /**
      * Sets the value of the 'progressivo_1' field.
      * @param value The value of 'progressivo_1'.
      * @return This builder.
      */
    public it.luca.streaming.data.model.int002.Int002Avro.Builder setProgressivo1(java.lang.Double value) {
      validate(fields()[9], value);
      this.progressivo_1 = value;
      fieldSetFlags()[9] = true;
      return this;
    }

    /**
      * Checks whether the 'progressivo_1' field has been set.
      * @return True if the 'progressivo_1' field has been set, false otherwise.
      */
    public boolean hasProgressivo1() {
      return fieldSetFlags()[9];
    }


    /**
      * Clears the value of the 'progressivo_1' field.
      * @return This builder.
      */
    public it.luca.streaming.data.model.int002.Int002Avro.Builder clearProgressivo1() {
      progressivo_1 = null;
      fieldSetFlags()[9] = false;
      return this;
    }

    /**
      * Gets the value of the 'valore_2' field.
      * @return The value.
      */
    public java.lang.Double getValore2() {
      return valore_2;
    }

    /**
      * Sets the value of the 'valore_2' field.
      * @param value The value of 'valore_2'.
      * @return This builder.
      */
    public it.luca.streaming.data.model.int002.Int002Avro.Builder setValore2(java.lang.Double value) {
      validate(fields()[10], value);
      this.valore_2 = value;
      fieldSetFlags()[10] = true;
      return this;
    }

    /**
      * Checks whether the 'valore_2' field has been set.
      * @return True if the 'valore_2' field has been set, false otherwise.
      */
    public boolean hasValore2() {
      return fieldSetFlags()[10];
    }


    /**
      * Clears the value of the 'valore_2' field.
      * @return This builder.
      */
    public it.luca.streaming.data.model.int002.Int002Avro.Builder clearValore2() {
      valore_2 = null;
      fieldSetFlags()[10] = false;
      return this;
    }

    /**
      * Gets the value of the 'progressivo_2' field.
      * @return The value.
      */
    public java.lang.Double getProgressivo2() {
      return progressivo_2;
    }

    /**
      * Sets the value of the 'progressivo_2' field.
      * @param value The value of 'progressivo_2'.
      * @return This builder.
      */
    public it.luca.streaming.data.model.int002.Int002Avro.Builder setProgressivo2(java.lang.Double value) {
      validate(fields()[11], value);
      this.progressivo_2 = value;
      fieldSetFlags()[11] = true;
      return this;
    }

    /**
      * Checks whether the 'progressivo_2' field has been set.
      * @return True if the 'progressivo_2' field has been set, false otherwise.
      */
    public boolean hasProgressivo2() {
      return fieldSetFlags()[11];
    }


    /**
      * Clears the value of the 'progressivo_2' field.
      * @return This builder.
      */
    public it.luca.streaming.data.model.int002.Int002Avro.Builder clearProgressivo2() {
      progressivo_2 = null;
      fieldSetFlags()[11] = false;
      return this;
    }

    /**
      * Gets the value of the 'PCS' field.
      * @return The value.
      */
    public java.lang.Double getPCS() {
      return PCS;
    }

    /**
      * Sets the value of the 'PCS' field.
      * @param value The value of 'PCS'.
      * @return This builder.
      */
    public it.luca.streaming.data.model.int002.Int002Avro.Builder setPCS(java.lang.Double value) {
      validate(fields()[12], value);
      this.PCS = value;
      fieldSetFlags()[12] = true;
      return this;
    }

    /**
      * Checks whether the 'PCS' field has been set.
      * @return True if the 'PCS' field has been set, false otherwise.
      */
    public boolean hasPCS() {
      return fieldSetFlags()[12];
    }


    /**
      * Clears the value of the 'PCS' field.
      * @return This builder.
      */
    public it.luca.streaming.data.model.int002.Int002Avro.Builder clearPCS() {
      PCS = null;
      fieldSetFlags()[12] = false;
      return this;
    }

    /**
      * Gets the value of the 'valore_3' field.
      * @return The value.
      */
    public java.lang.Double getValore3() {
      return valore_3;
    }

    /**
      * Sets the value of the 'valore_3' field.
      * @param value The value of 'valore_3'.
      * @return This builder.
      */
    public it.luca.streaming.data.model.int002.Int002Avro.Builder setValore3(java.lang.Double value) {
      validate(fields()[13], value);
      this.valore_3 = value;
      fieldSetFlags()[13] = true;
      return this;
    }

    /**
      * Checks whether the 'valore_3' field has been set.
      * @return True if the 'valore_3' field has been set, false otherwise.
      */
    public boolean hasValore3() {
      return fieldSetFlags()[13];
    }


    /**
      * Clears the value of the 'valore_3' field.
      * @return This builder.
      */
    public it.luca.streaming.data.model.int002.Int002Avro.Builder clearValore3() {
      valore_3 = null;
      fieldSetFlags()[13] = false;
      return this;
    }

    /**
      * Gets the value of the 'progressivo_3' field.
      * @return The value.
      */
    public java.lang.Double getProgressivo3() {
      return progressivo_3;
    }

    /**
      * Sets the value of the 'progressivo_3' field.
      * @param value The value of 'progressivo_3'.
      * @return This builder.
      */
    public it.luca.streaming.data.model.int002.Int002Avro.Builder setProgressivo3(java.lang.Double value) {
      validate(fields()[14], value);
      this.progressivo_3 = value;
      fieldSetFlags()[14] = true;
      return this;
    }

    /**
      * Checks whether the 'progressivo_3' field has been set.
      * @return True if the 'progressivo_3' field has been set, false otherwise.
      */
    public boolean hasProgressivo3() {
      return fieldSetFlags()[14];
    }


    /**
      * Clears the value of the 'progressivo_3' field.
      * @return This builder.
      */
    public it.luca.streaming.data.model.int002.Int002Avro.Builder clearProgressivo3() {
      progressivo_3 = null;
      fieldSetFlags()[14] = false;
      return this;
    }

    /**
      * Gets the value of the 'valore_4' field.
      * @return The value.
      */
    public java.lang.Double getValore4() {
      return valore_4;
    }

    /**
      * Sets the value of the 'valore_4' field.
      * @param value The value of 'valore_4'.
      * @return This builder.
      */
    public it.luca.streaming.data.model.int002.Int002Avro.Builder setValore4(java.lang.Double value) {
      validate(fields()[15], value);
      this.valore_4 = value;
      fieldSetFlags()[15] = true;
      return this;
    }

    /**
      * Checks whether the 'valore_4' field has been set.
      * @return True if the 'valore_4' field has been set, false otherwise.
      */
    public boolean hasValore4() {
      return fieldSetFlags()[15];
    }


    /**
      * Clears the value of the 'valore_4' field.
      * @return This builder.
      */
    public it.luca.streaming.data.model.int002.Int002Avro.Builder clearValore4() {
      valore_4 = null;
      fieldSetFlags()[15] = false;
      return this;
    }

    /**
      * Gets the value of the 'progressivo_4' field.
      * @return The value.
      */
    public java.lang.Double getProgressivo4() {
      return progressivo_4;
    }

    /**
      * Sets the value of the 'progressivo_4' field.
      * @param value The value of 'progressivo_4'.
      * @return This builder.
      */
    public it.luca.streaming.data.model.int002.Int002Avro.Builder setProgressivo4(java.lang.Double value) {
      validate(fields()[16], value);
      this.progressivo_4 = value;
      fieldSetFlags()[16] = true;
      return this;
    }

    /**
      * Checks whether the 'progressivo_4' field has been set.
      * @return True if the 'progressivo_4' field has been set, false otherwise.
      */
    public boolean hasProgressivo4() {
      return fieldSetFlags()[16];
    }


    /**
      * Clears the value of the 'progressivo_4' field.
      * @return This builder.
      */
    public it.luca.streaming.data.model.int002.Int002Avro.Builder clearProgressivo4() {
      progressivo_4 = null;
      fieldSetFlags()[16] = false;
      return this;
    }

    /**
      * Gets the value of the 'pCS25_0' field.
      * @return The value.
      */
    public java.lang.Double getPCS250() {
      return pCS25_0;
    }

    /**
      * Sets the value of the 'pCS25_0' field.
      * @param value The value of 'pCS25_0'.
      * @return This builder.
      */
    public it.luca.streaming.data.model.int002.Int002Avro.Builder setPCS250(java.lang.Double value) {
      validate(fields()[17], value);
      this.pCS25_0 = value;
      fieldSetFlags()[17] = true;
      return this;
    }

    /**
      * Checks whether the 'pCS25_0' field has been set.
      * @return True if the 'pCS25_0' field has been set, false otherwise.
      */
    public boolean hasPCS250() {
      return fieldSetFlags()[17];
    }


    /**
      * Clears the value of the 'pCS25_0' field.
      * @return This builder.
      */
    public it.luca.streaming.data.model.int002.Int002Avro.Builder clearPCS250() {
      pCS25_0 = null;
      fieldSetFlags()[17] = false;
      return this;
    }

    /**
      * Gets the value of the 'wobbe25_15' field.
      * @return The value.
      */
    public java.lang.Double getWobbe2515() {
      return wobbe25_15;
    }

    /**
      * Sets the value of the 'wobbe25_15' field.
      * @param value The value of 'wobbe25_15'.
      * @return This builder.
      */
    public it.luca.streaming.data.model.int002.Int002Avro.Builder setWobbe2515(java.lang.Double value) {
      validate(fields()[18], value);
      this.wobbe25_15 = value;
      fieldSetFlags()[18] = true;
      return this;
    }

    /**
      * Checks whether the 'wobbe25_15' field has been set.
      * @return True if the 'wobbe25_15' field has been set, false otherwise.
      */
    public boolean hasWobbe2515() {
      return fieldSetFlags()[18];
    }


    /**
      * Clears the value of the 'wobbe25_15' field.
      * @return This builder.
      */
    public it.luca.streaming.data.model.int002.Int002Avro.Builder clearWobbe2515() {
      wobbe25_15 = null;
      fieldSetFlags()[18] = false;
      return this;
    }

    /**
      * Gets the value of the 'wobbe25_0' field.
      * @return The value.
      */
    public java.lang.Double getWobbe250() {
      return wobbe25_0;
    }

    /**
      * Sets the value of the 'wobbe25_0' field.
      * @param value The value of 'wobbe25_0'.
      * @return This builder.
      */
    public it.luca.streaming.data.model.int002.Int002Avro.Builder setWobbe250(java.lang.Double value) {
      validate(fields()[19], value);
      this.wobbe25_0 = value;
      fieldSetFlags()[19] = true;
      return this;
    }

    /**
      * Checks whether the 'wobbe25_0' field has been set.
      * @return True if the 'wobbe25_0' field has been set, false otherwise.
      */
    public boolean hasWobbe250() {
      return fieldSetFlags()[19];
    }


    /**
      * Clears the value of the 'wobbe25_0' field.
      * @return This builder.
      */
    public it.luca.streaming.data.model.int002.Int002Avro.Builder clearWobbe250() {
      wobbe25_0 = null;
      fieldSetFlags()[19] = false;
      return this;
    }

    /**
      * Gets the value of the 'ts_inserimento' field.
      * @return The value.
      */
    public java.lang.String getTsInserimento() {
      return ts_inserimento;
    }

    /**
      * Sets the value of the 'ts_inserimento' field.
      * @param value The value of 'ts_inserimento'.
      * @return This builder.
      */
    public it.luca.streaming.data.model.int002.Int002Avro.Builder setTsInserimento(java.lang.String value) {
      validate(fields()[20], value);
      this.ts_inserimento = value;
      fieldSetFlags()[20] = true;
      return this;
    }

    /**
      * Checks whether the 'ts_inserimento' field has been set.
      * @return True if the 'ts_inserimento' field has been set, false otherwise.
      */
    public boolean hasTsInserimento() {
      return fieldSetFlags()[20];
    }


    /**
      * Clears the value of the 'ts_inserimento' field.
      * @return This builder.
      */
    public it.luca.streaming.data.model.int002.Int002Avro.Builder clearTsInserimento() {
      ts_inserimento = null;
      fieldSetFlags()[20] = false;
      return this;
    }

    /**
      * Gets the value of the 'dt_inserimento' field.
      * @return The value.
      */
    public java.lang.String getDtInserimento() {
      return dt_inserimento;
    }

    /**
      * Sets the value of the 'dt_inserimento' field.
      * @param value The value of 'dt_inserimento'.
      * @return This builder.
      */
    public it.luca.streaming.data.model.int002.Int002Avro.Builder setDtInserimento(java.lang.String value) {
      validate(fields()[21], value);
      this.dt_inserimento = value;
      fieldSetFlags()[21] = true;
      return this;
    }

    /**
      * Checks whether the 'dt_inserimento' field has been set.
      * @return True if the 'dt_inserimento' field has been set, false otherwise.
      */
    public boolean hasDtInserimento() {
      return fieldSetFlags()[21];
    }


    /**
      * Clears the value of the 'dt_inserimento' field.
      * @return This builder.
      */
    public it.luca.streaming.data.model.int002.Int002Avro.Builder clearDtInserimento() {
      dt_inserimento = null;
      fieldSetFlags()[21] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Int002Avro build() {
      try {
        Int002Avro record = new Int002Avro();
        record.giorno_ora_riferimento = fieldSetFlags()[0] ? this.giorno_ora_riferimento : (java.lang.String) defaultValue(fields()[0]);
        record.uDM1 = fieldSetFlags()[1] ? this.uDM1 : (java.lang.String) defaultValue(fields()[1]);
        record.uDM2 = fieldSetFlags()[2] ? this.uDM2 : (java.lang.String) defaultValue(fields()[2]);
        record.uDM3 = fieldSetFlags()[3] ? this.uDM3 : (java.lang.String) defaultValue(fields()[3]);
        record.uDM4 = fieldSetFlags()[4] ? this.uDM4 : (java.lang.String) defaultValue(fields()[4]);
        record.descrizione = fieldSetFlags()[5] ? this.descrizione : (java.lang.String) defaultValue(fields()[5]);
        record.tipologia = fieldSetFlags()[6] ? this.tipologia : (java.lang.String) defaultValue(fields()[6]);
        record.codice_remi = fieldSetFlags()[7] ? this.codice_remi : (java.lang.String) defaultValue(fields()[7]);
        record.valore_1 = fieldSetFlags()[8] ? this.valore_1 : (java.lang.Double) defaultValue(fields()[8]);
        record.progressivo_1 = fieldSetFlags()[9] ? this.progressivo_1 : (java.lang.Double) defaultValue(fields()[9]);
        record.valore_2 = fieldSetFlags()[10] ? this.valore_2 : (java.lang.Double) defaultValue(fields()[10]);
        record.progressivo_2 = fieldSetFlags()[11] ? this.progressivo_2 : (java.lang.Double) defaultValue(fields()[11]);
        record.PCS = fieldSetFlags()[12] ? this.PCS : (java.lang.Double) defaultValue(fields()[12]);
        record.valore_3 = fieldSetFlags()[13] ? this.valore_3 : (java.lang.Double) defaultValue(fields()[13]);
        record.progressivo_3 = fieldSetFlags()[14] ? this.progressivo_3 : (java.lang.Double) defaultValue(fields()[14]);
        record.valore_4 = fieldSetFlags()[15] ? this.valore_4 : (java.lang.Double) defaultValue(fields()[15]);
        record.progressivo_4 = fieldSetFlags()[16] ? this.progressivo_4 : (java.lang.Double) defaultValue(fields()[16]);
        record.pCS25_0 = fieldSetFlags()[17] ? this.pCS25_0 : (java.lang.Double) defaultValue(fields()[17]);
        record.wobbe25_15 = fieldSetFlags()[18] ? this.wobbe25_15 : (java.lang.Double) defaultValue(fields()[18]);
        record.wobbe25_0 = fieldSetFlags()[19] ? this.wobbe25_0 : (java.lang.Double) defaultValue(fields()[19]);
        record.ts_inserimento = fieldSetFlags()[20] ? this.ts_inserimento : (java.lang.String) defaultValue(fields()[20]);
        record.dt_inserimento = fieldSetFlags()[21] ? this.dt_inserimento : (java.lang.String) defaultValue(fields()[21]);
        return record;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<Int002Avro>
    WRITER$ = (org.apache.avro.io.DatumWriter<Int002Avro>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<Int002Avro>
    READER$ = (org.apache.avro.io.DatumReader<Int002Avro>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}
