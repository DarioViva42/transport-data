package tk.vivas.transport.response.trip;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@JsonNaming(PropertyNamingStrategies.UpperCamelCaseStrategy.class)
public class TripLeg {
    @JsonProperty(namespace = "trias")
    private int legId;

    private LegMarker leg;

    public int getLegId() {
        return legId;
    }

    public void setLegId(int legId) {
        this.legId = legId;
    }

    @JsonProperty(namespace = "trias")
    @JacksonXmlProperty(localName = "InterchangeLeg")
    public void setInterchangeLeg(InterchangeLeg interchangeLeg) {
        this.leg = interchangeLeg;
    }

    @JsonProperty(namespace = "trias")
    @JacksonXmlProperty(localName = "TimedLeg")
    public void setTimedLeg(TimedLeg timedLeg) {
        this.leg = timedLeg;
    }

    @JsonProperty(namespace = "trias")
    @JacksonXmlProperty(localName = "ContinuousLeg")
    public void setTimedLeg(ContinuousLeg continuousLeg) {
        this.leg = continuousLeg;
    }

    public LegMarker getLeg() {
        return leg;
    }
}
