package it.luca.streaming.data.model.jarvis;

import org.apache.avro.specific.SpecificData;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class JarvisAvro extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 1513211330111494996L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"JarvisAvro\",\"namespace\":\"it.luca.streaming.data.model.jarvis\",\"fields\":[{\"name\":\"ambito_flusso\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"null\"]},{\"name\":\"nome_flusso\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"null\"]},{\"name\":\"impresa_mittente\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"null\"]},{\"name\":\"data_di_creazione\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"null\"]},{\"name\":\"numero_dati\",\"type\":[\"int\",\"null\"]},{\"name\":\"data_procedura\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"null\"]},{\"name\":\"ciclo_di_riferimento\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"null\"]},{\"name\":\"rinomina_energia\",\"type\":[\"double\",\"null\"]},{\"name\":\"unita_di_misura_energia_rinomina\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"null\"]},{\"name\":\"limite_minimo_energia\",\"type\":[\"double\",\"null\"]},{\"name\":\"unita_di_misura_energia_limite_minimo\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"null\"]},{\"name\":\"limite_massimo_energia\",\"type\":[\"double\",\"null\"]},{\"name\":\"unita_di_misura_energia_limite_massimo\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"null\"]},{\"name\":\"ts_inserimento\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"dt_inserimento\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<JarvisAvro> ENCODER =
      new BinaryMessageEncoder<JarvisAvro>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<JarvisAvro> DECODER =
      new BinaryMessageDecoder<JarvisAvro>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   */
  public static BinaryMessageDecoder<JarvisAvro> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   */
  public static BinaryMessageDecoder<JarvisAvro> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<JarvisAvro>(MODEL$, SCHEMA$, resolver);
  }

  /** Serializes this JarvisAvro to a ByteBuffer. */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /** Deserializes a JarvisAvro from a ByteBuffer. */
  public static JarvisAvro fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

   private java.lang.String ambito_flusso;
   private java.lang.String nome_flusso;
   private java.lang.String impresa_mittente;
   private java.lang.String data_di_creazione;
   private java.lang.Integer numero_dati;
   private java.lang.String data_procedura;
   private java.lang.String ciclo_di_riferimento;
   private java.lang.Double rinomina_energia;
   private java.lang.String unita_di_misura_energia_rinomina;
   private java.lang.Double limite_minimo_energia;
   private java.lang.String unita_di_misura_energia_limite_minimo;
   private java.lang.Double limite_massimo_energia;
   private java.lang.String unita_di_misura_energia_limite_massimo;
   private java.lang.String ts_inserimento;
   private java.lang.String dt_inserimento;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public JarvisAvro() {}

  /**
   * All-args constructor.
   * @param ambito_flusso The new value for ambito_flusso
   * @param nome_flusso The new value for nome_flusso
   * @param impresa_mittente The new value for impresa_mittente
   * @param data_di_creazione The new value for data_di_creazione
   * @param numero_dati The new value for numero_dati
   * @param data_procedura The new value for data_procedura
   * @param ciclo_di_riferimento The new value for ciclo_di_riferimento
   * @param rinomina_energia The new value for rinomina_energia
   * @param unita_di_misura_energia_rinomina The new value for unita_di_misura_energia_rinomina
   * @param limite_minimo_energia The new value for limite_minimo_energia
   * @param unita_di_misura_energia_limite_minimo The new value for unita_di_misura_energia_limite_minimo
   * @param limite_massimo_energia The new value for limite_massimo_energia
   * @param unita_di_misura_energia_limite_massimo The new value for unita_di_misura_energia_limite_massimo
   * @param ts_inserimento The new value for ts_inserimento
   * @param dt_inserimento The new value for dt_inserimento
   */
  public JarvisAvro(java.lang.String ambito_flusso, java.lang.String nome_flusso, java.lang.String impresa_mittente, java.lang.String data_di_creazione, java.lang.Integer numero_dati, java.lang.String data_procedura, java.lang.String ciclo_di_riferimento, java.lang.Double rinomina_energia, java.lang.String unita_di_misura_energia_rinomina, java.lang.Double limite_minimo_energia, java.lang.String unita_di_misura_energia_limite_minimo, java.lang.Double limite_massimo_energia, java.lang.String unita_di_misura_energia_limite_massimo, java.lang.String ts_inserimento, java.lang.String dt_inserimento) {
    this.ambito_flusso = ambito_flusso;
    this.nome_flusso = nome_flusso;
    this.impresa_mittente = impresa_mittente;
    this.data_di_creazione = data_di_creazione;
    this.numero_dati = numero_dati;
    this.data_procedura = data_procedura;
    this.ciclo_di_riferimento = ciclo_di_riferimento;
    this.rinomina_energia = rinomina_energia;
    this.unita_di_misura_energia_rinomina = unita_di_misura_energia_rinomina;
    this.limite_minimo_energia = limite_minimo_energia;
    this.unita_di_misura_energia_limite_minimo = unita_di_misura_energia_limite_minimo;
    this.limite_massimo_energia = limite_massimo_energia;
    this.unita_di_misura_energia_limite_massimo = unita_di_misura_energia_limite_massimo;
    this.ts_inserimento = ts_inserimento;
    this.dt_inserimento = dt_inserimento;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return ambito_flusso;
    case 1: return nome_flusso;
    case 2: return impresa_mittente;
    case 3: return data_di_creazione;
    case 4: return numero_dati;
    case 5: return data_procedura;
    case 6: return ciclo_di_riferimento;
    case 7: return rinomina_energia;
    case 8: return unita_di_misura_energia_rinomina;
    case 9: return limite_minimo_energia;
    case 10: return unita_di_misura_energia_limite_minimo;
    case 11: return limite_massimo_energia;
    case 12: return unita_di_misura_energia_limite_massimo;
    case 13: return ts_inserimento;
    case 14: return dt_inserimento;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: ambito_flusso = (java.lang.String)value$; break;
    case 1: nome_flusso = (java.lang.String)value$; break;
    case 2: impresa_mittente = (java.lang.String)value$; break;
    case 3: data_di_creazione = (java.lang.String)value$; break;
    case 4: numero_dati = (java.lang.Integer)value$; break;
    case 5: data_procedura = (java.lang.String)value$; break;
    case 6: ciclo_di_riferimento = (java.lang.String)value$; break;
    case 7: rinomina_energia = (java.lang.Double)value$; break;
    case 8: unita_di_misura_energia_rinomina = (java.lang.String)value$; break;
    case 9: limite_minimo_energia = (java.lang.Double)value$; break;
    case 10: unita_di_misura_energia_limite_minimo = (java.lang.String)value$; break;
    case 11: limite_massimo_energia = (java.lang.Double)value$; break;
    case 12: unita_di_misura_energia_limite_massimo = (java.lang.String)value$; break;
    case 13: ts_inserimento = (java.lang.String)value$; break;
    case 14: dt_inserimento = (java.lang.String)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'ambito_flusso' field.
   * @return The value of the 'ambito_flusso' field.
   */
  public java.lang.String getAmbitoFlusso() {
    return ambito_flusso;
  }

  /**
   * Sets the value of the 'ambito_flusso' field.
   * @param value the value to set.
   */
  public void setAmbitoFlusso(java.lang.String value) {
    this.ambito_flusso = value;
  }

  /**
   * Gets the value of the 'nome_flusso' field.
   * @return The value of the 'nome_flusso' field.
   */
  public java.lang.String getNomeFlusso() {
    return nome_flusso;
  }

  /**
   * Sets the value of the 'nome_flusso' field.
   * @param value the value to set.
   */
  public void setNomeFlusso(java.lang.String value) {
    this.nome_flusso = value;
  }

  /**
   * Gets the value of the 'impresa_mittente' field.
   * @return The value of the 'impresa_mittente' field.
   */
  public java.lang.String getImpresaMittente() {
    return impresa_mittente;
  }

  /**
   * Sets the value of the 'impresa_mittente' field.
   * @param value the value to set.
   */
  public void setImpresaMittente(java.lang.String value) {
    this.impresa_mittente = value;
  }

  /**
   * Gets the value of the 'data_di_creazione' field.
   * @return The value of the 'data_di_creazione' field.
   */
  public java.lang.String getDataDiCreazione() {
    return data_di_creazione;
  }

  /**
   * Sets the value of the 'data_di_creazione' field.
   * @param value the value to set.
   */
  public void setDataDiCreazione(java.lang.String value) {
    this.data_di_creazione = value;
  }

  /**
   * Gets the value of the 'numero_dati' field.
   * @return The value of the 'numero_dati' field.
   */
  public java.lang.Integer getNumeroDati() {
    return numero_dati;
  }

  /**
   * Sets the value of the 'numero_dati' field.
   * @param value the value to set.
   */
  public void setNumeroDati(java.lang.Integer value) {
    this.numero_dati = value;
  }

  /**
   * Gets the value of the 'data_procedura' field.
   * @return The value of the 'data_procedura' field.
   */
  public java.lang.String getDataProcedura() {
    return data_procedura;
  }

  /**
   * Sets the value of the 'data_procedura' field.
   * @param value the value to set.
   */
  public void setDataProcedura(java.lang.String value) {
    this.data_procedura = value;
  }

  /**
   * Gets the value of the 'ciclo_di_riferimento' field.
   * @return The value of the 'ciclo_di_riferimento' field.
   */
  public java.lang.String getCicloDiRiferimento() {
    return ciclo_di_riferimento;
  }

  /**
   * Sets the value of the 'ciclo_di_riferimento' field.
   * @param value the value to set.
   */
  public void setCicloDiRiferimento(java.lang.String value) {
    this.ciclo_di_riferimento = value;
  }

  /**
   * Gets the value of the 'rinomina_energia' field.
   * @return The value of the 'rinomina_energia' field.
   */
  public java.lang.Double getRinominaEnergia() {
    return rinomina_energia;
  }

  /**
   * Sets the value of the 'rinomina_energia' field.
   * @param value the value to set.
   */
  public void setRinominaEnergia(java.lang.Double value) {
    this.rinomina_energia = value;
  }

  /**
   * Gets the value of the 'unita_di_misura_energia_rinomina' field.
   * @return The value of the 'unita_di_misura_energia_rinomina' field.
   */
  public java.lang.String getUnitaDiMisuraEnergiaRinomina() {
    return unita_di_misura_energia_rinomina;
  }

  /**
   * Sets the value of the 'unita_di_misura_energia_rinomina' field.
   * @param value the value to set.
   */
  public void setUnitaDiMisuraEnergiaRinomina(java.lang.String value) {
    this.unita_di_misura_energia_rinomina = value;
  }

  /**
   * Gets the value of the 'limite_minimo_energia' field.
   * @return The value of the 'limite_minimo_energia' field.
   */
  public java.lang.Double getLimiteMinimoEnergia() {
    return limite_minimo_energia;
  }

  /**
   * Sets the value of the 'limite_minimo_energia' field.
   * @param value the value to set.
   */
  public void setLimiteMinimoEnergia(java.lang.Double value) {
    this.limite_minimo_energia = value;
  }

  /**
   * Gets the value of the 'unita_di_misura_energia_limite_minimo' field.
   * @return The value of the 'unita_di_misura_energia_limite_minimo' field.
   */
  public java.lang.String getUnitaDiMisuraEnergiaLimiteMinimo() {
    return unita_di_misura_energia_limite_minimo;
  }

  /**
   * Sets the value of the 'unita_di_misura_energia_limite_minimo' field.
   * @param value the value to set.
   */
  public void setUnitaDiMisuraEnergiaLimiteMinimo(java.lang.String value) {
    this.unita_di_misura_energia_limite_minimo = value;
  }

  /**
   * Gets the value of the 'limite_massimo_energia' field.
   * @return The value of the 'limite_massimo_energia' field.
   */
  public java.lang.Double getLimiteMassimoEnergia() {
    return limite_massimo_energia;
  }

  /**
   * Sets the value of the 'limite_massimo_energia' field.
   * @param value the value to set.
   */
  public void setLimiteMassimoEnergia(java.lang.Double value) {
    this.limite_massimo_energia = value;
  }

  /**
   * Gets the value of the 'unita_di_misura_energia_limite_massimo' field.
   * @return The value of the 'unita_di_misura_energia_limite_massimo' field.
   */
  public java.lang.String getUnitaDiMisuraEnergiaLimiteMassimo() {
    return unita_di_misura_energia_limite_massimo;
  }

  /**
   * Sets the value of the 'unita_di_misura_energia_limite_massimo' field.
   * @param value the value to set.
   */
  public void setUnitaDiMisuraEnergiaLimiteMassimo(java.lang.String value) {
    this.unita_di_misura_energia_limite_massimo = value;
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
   * Creates a new JarvisAvro RecordBuilder.
   * @return A new JarvisAvro RecordBuilder
   */
  public static it.luca.streaming.data.model.jarvis.JarvisAvro.Builder newBuilder() {
    return new it.luca.streaming.data.model.jarvis.JarvisAvro.Builder();
  }

  /**
   * Creates a new JarvisAvro RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new JarvisAvro RecordBuilder
   */
  public static it.luca.streaming.data.model.jarvis.JarvisAvro.Builder newBuilder(it.luca.streaming.data.model.jarvis.JarvisAvro.Builder other) {
    return new it.luca.streaming.data.model.jarvis.JarvisAvro.Builder(other);
  }

  /**
   * Creates a new JarvisAvro RecordBuilder by copying an existing JarvisAvro instance.
   * @param other The existing instance to copy.
   * @return A new JarvisAvro RecordBuilder
   */
  public static it.luca.streaming.data.model.jarvis.JarvisAvro.Builder newBuilder(it.luca.streaming.data.model.jarvis.JarvisAvro other) {
    return new it.luca.streaming.data.model.jarvis.JarvisAvro.Builder(other);
  }

  /**
   * RecordBuilder for JarvisAvro instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<JarvisAvro>
    implements org.apache.avro.data.RecordBuilder<JarvisAvro> {

    private java.lang.String ambito_flusso;
    private java.lang.String nome_flusso;
    private java.lang.String impresa_mittente;
    private java.lang.String data_di_creazione;
    private java.lang.Integer numero_dati;
    private java.lang.String data_procedura;
    private java.lang.String ciclo_di_riferimento;
    private java.lang.Double rinomina_energia;
    private java.lang.String unita_di_misura_energia_rinomina;
    private java.lang.Double limite_minimo_energia;
    private java.lang.String unita_di_misura_energia_limite_minimo;
    private java.lang.Double limite_massimo_energia;
    private java.lang.String unita_di_misura_energia_limite_massimo;
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
    private Builder(it.luca.streaming.data.model.jarvis.JarvisAvro.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.ambito_flusso)) {
        this.ambito_flusso = data().deepCopy(fields()[0].schema(), other.ambito_flusso);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.nome_flusso)) {
        this.nome_flusso = data().deepCopy(fields()[1].schema(), other.nome_flusso);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.impresa_mittente)) {
        this.impresa_mittente = data().deepCopy(fields()[2].schema(), other.impresa_mittente);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.data_di_creazione)) {
        this.data_di_creazione = data().deepCopy(fields()[3].schema(), other.data_di_creazione);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.numero_dati)) {
        this.numero_dati = data().deepCopy(fields()[4].schema(), other.numero_dati);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.data_procedura)) {
        this.data_procedura = data().deepCopy(fields()[5].schema(), other.data_procedura);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.ciclo_di_riferimento)) {
        this.ciclo_di_riferimento = data().deepCopy(fields()[6].schema(), other.ciclo_di_riferimento);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.rinomina_energia)) {
        this.rinomina_energia = data().deepCopy(fields()[7].schema(), other.rinomina_energia);
        fieldSetFlags()[7] = true;
      }
      if (isValidValue(fields()[8], other.unita_di_misura_energia_rinomina)) {
        this.unita_di_misura_energia_rinomina = data().deepCopy(fields()[8].schema(), other.unita_di_misura_energia_rinomina);
        fieldSetFlags()[8] = true;
      }
      if (isValidValue(fields()[9], other.limite_minimo_energia)) {
        this.limite_minimo_energia = data().deepCopy(fields()[9].schema(), other.limite_minimo_energia);
        fieldSetFlags()[9] = true;
      }
      if (isValidValue(fields()[10], other.unita_di_misura_energia_limite_minimo)) {
        this.unita_di_misura_energia_limite_minimo = data().deepCopy(fields()[10].schema(), other.unita_di_misura_energia_limite_minimo);
        fieldSetFlags()[10] = true;
      }
      if (isValidValue(fields()[11], other.limite_massimo_energia)) {
        this.limite_massimo_energia = data().deepCopy(fields()[11].schema(), other.limite_massimo_energia);
        fieldSetFlags()[11] = true;
      }
      if (isValidValue(fields()[12], other.unita_di_misura_energia_limite_massimo)) {
        this.unita_di_misura_energia_limite_massimo = data().deepCopy(fields()[12].schema(), other.unita_di_misura_energia_limite_massimo);
        fieldSetFlags()[12] = true;
      }
      if (isValidValue(fields()[13], other.ts_inserimento)) {
        this.ts_inserimento = data().deepCopy(fields()[13].schema(), other.ts_inserimento);
        fieldSetFlags()[13] = true;
      }
      if (isValidValue(fields()[14], other.dt_inserimento)) {
        this.dt_inserimento = data().deepCopy(fields()[14].schema(), other.dt_inserimento);
        fieldSetFlags()[14] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing JarvisAvro instance
     * @param other The existing instance to copy.
     */
    private Builder(it.luca.streaming.data.model.jarvis.JarvisAvro other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.ambito_flusso)) {
        this.ambito_flusso = data().deepCopy(fields()[0].schema(), other.ambito_flusso);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.nome_flusso)) {
        this.nome_flusso = data().deepCopy(fields()[1].schema(), other.nome_flusso);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.impresa_mittente)) {
        this.impresa_mittente = data().deepCopy(fields()[2].schema(), other.impresa_mittente);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.data_di_creazione)) {
        this.data_di_creazione = data().deepCopy(fields()[3].schema(), other.data_di_creazione);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.numero_dati)) {
        this.numero_dati = data().deepCopy(fields()[4].schema(), other.numero_dati);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.data_procedura)) {
        this.data_procedura = data().deepCopy(fields()[5].schema(), other.data_procedura);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.ciclo_di_riferimento)) {
        this.ciclo_di_riferimento = data().deepCopy(fields()[6].schema(), other.ciclo_di_riferimento);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.rinomina_energia)) {
        this.rinomina_energia = data().deepCopy(fields()[7].schema(), other.rinomina_energia);
        fieldSetFlags()[7] = true;
      }
      if (isValidValue(fields()[8], other.unita_di_misura_energia_rinomina)) {
        this.unita_di_misura_energia_rinomina = data().deepCopy(fields()[8].schema(), other.unita_di_misura_energia_rinomina);
        fieldSetFlags()[8] = true;
      }
      if (isValidValue(fields()[9], other.limite_minimo_energia)) {
        this.limite_minimo_energia = data().deepCopy(fields()[9].schema(), other.limite_minimo_energia);
        fieldSetFlags()[9] = true;
      }
      if (isValidValue(fields()[10], other.unita_di_misura_energia_limite_minimo)) {
        this.unita_di_misura_energia_limite_minimo = data().deepCopy(fields()[10].schema(), other.unita_di_misura_energia_limite_minimo);
        fieldSetFlags()[10] = true;
      }
      if (isValidValue(fields()[11], other.limite_massimo_energia)) {
        this.limite_massimo_energia = data().deepCopy(fields()[11].schema(), other.limite_massimo_energia);
        fieldSetFlags()[11] = true;
      }
      if (isValidValue(fields()[12], other.unita_di_misura_energia_limite_massimo)) {
        this.unita_di_misura_energia_limite_massimo = data().deepCopy(fields()[12].schema(), other.unita_di_misura_energia_limite_massimo);
        fieldSetFlags()[12] = true;
      }
      if (isValidValue(fields()[13], other.ts_inserimento)) {
        this.ts_inserimento = data().deepCopy(fields()[13].schema(), other.ts_inserimento);
        fieldSetFlags()[13] = true;
      }
      if (isValidValue(fields()[14], other.dt_inserimento)) {
        this.dt_inserimento = data().deepCopy(fields()[14].schema(), other.dt_inserimento);
        fieldSetFlags()[14] = true;
      }
    }

    /**
      * Gets the value of the 'ambito_flusso' field.
      * @return The value.
      */
    public java.lang.String getAmbitoFlusso() {
      return ambito_flusso;
    }

    /**
      * Sets the value of the 'ambito_flusso' field.
      * @param value The value of 'ambito_flusso'.
      * @return This builder.
      */
    public it.luca.streaming.data.model.jarvis.JarvisAvro.Builder setAmbitoFlusso(java.lang.String value) {
      validate(fields()[0], value);
      this.ambito_flusso = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'ambito_flusso' field has been set.
      * @return True if the 'ambito_flusso' field has been set, false otherwise.
      */
    public boolean hasAmbitoFlusso() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'ambito_flusso' field.
      * @return This builder.
      */
    public it.luca.streaming.data.model.jarvis.JarvisAvro.Builder clearAmbitoFlusso() {
      ambito_flusso = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'nome_flusso' field.
      * @return The value.
      */
    public java.lang.String getNomeFlusso() {
      return nome_flusso;
    }

    /**
      * Sets the value of the 'nome_flusso' field.
      * @param value The value of 'nome_flusso'.
      * @return This builder.
      */
    public it.luca.streaming.data.model.jarvis.JarvisAvro.Builder setNomeFlusso(java.lang.String value) {
      validate(fields()[1], value);
      this.nome_flusso = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'nome_flusso' field has been set.
      * @return True if the 'nome_flusso' field has been set, false otherwise.
      */
    public boolean hasNomeFlusso() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'nome_flusso' field.
      * @return This builder.
      */
    public it.luca.streaming.data.model.jarvis.JarvisAvro.Builder clearNomeFlusso() {
      nome_flusso = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'impresa_mittente' field.
      * @return The value.
      */
    public java.lang.String getImpresaMittente() {
      return impresa_mittente;
    }

    /**
      * Sets the value of the 'impresa_mittente' field.
      * @param value The value of 'impresa_mittente'.
      * @return This builder.
      */
    public it.luca.streaming.data.model.jarvis.JarvisAvro.Builder setImpresaMittente(java.lang.String value) {
      validate(fields()[2], value);
      this.impresa_mittente = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'impresa_mittente' field has been set.
      * @return True if the 'impresa_mittente' field has been set, false otherwise.
      */
    public boolean hasImpresaMittente() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'impresa_mittente' field.
      * @return This builder.
      */
    public it.luca.streaming.data.model.jarvis.JarvisAvro.Builder clearImpresaMittente() {
      impresa_mittente = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'data_di_creazione' field.
      * @return The value.
      */
    public java.lang.String getDataDiCreazione() {
      return data_di_creazione;
    }

    /**
      * Sets the value of the 'data_di_creazione' field.
      * @param value The value of 'data_di_creazione'.
      * @return This builder.
      */
    public it.luca.streaming.data.model.jarvis.JarvisAvro.Builder setDataDiCreazione(java.lang.String value) {
      validate(fields()[3], value);
      this.data_di_creazione = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'data_di_creazione' field has been set.
      * @return True if the 'data_di_creazione' field has been set, false otherwise.
      */
    public boolean hasDataDiCreazione() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'data_di_creazione' field.
      * @return This builder.
      */
    public it.luca.streaming.data.model.jarvis.JarvisAvro.Builder clearDataDiCreazione() {
      data_di_creazione = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'numero_dati' field.
      * @return The value.
      */
    public java.lang.Integer getNumeroDati() {
      return numero_dati;
    }

    /**
      * Sets the value of the 'numero_dati' field.
      * @param value The value of 'numero_dati'.
      * @return This builder.
      */
    public it.luca.streaming.data.model.jarvis.JarvisAvro.Builder setNumeroDati(java.lang.Integer value) {
      validate(fields()[4], value);
      this.numero_dati = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'numero_dati' field has been set.
      * @return True if the 'numero_dati' field has been set, false otherwise.
      */
    public boolean hasNumeroDati() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'numero_dati' field.
      * @return This builder.
      */
    public it.luca.streaming.data.model.jarvis.JarvisAvro.Builder clearNumeroDati() {
      numero_dati = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'data_procedura' field.
      * @return The value.
      */
    public java.lang.String getDataProcedura() {
      return data_procedura;
    }

    /**
      * Sets the value of the 'data_procedura' field.
      * @param value The value of 'data_procedura'.
      * @return This builder.
      */
    public it.luca.streaming.data.model.jarvis.JarvisAvro.Builder setDataProcedura(java.lang.String value) {
      validate(fields()[5], value);
      this.data_procedura = value;
      fieldSetFlags()[5] = true;
      return this;
    }

    /**
      * Checks whether the 'data_procedura' field has been set.
      * @return True if the 'data_procedura' field has been set, false otherwise.
      */
    public boolean hasDataProcedura() {
      return fieldSetFlags()[5];
    }


    /**
      * Clears the value of the 'data_procedura' field.
      * @return This builder.
      */
    public it.luca.streaming.data.model.jarvis.JarvisAvro.Builder clearDataProcedura() {
      data_procedura = null;
      fieldSetFlags()[5] = false;
      return this;
    }

    /**
      * Gets the value of the 'ciclo_di_riferimento' field.
      * @return The value.
      */
    public java.lang.String getCicloDiRiferimento() {
      return ciclo_di_riferimento;
    }

    /**
      * Sets the value of the 'ciclo_di_riferimento' field.
      * @param value The value of 'ciclo_di_riferimento'.
      * @return This builder.
      */
    public it.luca.streaming.data.model.jarvis.JarvisAvro.Builder setCicloDiRiferimento(java.lang.String value) {
      validate(fields()[6], value);
      this.ciclo_di_riferimento = value;
      fieldSetFlags()[6] = true;
      return this;
    }

    /**
      * Checks whether the 'ciclo_di_riferimento' field has been set.
      * @return True if the 'ciclo_di_riferimento' field has been set, false otherwise.
      */
    public boolean hasCicloDiRiferimento() {
      return fieldSetFlags()[6];
    }


    /**
      * Clears the value of the 'ciclo_di_riferimento' field.
      * @return This builder.
      */
    public it.luca.streaming.data.model.jarvis.JarvisAvro.Builder clearCicloDiRiferimento() {
      ciclo_di_riferimento = null;
      fieldSetFlags()[6] = false;
      return this;
    }

    /**
      * Gets the value of the 'rinomina_energia' field.
      * @return The value.
      */
    public java.lang.Double getRinominaEnergia() {
      return rinomina_energia;
    }

    /**
      * Sets the value of the 'rinomina_energia' field.
      * @param value The value of 'rinomina_energia'.
      * @return This builder.
      */
    public it.luca.streaming.data.model.jarvis.JarvisAvro.Builder setRinominaEnergia(java.lang.Double value) {
      validate(fields()[7], value);
      this.rinomina_energia = value;
      fieldSetFlags()[7] = true;
      return this;
    }

    /**
      * Checks whether the 'rinomina_energia' field has been set.
      * @return True if the 'rinomina_energia' field has been set, false otherwise.
      */
    public boolean hasRinominaEnergia() {
      return fieldSetFlags()[7];
    }


    /**
      * Clears the value of the 'rinomina_energia' field.
      * @return This builder.
      */
    public it.luca.streaming.data.model.jarvis.JarvisAvro.Builder clearRinominaEnergia() {
      rinomina_energia = null;
      fieldSetFlags()[7] = false;
      return this;
    }

    /**
      * Gets the value of the 'unita_di_misura_energia_rinomina' field.
      * @return The value.
      */
    public java.lang.String getUnitaDiMisuraEnergiaRinomina() {
      return unita_di_misura_energia_rinomina;
    }

    /**
      * Sets the value of the 'unita_di_misura_energia_rinomina' field.
      * @param value The value of 'unita_di_misura_energia_rinomina'.
      * @return This builder.
      */
    public it.luca.streaming.data.model.jarvis.JarvisAvro.Builder setUnitaDiMisuraEnergiaRinomina(java.lang.String value) {
      validate(fields()[8], value);
      this.unita_di_misura_energia_rinomina = value;
      fieldSetFlags()[8] = true;
      return this;
    }

    /**
      * Checks whether the 'unita_di_misura_energia_rinomina' field has been set.
      * @return True if the 'unita_di_misura_energia_rinomina' field has been set, false otherwise.
      */
    public boolean hasUnitaDiMisuraEnergiaRinomina() {
      return fieldSetFlags()[8];
    }


    /**
      * Clears the value of the 'unita_di_misura_energia_rinomina' field.
      * @return This builder.
      */
    public it.luca.streaming.data.model.jarvis.JarvisAvro.Builder clearUnitaDiMisuraEnergiaRinomina() {
      unita_di_misura_energia_rinomina = null;
      fieldSetFlags()[8] = false;
      return this;
    }

    /**
      * Gets the value of the 'limite_minimo_energia' field.
      * @return The value.
      */
    public java.lang.Double getLimiteMinimoEnergia() {
      return limite_minimo_energia;
    }

    /**
      * Sets the value of the 'limite_minimo_energia' field.
      * @param value The value of 'limite_minimo_energia'.
      * @return This builder.
      */
    public it.luca.streaming.data.model.jarvis.JarvisAvro.Builder setLimiteMinimoEnergia(java.lang.Double value) {
      validate(fields()[9], value);
      this.limite_minimo_energia = value;
      fieldSetFlags()[9] = true;
      return this;
    }

    /**
      * Checks whether the 'limite_minimo_energia' field has been set.
      * @return True if the 'limite_minimo_energia' field has been set, false otherwise.
      */
    public boolean hasLimiteMinimoEnergia() {
      return fieldSetFlags()[9];
    }


    /**
      * Clears the value of the 'limite_minimo_energia' field.
      * @return This builder.
      */
    public it.luca.streaming.data.model.jarvis.JarvisAvro.Builder clearLimiteMinimoEnergia() {
      limite_minimo_energia = null;
      fieldSetFlags()[9] = false;
      return this;
    }

    /**
      * Gets the value of the 'unita_di_misura_energia_limite_minimo' field.
      * @return The value.
      */
    public java.lang.String getUnitaDiMisuraEnergiaLimiteMinimo() {
      return unita_di_misura_energia_limite_minimo;
    }

    /**
      * Sets the value of the 'unita_di_misura_energia_limite_minimo' field.
      * @param value The value of 'unita_di_misura_energia_limite_minimo'.
      * @return This builder.
      */
    public it.luca.streaming.data.model.jarvis.JarvisAvro.Builder setUnitaDiMisuraEnergiaLimiteMinimo(java.lang.String value) {
      validate(fields()[10], value);
      this.unita_di_misura_energia_limite_minimo = value;
      fieldSetFlags()[10] = true;
      return this;
    }

    /**
      * Checks whether the 'unita_di_misura_energia_limite_minimo' field has been set.
      * @return True if the 'unita_di_misura_energia_limite_minimo' field has been set, false otherwise.
      */
    public boolean hasUnitaDiMisuraEnergiaLimiteMinimo() {
      return fieldSetFlags()[10];
    }


    /**
      * Clears the value of the 'unita_di_misura_energia_limite_minimo' field.
      * @return This builder.
      */
    public it.luca.streaming.data.model.jarvis.JarvisAvro.Builder clearUnitaDiMisuraEnergiaLimiteMinimo() {
      unita_di_misura_energia_limite_minimo = null;
      fieldSetFlags()[10] = false;
      return this;
    }

    /**
      * Gets the value of the 'limite_massimo_energia' field.
      * @return The value.
      */
    public java.lang.Double getLimiteMassimoEnergia() {
      return limite_massimo_energia;
    }

    /**
      * Sets the value of the 'limite_massimo_energia' field.
      * @param value The value of 'limite_massimo_energia'.
      * @return This builder.
      */
    public it.luca.streaming.data.model.jarvis.JarvisAvro.Builder setLimiteMassimoEnergia(java.lang.Double value) {
      validate(fields()[11], value);
      this.limite_massimo_energia = value;
      fieldSetFlags()[11] = true;
      return this;
    }

    /**
      * Checks whether the 'limite_massimo_energia' field has been set.
      * @return True if the 'limite_massimo_energia' field has been set, false otherwise.
      */
    public boolean hasLimiteMassimoEnergia() {
      return fieldSetFlags()[11];
    }


    /**
      * Clears the value of the 'limite_massimo_energia' field.
      * @return This builder.
      */
    public it.luca.streaming.data.model.jarvis.JarvisAvro.Builder clearLimiteMassimoEnergia() {
      limite_massimo_energia = null;
      fieldSetFlags()[11] = false;
      return this;
    }

    /**
      * Gets the value of the 'unita_di_misura_energia_limite_massimo' field.
      * @return The value.
      */
    public java.lang.String getUnitaDiMisuraEnergiaLimiteMassimo() {
      return unita_di_misura_energia_limite_massimo;
    }

    /**
      * Sets the value of the 'unita_di_misura_energia_limite_massimo' field.
      * @param value The value of 'unita_di_misura_energia_limite_massimo'.
      * @return This builder.
      */
    public it.luca.streaming.data.model.jarvis.JarvisAvro.Builder setUnitaDiMisuraEnergiaLimiteMassimo(java.lang.String value) {
      validate(fields()[12], value);
      this.unita_di_misura_energia_limite_massimo = value;
      fieldSetFlags()[12] = true;
      return this;
    }

    /**
      * Checks whether the 'unita_di_misura_energia_limite_massimo' field has been set.
      * @return True if the 'unita_di_misura_energia_limite_massimo' field has been set, false otherwise.
      */
    public boolean hasUnitaDiMisuraEnergiaLimiteMassimo() {
      return fieldSetFlags()[12];
    }


    /**
      * Clears the value of the 'unita_di_misura_energia_limite_massimo' field.
      * @return This builder.
      */
    public it.luca.streaming.data.model.jarvis.JarvisAvro.Builder clearUnitaDiMisuraEnergiaLimiteMassimo() {
      unita_di_misura_energia_limite_massimo = null;
      fieldSetFlags()[12] = false;
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
    public it.luca.streaming.data.model.jarvis.JarvisAvro.Builder setTsInserimento(java.lang.String value) {
      validate(fields()[13], value);
      this.ts_inserimento = value;
      fieldSetFlags()[13] = true;
      return this;
    }

    /**
      * Checks whether the 'ts_inserimento' field has been set.
      * @return True if the 'ts_inserimento' field has been set, false otherwise.
      */
    public boolean hasTsInserimento() {
      return fieldSetFlags()[13];
    }


    /**
      * Clears the value of the 'ts_inserimento' field.
      * @return This builder.
      */
    public it.luca.streaming.data.model.jarvis.JarvisAvro.Builder clearTsInserimento() {
      ts_inserimento = null;
      fieldSetFlags()[13] = false;
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
    public it.luca.streaming.data.model.jarvis.JarvisAvro.Builder setDtInserimento(java.lang.String value) {
      validate(fields()[14], value);
      this.dt_inserimento = value;
      fieldSetFlags()[14] = true;
      return this;
    }

    /**
      * Checks whether the 'dt_inserimento' field has been set.
      * @return True if the 'dt_inserimento' field has been set, false otherwise.
      */
    public boolean hasDtInserimento() {
      return fieldSetFlags()[14];
    }


    /**
      * Clears the value of the 'dt_inserimento' field.
      * @return This builder.
      */
    public it.luca.streaming.data.model.jarvis.JarvisAvro.Builder clearDtInserimento() {
      dt_inserimento = null;
      fieldSetFlags()[14] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public JarvisAvro build() {
      try {
        JarvisAvro record = new JarvisAvro();
        record.ambito_flusso = fieldSetFlags()[0] ? this.ambito_flusso : (java.lang.String) defaultValue(fields()[0]);
        record.nome_flusso = fieldSetFlags()[1] ? this.nome_flusso : (java.lang.String) defaultValue(fields()[1]);
        record.impresa_mittente = fieldSetFlags()[2] ? this.impresa_mittente : (java.lang.String) defaultValue(fields()[2]);
        record.data_di_creazione = fieldSetFlags()[3] ? this.data_di_creazione : (java.lang.String) defaultValue(fields()[3]);
        record.numero_dati = fieldSetFlags()[4] ? this.numero_dati : (java.lang.Integer) defaultValue(fields()[4]);
        record.data_procedura = fieldSetFlags()[5] ? this.data_procedura : (java.lang.String) defaultValue(fields()[5]);
        record.ciclo_di_riferimento = fieldSetFlags()[6] ? this.ciclo_di_riferimento : (java.lang.String) defaultValue(fields()[6]);
        record.rinomina_energia = fieldSetFlags()[7] ? this.rinomina_energia : (java.lang.Double) defaultValue(fields()[7]);
        record.unita_di_misura_energia_rinomina = fieldSetFlags()[8] ? this.unita_di_misura_energia_rinomina : (java.lang.String) defaultValue(fields()[8]);
        record.limite_minimo_energia = fieldSetFlags()[9] ? this.limite_minimo_energia : (java.lang.Double) defaultValue(fields()[9]);
        record.unita_di_misura_energia_limite_minimo = fieldSetFlags()[10] ? this.unita_di_misura_energia_limite_minimo : (java.lang.String) defaultValue(fields()[10]);
        record.limite_massimo_energia = fieldSetFlags()[11] ? this.limite_massimo_energia : (java.lang.Double) defaultValue(fields()[11]);
        record.unita_di_misura_energia_limite_massimo = fieldSetFlags()[12] ? this.unita_di_misura_energia_limite_massimo : (java.lang.String) defaultValue(fields()[12]);
        record.ts_inserimento = fieldSetFlags()[13] ? this.ts_inserimento : (java.lang.String) defaultValue(fields()[13]);
        record.dt_inserimento = fieldSetFlags()[14] ? this.dt_inserimento : (java.lang.String) defaultValue(fields()[14]);
        return record;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<JarvisAvro>
    WRITER$ = (org.apache.avro.io.DatumWriter<JarvisAvro>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<JarvisAvro>
    READER$ = (org.apache.avro.io.DatumReader<JarvisAvro>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}
