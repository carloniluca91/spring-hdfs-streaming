package it.luca.streaming.data.model.jarvis;

import it.luca.streaming.data.enumeration.DataSourceId;
import it.luca.streaming.data.model.common.SourceSpecification;
import it.luca.streaming.data.utils.DatePattern;
import it.luca.streaming.data.utils.Utils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class JarvisSpecification extends SourceSpecification<JarvisWrapper, JarvisAvro, String> {

    public JarvisSpecification() {
        super(DataSourceId.JARVIS, "giorno_gas", JarvisWrapper.class, JarvisAvro.class);
    }

    @Override
    protected List<JarvisAvro> getAvroRecordsForPartition(JarvisWrapper input, String partitionValue) {

        return input.getListaCicli().stream()
                .map(x -> JarvisAvro.newBuilder()
                        .setAmbitoFlusso(input.getAmbitoFlusso())
                        .setNomeFlusso(input.getNomeFlusso())
                        .setImpresaMittente(input.getImpresaMittente())
                        .setDataDiCreazione(input.getDataDiCreazione())
                        .setNumeroDati(input.getNumeroDati())
                        .setDataProcedura(input.getDataProcedura())
                        .setCicloDiRiferimento(x.getCicloDiRiferimento())
                        .setRinominaEnergia(x.getRinominaEnergia())
                        .setUnitaDiMisuraEnergiaRinomina(x.getUnitaDiMisuraEnergiaRinomina())
                        .setLimiteMinimoEnergia(x.getLimiteMinimoEnergia())
                        .setUnitaDiMisuraEnergiaLimiteMinimo(x.getUnitaDiMisuraEnergiaLimiteMinimo())
                        .setLimiteMassimoEnergia(x.getLimiteMassimoEnergia())
                        .setUnitaDiMisuraEnergiaLimiteMassimo(x.getUnitaDiMisuraEnergiaLimiteMassimo())
                        .setTsInserimento(Utils.now(DatePattern.DEFAULT_TIMESTAMP))
                        .setDtInserimento(Utils.now(DatePattern.DEFAULT_DATE))
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    protected List<String> getPartitionValues(JarvisWrapper input) {

        String giornoGas = Utils.changeDatePattern(input.getGiornoGas(), DatePattern.JARVIS_GIORNO_GAS, DatePattern.DEFAULT_DATE);
        return Collections.singletonList(giornoGas);
    }
}
