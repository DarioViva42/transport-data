package tk.vivas.transport.tripResponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.UpperCamelCaseStrategy.class)
public class TimedLeg extends AbstractLeg {
    @JsonProperty(namespace = "trias")
    private LegBoard legBoard;

    @JsonProperty(namespace = "trias")
    private LegAlight legAlight;

    @JsonProperty(namespace = "trias")
    private Service service;

    public LegBoard getLegBoard() {
        return legBoard;
    }

    public void setLegBoard(LegBoard legBoard) {
        this.legBoard = legBoard;
    }

    public LegAlight getLegAlight() {
        return legAlight;
    }

    public void setLegAlight(LegAlight legAlight) {
        this.legAlight = legAlight;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
}
