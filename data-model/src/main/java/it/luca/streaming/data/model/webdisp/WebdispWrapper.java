package it.luca.streaming.data.model.webdisp;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Getter;

import java.util.List;

@Getter
public class WebdispWrapper {

    private final String dataOraInvio;
    private final List<Nomina> nomine;

    @JsonCreator
    public WebdispWrapper(@JacksonXmlProperty(localName = "dataOraInvio") String dataOraInvio,
                          @JacksonXmlProperty(localName = "nomine") List<Nomina> nomine) {

        this.dataOraInvio = dataOraInvio;
        this.nomine = nomine;
    }
}
