package tk.vivas.transport.tripResponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@JsonNaming(PropertyNamingStrategies.UpperCamelCaseStrategy.class)
public class Mode {
    @JsonProperty(namespace = "trias")
    private String ptMode;

    private String submode;

    @JsonProperty(namespace = "trias")
    private Name name;

    public String getPtMode() {
        return ptMode;
    }

    public void setPtMode(String ptMode) {
        this.ptMode = ptMode;
    }

    public String getSubmode() {
        return submode;
    }

    @JsonProperty(namespace = "trias")
    @JacksonXmlProperty(localName = "TramSubmode")
    public void setTramSubmode(String tramSubmode) {
        this.submode = tramSubmode;
    }

    @JsonProperty(namespace = "trias")
    @JacksonXmlProperty(localName = "RailSubmode")
    public void setRailSubmode(String railSubmode) {
        this.submode = railSubmode;
    }

    @JsonProperty(namespace = "trias")
    @JacksonXmlProperty(localName = "BusSubmode")
    public void setBusSubmode(String busSubmode) {
        this.submode = busSubmode;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }
}
