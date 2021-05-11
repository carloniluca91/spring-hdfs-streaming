package it.luca.streaming.data.model.webdisp;

import it.luca.streaming.data.enumeration.DataSourceId;
import it.luca.streaming.data.model.common.SourceSpecificationTest;
import it.luca.streaming.data.utils.DatePattern;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static it.luca.streaming.data.utils.Utils.*;
import static org.junit.jupiter.api.Assertions.*;

class WebdispSpecificationTest extends SourceSpecificationTest<WebdispWrapper, WebdispAvro, String> {

    private final Function<WebdispNomina, String> gasDay = x -> gasDay(x.getDataDecorrenza(), DatePattern.WEBDISP_DATA_DECORRENZA);

    public WebdispSpecificationTest() throws IOException {
        super("webdisp.xml", WebdispWrapper.class, DataSourceId.WEBDISP, new WebdispSpecification());
    }

    @Test
    @Override
    public void assertReadValue() {

        assertNotNull(instance);
        assertNotNull(instance.getDataOraInvio());
        assertNotNull(instance.getNomine());
        assertFalse(instance.getNomine().isEmpty());
    }

    @Test
    @Override
    public void getDistinctPartitionValues() {

        List<String> partitionValues = specification.getDistinctPartitionValues(instance);
        assertFalse(partitionValues.isEmpty());
        assertEquals(map(instance.getNomine(), gasDay)
                .stream().distinct().count(), partitionValues.size());
    }

    @Test
    @Override
    public void getPartitionRecordsMap() {

        Map<String, List<WebdispAvro>> map = specification.getPartitionRecordsMap(instance);
        assertFalse(map.isEmpty());
        List<String> stringList = map(instance.getNomine(), gasDay)
                .stream().distinct().collect(Collectors.toList());

        stringList.forEach(x -> assertTrue(map.containsKey(x)));
        map.forEach(((s, webdispAvros) -> {

            List<WebdispNomina> webdispNominas = filter(instance.getNomine(), x -> gasDay.apply(x).equals(s))
                    .stream()
                    .sorted(Comparator.comparingDouble(WebdispNomina::getPcs))
                    .collect(Collectors.toList());

            List<WebdispAvro> sortedAvros = webdispAvros.stream()
                    .sorted(Comparator.comparingDouble(WebdispAvro::getPcs))
                    .collect(Collectors.toList());

            IntStream.range(0, webdispNominas.size())
                    .forEach(i -> {

                        WebdispNomina webdispNomina = webdispNominas.get(i);
                        WebdispAvro webdispAvro = sortedAvros.get(i);
                        assertEquals(instance.getDataOraInvio(), webdispAvro.getDataOraInvio());
                        assertEquals(webdispNomina.getPcs(), webdispAvro.getPcs());
                        assertEquals(webdispNomina.getValoreEnergia(), webdispAvro.getValoreEnergia());
                        assertEquals(webdispNomina.getUnitaMisuraEnergia(), webdispAvro.getUnitaMisuraEnergia());
                        assertEquals(webdispNomina.getValoreVolume(), webdispAvro.getValoreVolume());
                        assertEquals(webdispNomina.getUnitaMisuraVolume(), webdispAvro.getUnitaMisuraVolume());
                        assertEquals(webdispNomina.getDataElaborazione(), webdispAvro.getDataElaborazione());
                        assertEquals(webdispNomina.getDataDecorrenza(), webdispAvro.getDataDecorrenza());
                        assertEquals(webdispNomina.getCodiceRemi(), webdispAvro.getCodiceRemi());
                        assertEquals(webdispNomina.getDescrizioneRemi(), webdispAvro.getDescrizioneRemi());
                        assertEquals(webdispNomina.getDescrizionePunto(), webdispAvro.getDescrizionePunto());
                        assertEquals(webdispNomina.getTipoNomina(), webdispAvro.getTipoNomina());
                        assertEquals(webdispNomina.getCicloNomina(), webdispAvro.getCicloNomina());
                        assertEquals(webdispNomina.getTipologiaPunto(), webdispAvro.getTipologiaPunto());
                    });
        }));
    }
}