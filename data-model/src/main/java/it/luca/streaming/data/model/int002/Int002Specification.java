package it.luca.streaming.data.model.int002;

import it.luca.streaming.data.enumeration.DataSourceId;
import it.luca.streaming.data.enumeration.DataSourceType;
import it.luca.streaming.data.model.common.SourceSpecification;
import it.luca.streaming.data.utils.DatePattern;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static it.luca.streaming.data.utils.Utils.*;

public class Int002Specification extends SourceSpecification<Int002Wrapper, Int002Avro, String> {

    private final Function<Int002Ciclo, String> gasDay = x ->
            gasDay(x.getGiornoOraRiferimento(), DatePattern.INT002_GIORNO_ORA_RIFERIMENTO);

    public Int002Specification() {
        super(DataSourceId.INT002, DataSourceType.JSON, "giorno_gas", Int002Wrapper.class, Int002Avro.class);
    }

    @Override
    protected List<Int002Avro> getAvroRecordsForPartition(Int002Wrapper input, String partitionValue) {

        return filter(input.getCicli(), x -> gasDay.apply(x).equals(partitionValue))
                .stream().map(x -> Int002Avro.newBuilder()
                        .setGiornoOraRiferimento(x.getGiornoOraRiferimento())
                        .setUDM1(x.getUDM1())
                        .setUDM2(x.getUDM2())
                        .setUDM3(x.getUDM3())
                        .setUDM4(x.getUDM4())
                        .setDescrizione(x.getDescrizione())
                        .setTipologia(x.getTipologia())
                        .setCodiceRemi(x.getCodiceRemi())
                        .setValore1(x.getValore1())
                        .setProgressivo1(x.getProgressivo1())
                        .setValore2(x.getValore2())
                        .setProgressivo2(x.getProgressivo2())
                        .setPCS(x.getPCS())
                        .setValore3(x.getValore3())
                        .setProgressivo3(x.getProgressivo3())
                        .setValore4(x.getValore4())
                        .setProgressivo4(x.getProgressivo4())
                        .setPCS250(x.getPCS250())
                        .setWobbe2515(x.getWobbe2515())
                        .setWobbe250(x.getWobbe250())
                        .setTsInserimento(now(DatePattern.DEFAULT_TIMESTAMP))
                        .setDtInserimento(now(DatePattern.DEFAULT_DATE))
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    protected List<String> getPartitionValues(Int002Wrapper input) {

        return map(input.getCicli(), gasDay);
    }
}
