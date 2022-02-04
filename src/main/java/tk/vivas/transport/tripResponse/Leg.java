package tk.vivas.transport.tripResponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.UpperCamelCaseStrategy.class)
public abstract class Leg {
    @JsonProperty(namespace = "trias")
    private String stopPointRef;

    @JsonProperty(namespace = "trias")
    private Name stopPointName;

    @JsonProperty(namespace = "trias")
    private Name plannedBay;

    @JsonProperty(namespace = "trias")
    private Name estimatedBay;

    @JsonProperty(namespace = "trias")
    private int stopSeqNumber;

    public String getStopPointRef() {
        return stopPointRef;
    }

    public void setStopPointRef(String stopPointRef) {
        this.stopPointRef = stopPointRef;
    }

    public Name getStopPointName() {
        return stopPointName;
    }

    public void setStopPointName(Name stopPointName) {
        this.stopPointName = stopPointName;
    }

    public Name getPlannedBay() {
        return plannedBay;
    }

    public void setPlannedBay(Name plannedBay) {
        this.plannedBay = plannedBay;
    }

    public Name getEstimatedBay() {
        return estimatedBay;
    }

    public void setEstimatedBay(Name estimatedBay) {
        this.estimatedBay = estimatedBay;
    }

    public int getStopSeqNumber() {
        return stopSeqNumber;
    }

    public void setStopSeqNumber(int stopSeqNumber) {
        this.stopSeqNumber = stopSeqNumber;
    }
}
