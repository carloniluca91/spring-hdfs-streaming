package it.luca.streaming.data.model.webdisp;

import org.apache.avro.specific.SpecificData;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class WebdispAvro extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -1205364948516939506L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"WebdispAvro\",\"namespace\":\"it.luca.streaming.data.model.webdisp\",\"fields\":[{\"name\":\"data_ora_invio\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"null\"]},{\"name\":\"pcs\",\"type\":[\"double\",\"null\"]},{\"name\":\"valore_energia\",\"type\":[\"double\",\"null\"]},{\"name\":\"unita_misura_energia\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"null\"]},{\"name\":\"valore_volume\",\"type\":[\"double\",\"null\"]},{\"name\":\"unita_misura_volume\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"null\"]},{\"name\":\"data_elaborazione\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"null\"]},{\"name\":\"data_decorrenza\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"null\"]},{\"name\":\"codice_remi\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"null\"]},{\"name\":\"descrizione_remi\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"null\"]},{\"name\":\"descrizione_punto\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"null\"]},{\"name\":\"tipo_nomina\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"null\"]},{\"name\":\"ciclo_nomina\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"null\"]},{\"name\":\"tipologia_punto\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"null\"]},{\"name\":\"ts_inserimento\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"dt_inserimento\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<WebdispAvro> ENCODER =
      new BinaryMessageEncoder<WebdispAvro>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<WebdispAvro> DECODER =
      new BinaryMessageDecoder<WebdispAvro>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   */
  public static BinaryMessageDecoder<WebdispAvro> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   */
  public static BinaryMessageDecoder<WebdispAvro> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<WebdispAvro>(MODEL$, SCHEMA$, resolver);
  }

  /** Serializes this WebdispAvro to a ByteBuffer. */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /** Deserializes a WebdispAvro from a ByteBuffer. */
  public static WebdispAvro fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

   private java.lang.String data_ora_invio;
   private java.lang.Double pcs;
   private java.lang.Double valore_energia;
   private java.lang.String unita_misura_energia;
   private java.lang.Double valore_volume;
   private java.lang.String unita_misura_volume;
   private java.lang.String data_elaborazione;
   private java.lang.String data_decorrenza;
   private java.lang.String codice_remi;
   private java.lang.String descrizione_remi;
   private java.lang.String descrizione_punto;
   private java.lang.String tipo_nomina;
   private java.lang.String ciclo_nomina;
   private java.lang.String tipologia_punto;
   private java.lang.String ts_inserimento;
   private java.lang.String dt_inserimento;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public WebdispAvro() {}

  /**
   * All-args constructor.
   * @param data_ora_invio The new value for data_ora_invio
   * @param pcs The new value for pcs
   * @param valore_energia The new value for valore_energia
   * @param unita_misura_energia The new value for unita_misura_energia
   * @param valore_volume The new value for valore_volume
   * @param unita_misura_volume The new value for unita_misura_volume
   * @param data_elaborazione The new value for data_elaborazione
   * @param data_decorrenza The new value for data_decorrenza
   * @param codice_remi The new value for codice_remi
   * @param descrizione_remi The new value for descrizione_remi
   * @param descrizione_punto The new value for descrizione_punto
   * @param tipo_nomina The new value for tipo_nomina
   * @param ciclo_nomina The new value for ciclo_nomina
   * @param tipologia_punto The new value for tipologia_punto
   * @param ts_inserimento The new value for ts_inserimento
   * @param dt_inserimento The new value for dt_inserimento
   */
  public WebdispAvro(java.lang.String data_ora_invio, java.lang.Double pcs, java.lang.Double valore_energia, java.lang.String unita_misura_energia, java.lang.Double valore_volume, java.lang.String unita_misura_volume, java.lang.String data_elaborazione, java.lang.String data_decorrenza, java.lang.String codice_remi, java.lang.String descrizione_remi, java.lang.String descrizione_punto, java.lang.String tipo_nomina, java.lang.String ciclo_nomina, java.lang.String tipologia_punto, java.lang.String ts_inserimento, java.lang.String dt_inserimento) {
    this.data_ora_invio = data_ora_invio;
    this.pcs = pcs;
    this.valore_energia = valore_energia;
    this.unita_misura_energia = unita_misura_energia;
    this.valore_volume = valore_volume;
    this.unita_misura_volume = unita_misura_volume;
    this.data_elaborazione = data_elaborazione;
    this.data_decorrenza = data_decorrenza;
    this.codice_remi = codice_remi;
    this.descrizione_remi = descrizione_remi;
    this.descrizione_punto = descrizione_punto;
    this.tipo_nomina = tipo_nomina;
    this.ciclo_nomina = ciclo_nomina;
    this.tipologia_punto = tipologia_punto;
    this.ts_inserimento = ts_inserimento;
    this.dt_inserimento = dt_inserimento;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return data_ora_invio;
    case 1: return pcs;
    case 2: return valore_energia;
    case 3: return unita_misura_energia;
    case 4: return valore_volume;
    case 5: return unita_misura_volume;
    case 6: return data_elaborazione;
    case 7: return data_decorrenza;
    case 8: return codice_remi;
    case 9: return descrizione_remi;
    case 10: return descrizione_punto;
    case 11: return tipo_nomina;
    case 12: return ciclo_nomina;
    case 13: return tipologia_punto;
    case 14: return ts_inserimento;
    case 15: return dt_inserimento;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: data_ora_invio = (java.lang.String)value$; break;
    case 1: pcs = (java.lang.Double)value$; break;
    case 2: valore_energia = (java.lang.Double)value$; break;
    case 3: unita_misura_energia = (java.lang.String)value$; break;
    case 4: valore_volume = (java.lang.Double)value$; break;
    case 5: unita_misura_volume = (java.lang.String)value$; break;
    case 6: data_elaborazione = (java.lang.String)value$; break;
    case 7: data_decorrenza = (java.lang.String)value$; break;
    case 8: codice_remi = (java.lang.String)value$; break;
    case 9: descrizione_remi = (java.lang.String)value$; break;
    case 10: descrizione_punto = (java.lang.String)value$; break;
    case 11: tipo_nomina = (java.lang.String)value$; break;
    case 12: ciclo_nomina = (java.lang.String)value$; break;
    case 13: tipologia_punto = (java.lang.String)value$; break;
    case 14: ts_inserimento = (java.lang.String)value$; break;
    case 15: dt_inserimento = (java.lang.String)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'data_ora_invio' field.
   * @return The value of the 'data_ora_invio' field.
   */
  public java.lang.String getDataOraInvio() {
    return data_ora_invio;
  }

  /**
   * Sets the value of the 'data_ora_invio' field.
   * @param value the value to set.
   */
  public void setDataOraInvio(java.lang.String value) {
    this.data_ora_invio = value;
  }

  /**
   * Gets the value of the 'pcs' field.
   * @return The value of the 'pcs' field.
   */
  public java.lang.Double getPcs() {
    return pcs;
  }

  /**
   * Sets the value of the 'pcs' field.
   * @param value the value to set.
   */
  public void setPcs(java.lang.Double value) {
    this.pcs = value;
  }

  /**
   * Gets the value of the 'valore_energia' field.
   * @return The value of the 'valore_energia' field.
   */
  public java.lang.Double getValoreEnergia() {
    return valore_energia;
  }

  /**
   * Sets the value of the 'valore_energia' field.
   * @param value the value to set.
   */
  public void setValoreEnergia(java.lang.Double value) {
    this.valore_energia = value;
  }

  /**
   * Gets the value of the 'unita_misura_energia' field.
   * @return The value of the 'unita_misura_energia' field.
   */
  public java.lang.String getUnitaMisuraEnergia() {
    return unita_misura_energia;
  }

  /**
   * Sets the value of the 'unita_misura_energia' field.
   * @param value the value to set.
   */
  public void setUnitaMisuraEnergia(java.lang.String value) {
    this.unita_misura_energia = value;
  }

  /**
   * Gets the value of the 'valore_volume' field.
   * @return The value of the 'valore_volume' field.
   */
  public java.lang.Double getValoreVolume() {
    return valore_volume;
  }

  /**
   * Sets the value of the 'valore_volume' field.
   * @param value the value to set.
   */
  public void setValoreVolume(java.lang.Double value) {
    this.valore_volume = value;
  }

  /**
   * Gets the value of the 'unita_misura_volume' field.
   * @return The value of the 'unita_misura_volume' field.
   */
  public java.lang.String getUnitaMisuraVolume() {
    return unita_misura_volume;
  }

  /**
   * Sets the value of the 'unita_misura_volume' field.
   * @param value the value to set.
   */
  public void setUnitaMisuraVolume(java.lang.String value) {
    this.unita_misura_volume = value;
  }

  /**
   * Gets the value of the 'data_elaborazione' field.
   * @return The value of the 'data_elaborazione' field.
   */
  public java.lang.String getDataElaborazione() {
    return data_elaborazione;
  }

  /**
   * Sets the value of the 'data_elaborazione' field.
   * @param value the value to set.
   */
  public void setDataElaborazione(java.lang.String value) {
    this.data_elaborazione = value;
  }

  /**
   * Gets the value of the 'data_decorrenza' field.
   * @return The value of the 'data_decorrenza' field.
   */
  public java.lang.String getDataDecorrenza() {
    return data_decorrenza;
  }

  /**
   * Sets the value of the 'data_decorrenza' field.
   * @param value the value to set.
   */
  public void setDataDecorrenza(java.lang.String value) {
    this.data_decorrenza = value;
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
   * Gets the value of the 'descrizione_remi' field.
   * @return The value of the 'descrizione_remi' field.
   */
  public java.lang.String getDescrizioneRemi() {
    return descrizione_remi;
  }

  /**
   * Sets the value of the 'descrizione_remi' field.
   * @param value the value to set.
   */
  public void setDescrizioneRemi(java.lang.String value) {
    this.descrizione_remi = value;
  }

  /**
   * Gets the value of the 'descrizione_punto' field.
   * @return The value of the 'descrizione_punto' field.
   */
  public java.lang.String getDescrizionePunto() {
    return descrizione_punto;
  }

  /**
   * Sets the value of the 'descrizione_punto' field.
   * @param value the value to set.
   */
  public void setDescrizionePunto(java.lang.String value) {
    this.descrizione_punto = value;
  }

  /**
   * Gets the value of the 'tipo_nomina' field.
   * @return The value of the 'tipo_nomina' field.
   */
  public java.lang.String getTipoNomina() {
    return tipo_nomina;
  }

  /**
   * Sets the value of the 'tipo_nomina' field.
   * @param value the value to set.
   */
  public void setTipoNomina(java.lang.String value) {
    this.tipo_nomina = value;
  }

  /**
   * Gets the value of the 'ciclo_nomina' field.
   * @return The value of the 'ciclo_nomina' field.
   */
  public java.lang.String getCicloNomina() {
    return ciclo_nomina;
  }

  /**
   * Sets the value of the 'ciclo_nomina' field.
   * @param value the value to set.
   */
  public void setCicloNomina(java.lang.String value) {
    this.ciclo_nomina = value;
  }

  /**
   * Gets the value of the 'tipologia_punto' field.
   * @return The value of the 'tipologia_punto' field.
   */
  public java.lang.String getTipologiaPunto() {
    return tipologia_punto;
  }

  /**
   * Sets the value of the 'tipologia_punto' field.
   * @param value the value to set.
   */
  public void setTipologiaPunto(java.lang.String value) {
    this.tipologia_punto = value;
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
   * Creates a new WebdispAvro RecordBuilder.
   * @return A new WebdispAvro RecordBuilder
   */
  public static it.luca.streaming.data.model.webdisp.WebdispAvro.Builder newBuilder() {
    return new it.luca.streaming.data.model.webdisp.WebdispAvro.Builder();
  }

  /**
   * Creates a new WebdispAvro RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new WebdispAvro RecordBuilder
   */
  public static it.luca.streaming.data.model.webdisp.WebdispAvro.Builder newBuilder(it.luca.streaming.data.model.webdisp.WebdispAvro.Builder other) {
    return new it.luca.streaming.data.model.webdisp.WebdispAvro.Builder(other);
  }

  /**
   * Creates a new WebdispAvro RecordBuilder by copying an existing WebdispAvro instance.
   * @param other The existing instance to copy.
   * @return A new WebdispAvro RecordBuilder
   */
  public static it.luca.streaming.data.model.webdisp.WebdispAvro.Builder newBuilder(it.luca.streaming.data.model.webdisp.WebdispAvro other) {
    return new it.luca.streaming.data.model.webdisp.WebdispAvro.Builder(other);
  }

  /**
   * RecordBuilder for WebdispAvro instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<WebdispAvro>
    implements org.apache.avro.data.RecordBuilder<WebdispAvro> {

    private java.lang.String data_ora_invio;
    private java.lang.Double pcs;
    private java.lang.Double valore_energia;
    private java.lang.String unita_misura_energia;
    private java.lang.Double valore_volume;
    private java.lang.String unita_misura_volume;
    private java.lang.String data_elaborazione;
    private java.lang.String data_decorrenza;
    private java.lang.String codice_remi;
    private java.lang.String descrizione_remi;
    private java.lang.String descrizione_punto;
    private java.lang.String tipo_nomina;
    private java.lang.String ciclo_nomina;
    private java.lang.String tipologia_punto;
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
    private Builder(it.luca.streaming.data.model.webdisp.WebdispAvro.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.data_ora_invio)) {
        this.data_ora_invio = data().deepCopy(fields()[0].schema(), other.data_ora_invio);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.pcs)) {
        this.pcs = data().deepCopy(fields()[1].schema(), other.pcs);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.valore_energia)) {
        this.valore_energia = data().deepCopy(fields()[2].schema(), other.valore_energia);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.unita_misura_energia)) {
        this.unita_misura_energia = data().deepCopy(fields()[3].schema(), other.unita_misura_energia);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.valore_volume)) {
        this.valore_volume = data().deepCopy(fields()[4].schema(), other.valore_volume);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.unita_misura_volume)) {
        this.unita_misura_volume = data().deepCopy(fields()[5].schema(), other.unita_misura_volume);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.data_elaborazione)) {
        this.data_elaborazione = data().deepCopy(fields()[6].schema(), other.data_elaborazione);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.data_decorrenza)) {
        this.data_decorrenza = data().deepCopy(fields()[7].schema(), other.data_decorrenza);
        fieldSetFlags()[7] = true;
      }
      if (isValidValue(fields()[8], other.codice_remi)) {
        this.codice_remi = data().deepCopy(fields()[8].schema(), other.codice_remi);
        fieldSetFlags()[8] = true;
      }
      if (isValidValue(fields()[9], other.descrizione_remi)) {
        this.descrizione_remi = data().deepCopy(fields()[9].schema(), other.descrizione_remi);
        fieldSetFlags()[9] = true;
      }
      if (isValidValue(fields()[10], other.descrizione_punto)) {
        this.descrizione_punto = data().deepCopy(fields()[10].schema(), other.descrizione_punto);
        fieldSetFlags()[10] = true;
      }
      if (isValidValue(fields()[11], other.tipo_nomina)) {
        this.tipo_nomina = data().deepCopy(fields()[11].schema(), other.tipo_nomina);
        fieldSetFlags()[11] = true;
      }
      if (isValidValue(fields()[12], other.ciclo_nomina)) {
        this.ciclo_nomina = data().deepCopy(fields()[12].schema(), other.ciclo_nomina);
        fieldSetFlags()[12] = true;
      }
      if (isValidValue(fields()[13], other.tipologia_punto)) {
        this.tipologia_punto = data().deepCopy(fields()[13].schema(), other.tipologia_punto);
        fieldSetFlags()[13] = true;
      }
      if (isValidValue(fields()[14], other.ts_inserimento)) {
        this.ts_inserimento = data().deepCopy(fields()[14].schema(), other.ts_inserimento);
        fieldSetFlags()[14] = true;
      }
      if (isValidValue(fields()[15], other.dt_inserimento)) {
        this.dt_inserimento = data().deepCopy(fields()[15].schema(), other.dt_inserimento);
        fieldSetFlags()[15] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing WebdispAvro instance
     * @param other The existing instance to copy.
     */
    private Builder(it.luca.streaming.data.model.webdisp.WebdispAvro other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.data_ora_invio)) {
        this.data_ora_invio = data().deepCopy(fields()[0].schema(), other.data_ora_invio);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.pcs)) {
        this.pcs = data().deepCopy(fields()[1].schema(), other.pcs);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.valore_energia)) {
        this.valore_energia = data().deepCopy(fields()[2].schema(), other.valore_energia);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.unita_misura_energia)) {
        this.unita_misura_energia = data().deepCopy(fields()[3].schema(), other.unita_misura_energia);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.valore_volume)) {
        this.valore_volume = data().deepCopy(fields()[4].schema(), other.valore_volume);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.unita_misura_volume)) {
        this.unita_misura_volume = data().deepCopy(fields()[5].schema(), other.unita_misura_volume);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.data_elaborazione)) {
        this.data_elaborazione = data().deepCopy(fields()[6].schema(), other.data_elaborazione);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.data_decorrenza)) {
        this.data_decorrenza = data().deepCopy(fields()[7].schema(), other.data_decorrenza);
        fieldSetFlags()[7] = true;
      }
      if (isValidValue(fields()[8], other.codice_remi)) {
        this.codice_remi = data().deepCopy(fields()[8].schema(), other.codice_remi);
        fieldSetFlags()[8] = true;
      }
      if (isValidValue(fields()[9], other.descrizione_remi)) {
        this.descrizione_remi = data().deepCopy(fields()[9].schema(), other.descrizione_remi);
        fieldSetFlags()[9] = true;
      }
      if (isValidValue(fields()[10], other.descrizione_punto)) {
        this.descrizione_punto = data().deepCopy(fields()[10].schema(), other.descrizione_punto);
        fieldSetFlags()[10] = true;
      }
      if (isValidValue(fields()[11], other.tipo_nomina)) {
        this.tipo_nomina = data().deepCopy(fields()[11].schema(), other.tipo_nomina);
        fieldSetFlags()[11] = true;
      }
      if (isValidValue(fields()[12], other.ciclo_nomina)) {
        this.ciclo_nomina = data().deepCopy(fields()[12].schema(), other.ciclo_nomina);
        fieldSetFlags()[12] = true;
      }
      if (isValidValue(fields()[13], other.tipologia_punto)) {
        this.tipologia_punto = data().deepCopy(fields()[13].schema(), other.tipologia_punto);
        fieldSetFlags()[13] = true;
      }
      if (isValidValue(fields()[14], other.ts_inserimento)) {
        this.ts_inserimento = data().deepCopy(fields()[14].schema(), other.ts_inserimento);
        fieldSetFlags()[14] = true;
      }
      if (isValidValue(fields()[15], other.dt_inserimento)) {
        this.dt_inserimento = data().deepCopy(fields()[15].schema(), other.dt_inserimento);
        fieldSetFlags()[15] = true;
      }
    }

    /**
      * Gets the value of the 'data_ora_invio' field.
      * @return The value.
      */
    public java.lang.String getDataOraInvio() {
      return data_ora_invio;
    }

    /**
      * Sets the value of the 'data_ora_invio' field.
      * @param value The value of 'data_ora_invio'.
      * @return This builder.
      */
    public it.luca.streaming.data.model.webdisp.WebdispAvro.Builder setDataOraInvio(java.lang.String value) {
      validate(fields()[0], value);
      this.data_ora_invio = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'data_ora_invio' field has been set.
      * @return True if the 'data_ora_invio' field has been set, false otherwise.
      */
    public boolean hasDataOraInvio() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'data_ora_invio' field.
      * @return This builder.
      */
    public it.luca.streaming.data.model.webdisp.WebdispAvro.Builder clearDataOraInvio() {
      data_ora_invio = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'pcs' field.
      * @return The value.
      */
    public java.lang.Double getPcs() {
      return pcs;
    }

    /**
      * Sets the value of the 'pcs' field.
      * @param value The value of 'pcs'.
      * @return This builder.
      */
    public it.luca.streaming.data.model.webdisp.WebdispAvro.Builder setPcs(java.lang.Double value) {
      validate(fields()[1], value);
      this.pcs = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'pcs' field has been set.
      * @return True if the 'pcs' field has been set, false otherwise.
      */
    public boolean hasPcs() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'pcs' field.
      * @return This builder.
      */
    public it.luca.streaming.data.model.webdisp.WebdispAvro.Builder clearPcs() {
      pcs = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'valore_energia' field.
      * @return The value.
      */
    public java.lang.Double getValoreEnergia() {
      return valore_energia;
    }

    /**
      * Sets the value of the 'valore_energia' field.
      * @param value The value of 'valore_energia'.
      * @return This builder.
      */
    public it.luca.streaming.data.model.webdisp.WebdispAvro.Builder setValoreEnergia(java.lang.Double value) {
      validate(fields()[2], value);
      this.valore_energia = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'valore_energia' field has been set.
      * @return True if the 'valore_energia' field has been set, false otherwise.
      */
    public boolean hasValoreEnergia() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'valore_energia' field.
      * @return This builder.
      */
    public it.luca.streaming.data.model.webdisp.WebdispAvro.Builder clearValoreEnergia() {
      valore_energia = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'unita_misura_energia' field.
      * @return The value.
      */
    public java.lang.String getUnitaMisuraEnergia() {
      return unita_misura_energia;
    }

    /**
      * Sets the value of the 'unita_misura_energia' field.
      * @param value The value of 'unita_misura_energia'.
      * @return This builder.
      */
    public it.luca.streaming.data.model.webdisp.WebdispAvro.Builder setUnitaMisuraEnergia(java.lang.String value) {
      validate(fields()[3], value);
      this.unita_misura_energia = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'unita_misura_energia' field has been set.
      * @return True if the 'unita_misura_energia' field has been set, false otherwise.
      */
    public boolean hasUnitaMisuraEnergia() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'unita_misura_energia' field.
      * @return This builder.
      */
    public it.luca.streaming.data.model.webdisp.WebdispAvro.Builder clearUnitaMisuraEnergia() {
      unita_misura_energia = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'valore_volume' field.
      * @return The value.
      */
    public java.lang.Double getValoreVolume() {
      return valore_volume;
    }

    /**
      * Sets the value of the 'valore_volume' field.
      * @param value The value of 'valore_volume'.
      * @return This builder.
      */
    public it.luca.streaming.data.model.webdisp.WebdispAvro.Builder setValoreVolume(java.lang.Double value) {
      validate(fields()[4], value);
      this.valore_volume = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'valore_volume' field has been set.
      * @return True if the 'valore_volume' field has been set, false otherwise.
      */
    public boolean hasValoreVolume() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'valore_volume' field.
      * @return This builder.
      */
    public it.luca.streaming.data.model.webdisp.WebdispAvro.Builder clearValoreVolume() {
      valore_volume = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'unita_misura_volume' field.
      * @return The value.
      */
    public java.lang.String getUnitaMisuraVolume() {
      return unita_misura_volume;
    }

    /**
      * Sets the value of the 'unita_misura_volume' field.
      * @param value The value of 'unita_misura_volume'.
      * @return This builder.
      */
    public it.luca.streaming.data.model.webdisp.WebdispAvro.Builder setUnitaMisuraVolume(java.lang.String value) {
      validate(fields()[5], value);
      this.unita_misura_volume = value;
      fieldSetFlags()[5] = true;
      return this;
    }

    /**
      * Checks whether the 'unita_misura_volume' field has been set.
      * @return True if the 'unita_misura_volume' field has been set, false otherwise.
      */
    public boolean hasUnitaMisuraVolume() {
      return fieldSetFlags()[5];
    }


    /**
      * Clears the value of the 'unita_misura_volume' field.
      * @return This builder.
      */
    public it.luca.streaming.data.model.webdisp.WebdispAvro.Builder clearUnitaMisuraVolume() {
      unita_misura_volume = null;
      fieldSetFlags()[5] = false;
      return this;
    }

    /**
      * Gets the value of the 'data_elaborazione' field.
      * @return The value.
      */
    public java.lang.String getDataElaborazione() {
      return data_elaborazione;
    }

    /**
      * Sets the value of the 'data_elaborazione' field.
      * @param value The value of 'data_elaborazione'.
      * @return This builder.
      */
    public it.luca.streaming.data.model.webdisp.WebdispAvro.Builder setDataElaborazione(java.lang.String value) {
      validate(fields()[6], value);
      this.data_elaborazione = value;
      fieldSetFlags()[6] = true;
      return this;
    }

    /**
      * Checks whether the 'data_elaborazione' field has been set.
      * @return True if the 'data_elaborazione' field has been set, false otherwise.
      */
    public boolean hasDataElaborazione() {
      return fieldSetFlags()[6];
    }


    /**
      * Clears the value of the 'data_elaborazione' field.
      * @return This builder.
      */
    public it.luca.streaming.data.model.webdisp.WebdispAvro.Builder clearDataElaborazione() {
      data_elaborazione = null;
      fieldSetFlags()[6] = false;
      return this;
    }

    /**
      * Gets the value of the 'data_decorrenza' field.
      * @return The value.
      */
    public java.lang.String getDataDecorrenza() {
      return data_decorrenza;
    }

    /**
      * Sets the value of the 'data_decorrenza' field.
      * @param value The value of 'data_decorrenza'.
      * @return This builder.
      */
    public it.luca.streaming.data.model.webdisp.WebdispAvro.Builder setDataDecorrenza(java.lang.String value) {
      validate(fields()[7], value);
      this.data_decorrenza = value;
      fieldSetFlags()[7] = true;
      return this;
    }

    /**
      * Checks whether the 'data_decorrenza' field has been set.
      * @return True if the 'data_decorrenza' field has been set, false otherwise.
      */
    public boolean hasDataDecorrenza() {
      return fieldSetFlags()[7];
    }


    /**
      * Clears the value of the 'data_decorrenza' field.
      * @return This builder.
      */
    public it.luca.streaming.data.model.webdisp.WebdispAvro.Builder clearDataDecorrenza() {
      data_decorrenza = null;
      fieldSetFlags()[7] = false;
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
    public it.luca.streaming.data.model.webdisp.WebdispAvro.Builder setCodiceRemi(java.lang.String value) {
      validate(fields()[8], value);
      this.codice_remi = value;
      fieldSetFlags()[8] = true;
      return this;
    }

    /**
      * Checks whether the 'codice_remi' field has been set.
      * @return True if the 'codice_remi' field has been set, false otherwise.
      */
    public boolean hasCodiceRemi() {
      return fieldSetFlags()[8];
    }


    /**
      * Clears the value of the 'codice_remi' field.
      * @return This builder.
      */
    public it.luca.streaming.data.model.webdisp.WebdispAvro.Builder clearCodiceRemi() {
      codice_remi = null;
      fieldSetFlags()[8] = false;
      return this;
    }

    /**
      * Gets the value of the 'descrizione_remi' field.
      * @return The value.
      */
    public java.lang.String getDescrizioneRemi() {
      return descrizione_remi;
    }

    /**
      * Sets the value of the 'descrizione_remi' field.
      * @param value The value of 'descrizione_remi'.
      * @return This builder.
      */
    public it.luca.streaming.data.model.webdisp.WebdispAvro.Builder setDescrizioneRemi(java.lang.String value) {
      validate(fields()[9], value);
      this.descrizione_remi = value;
      fieldSetFlags()[9] = true;
      return this;
    }

    /**
      * Checks whether the 'descrizione_remi' field has been set.
      * @return True if the 'descrizione_remi' field has been set, false otherwise.
      */
    public boolean hasDescrizioneRemi() {
      return fieldSetFlags()[9];
    }


    /**
      * Clears the value of the 'descrizione_remi' field.
      * @return This builder.
      */
    public it.luca.streaming.data.model.webdisp.WebdispAvro.Builder clearDescrizioneRemi() {
      descrizione_remi = null;
      fieldSetFlags()[9] = false;
      return this;
    }

    /**
      * Gets the value of the 'descrizione_punto' field.
      * @return The value.
      */
    public java.lang.String getDescrizionePunto() {
      return descrizione_punto;
    }

    /**
      * Sets the value of the 'descrizione_punto' field.
      * @param value The value of 'descrizione_punto'.
      * @return This builder.
      */
    public it.luca.streaming.data.model.webdisp.WebdispAvro.Builder setDescrizionePunto(java.lang.String value) {
      validate(fields()[10], value);
      this.descrizione_punto = value;
      fieldSetFlags()[10] = true;
      return this;
    }

    /**
      * Checks whether the 'descrizione_punto' field has been set.
      * @return True if the 'descrizione_punto' field has been set, false otherwise.
      */
    public boolean hasDescrizionePunto() {
      return fieldSetFlags()[10];
    }


    /**
      * Clears the value of the 'descrizione_punto' field.
      * @return This builder.
      */
    public it.luca.streaming.data.model.webdisp.WebdispAvro.Builder clearDescrizionePunto() {
      descrizione_punto = null;
      fieldSetFlags()[10] = false;
      return this;
    }

    /**
      * Gets the value of the 'tipo_nomina' field.
      * @return The value.
      */
    public java.lang.String getTipoNomina() {
      return tipo_nomina;
    }

    /**
      * Sets the value of the 'tipo_nomina' field.
      * @param value The value of 'tipo_nomina'.
      * @return This builder.
      */
    public it.luca.streaming.data.model.webdisp.WebdispAvro.Builder setTipoNomina(java.lang.String value) {
      validate(fields()[11], value);
      this.tipo_nomina = value;
      fieldSetFlags()[11] = true;
      return this;
    }

    /**
      * Checks whether the 'tipo_nomina' field has been set.
      * @return True if the 'tipo_nomina' field has been set, false otherwise.
      */
    public boolean hasTipoNomina() {
      return fieldSetFlags()[11];
    }


    /**
      * Clears the value of the 'tipo_nomina' field.
      * @return This builder.
      */
    public it.luca.streaming.data.model.webdisp.WebdispAvro.Builder clearTipoNomina() {
      tipo_nomina = null;
      fieldSetFlags()[11] = false;
      return this;
    }

    /**
      * Gets the value of the 'ciclo_nomina' field.
      * @return The value.
      */
    public java.lang.String getCicloNomina() {
      return ciclo_nomina;
    }

    /**
      * Sets the value of the 'ciclo_nomina' field.
      * @param value The value of 'ciclo_nomina'.
      * @return This builder.
      */
    public it.luca.streaming.data.model.webdisp.WebdispAvro.Builder setCicloNomina(java.lang.String value) {
      validate(fields()[12], value);
      this.ciclo_nomina = value;
      fieldSetFlags()[12] = true;
      return this;
    }

    /**
      * Checks whether the 'ciclo_nomina' field has been set.
      * @return True if the 'ciclo_nomina' field has been set, false otherwise.
      */
    public boolean hasCicloNomina() {
      return fieldSetFlags()[12];
    }


    /**
      * Clears the value of the 'ciclo_nomina' field.
      * @return This builder.
      */
    public it.luca.streaming.data.model.webdisp.WebdispAvro.Builder clearCicloNomina() {
      ciclo_nomina = null;
      fieldSetFlags()[12] = false;
      return this;
    }

    /**
      * Gets the value of the 'tipologia_punto' field.
      * @return The value.
      */
    public java.lang.String getTipologiaPunto() {
      return tipologia_punto;
    }

    /**
      * Sets the value of the 'tipologia_punto' field.
      * @param value The value of 'tipologia_punto'.
      * @return This builder.
      */
    public it.luca.streaming.data.model.webdisp.WebdispAvro.Builder setTipologiaPunto(java.lang.String value) {
      validate(fields()[13], value);
      this.tipologia_punto = value;
      fieldSetFlags()[13] = true;
      return this;
    }

    /**
      * Checks whether the 'tipologia_punto' field has been set.
      * @return True if the 'tipologia_punto' field has been set, false otherwise.
      */
    public boolean hasTipologiaPunto() {
      return fieldSetFlags()[13];
    }


    /**
      * Clears the value of the 'tipologia_punto' field.
      * @return This builder.
      */
    public it.luca.streaming.data.model.webdisp.WebdispAvro.Builder clearTipologiaPunto() {
      tipologia_punto = null;
      fieldSetFlags()[13] = false;
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
    public it.luca.streaming.data.model.webdisp.WebdispAvro.Builder setTsInserimento(java.lang.String value) {
      validate(fields()[14], value);
      this.ts_inserimento = value;
      fieldSetFlags()[14] = true;
      return this;
    }

    /**
      * Checks whether the 'ts_inserimento' field has been set.
      * @return True if the 'ts_inserimento' field has been set, false otherwise.
      */
    public boolean hasTsInserimento() {
      return fieldSetFlags()[14];
    }


    /**
      * Clears the value of the 'ts_inserimento' field.
      * @return This builder.
      */
    public it.luca.streaming.data.model.webdisp.WebdispAvro.Builder clearTsInserimento() {
      ts_inserimento = null;
      fieldSetFlags()[14] = false;
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
    public it.luca.streaming.data.model.webdisp.WebdispAvro.Builder setDtInserimento(java.lang.String value) {
      validate(fields()[15], value);
      this.dt_inserimento = value;
      fieldSetFlags()[15] = true;
      return this;
    }

    /**
      * Checks whether the 'dt_inserimento' field has been set.
      * @return True if the 'dt_inserimento' field has been set, false otherwise.
      */
    public boolean hasDtInserimento() {
      return fieldSetFlags()[15];
    }


    /**
      * Clears the value of the 'dt_inserimento' field.
      * @return This builder.
      */
    public it.luca.streaming.data.model.webdisp.WebdispAvro.Builder clearDtInserimento() {
      dt_inserimento = null;
      fieldSetFlags()[15] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public WebdispAvro build() {
      try {
        WebdispAvro record = new WebdispAvro();
        record.data_ora_invio = fieldSetFlags()[0] ? this.data_ora_invio : (java.lang.String) defaultValue(fields()[0]);
        record.pcs = fieldSetFlags()[1] ? this.pcs : (java.lang.Double) defaultValue(fields()[1]);
        record.valore_energia = fieldSetFlags()[2] ? this.valore_energia : (java.lang.Double) defaultValue(fields()[2]);
        record.unita_misura_energia = fieldSetFlags()[3] ? this.unita_misura_energia : (java.lang.String) defaultValue(fields()[3]);
        record.valore_volume = fieldSetFlags()[4] ? this.valore_volume : (java.lang.Double) defaultValue(fields()[4]);
        record.unita_misura_volume = fieldSetFlags()[5] ? this.unita_misura_volume : (java.lang.String) defaultValue(fields()[5]);
        record.data_elaborazione = fieldSetFlags()[6] ? this.data_elaborazione : (java.lang.String) defaultValue(fields()[6]);
        record.data_decorrenza = fieldSetFlags()[7] ? this.data_decorrenza : (java.lang.String) defaultValue(fields()[7]);
        record.codice_remi = fieldSetFlags()[8] ? this.codice_remi : (java.lang.String) defaultValue(fields()[8]);
        record.descrizione_remi = fieldSetFlags()[9] ? this.descrizione_remi : (java.lang.String) defaultValue(fields()[9]);
        record.descrizione_punto = fieldSetFlags()[10] ? this.descrizione_punto : (java.lang.String) defaultValue(fields()[10]);
        record.tipo_nomina = fieldSetFlags()[11] ? this.tipo_nomina : (java.lang.String) defaultValue(fields()[11]);
        record.ciclo_nomina = fieldSetFlags()[12] ? this.ciclo_nomina : (java.lang.String) defaultValue(fields()[12]);
        record.tipologia_punto = fieldSetFlags()[13] ? this.tipologia_punto : (java.lang.String) defaultValue(fields()[13]);
        record.ts_inserimento = fieldSetFlags()[14] ? this.ts_inserimento : (java.lang.String) defaultValue(fields()[14]);
        record.dt_inserimento = fieldSetFlags()[15] ? this.dt_inserimento : (java.lang.String) defaultValue(fields()[15]);
        return record;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<WebdispAvro>
    WRITER$ = (org.apache.avro.io.DatumWriter<WebdispAvro>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<WebdispAvro>
    READER$ = (org.apache.avro.io.DatumReader<WebdispAvro>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}
