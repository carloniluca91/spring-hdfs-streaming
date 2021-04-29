package it.luca.streaming.data.model.webdisp;

import it.luca.streaming.data.enumeration.DataSourceId;
import it.luca.streaming.data.model.common.SourceSpecification;
import it.luca.streaming.data.utils.DatePattern;

import java.util.List;
import java.util.stream.Collectors;

import static it.luca.streaming.data.utils.Utils.gasDay;
import static it.luca.streaming.data.utils.Utils.now;

public class WebdispSpecification extends SourceSpecification<WebdispWrapper, WebdispAvro, String> {

    public WebdispSpecification() {
        super(DataSourceId.WEBDISP, "giorno_gas", WebdispWrapper.class, WebdispAvro.class);
    }

    @Override
    public List<WebdispAvro> getAvroRecordsForPartition(WebdispWrapper input, String partitionValue) {

        return input.getNomine().stream()
                .filter(x -> gasDay(x.getDataDecorrenza(), DatePattern.WEBDISP_DATA_DECORRENZA).equals(partitionValue))
                .map(x -> WebdispAvro.newBuilder()
                        .setDataOraInvio(input.getDataOraInvio())
                        .setPcs(x.getPcs())
                        .setValoreEnergia(x.getValoreEnergia())
                        .setUnitaMisuraEnergia(x.getUnitaMisuraEnergia())
                        .setValoreVolume(x.getValoreVolume())
                        .setUnitaMisuraVolume(x.getUnitaMisuraVolume())
                        .setDataElaborazione(x.getDataElaborazione())
                        .setDataDecorrenza(x.getDataDecorrenza())
                        .setCodiceRemi(x.getCodiceRemi())
                        .setDescrizioneRemi(x.getDescrizioneRemi())
                        .setDescrizionePunto(x.getDescrizionePunto())
                        .setTipoNomina(x.getTipoNomina())
                        .setCicloNomina(x.getCicloNomina())
                        .setTipologiaPunto(x.getTipologiaPunto())
                        .setTsInserimento(now(DatePattern.DEFAULT_TIMESTAMP))
                        .setDtInserimento(now(DatePattern.DEFAULT_DATE))
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getPartitionValues(WebdispWrapper input) {

        return input.getNomine().stream()
                .map(x -> gasDay(x.getDataDecorrenza(), DatePattern.WEBDISP_DATA_DECORRENZA))
                .distinct().collect(Collectors.toList());
    }
}
