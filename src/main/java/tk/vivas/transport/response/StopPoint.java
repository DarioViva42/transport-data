package tk.vivas.transport.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.UpperCamelCaseStrategy.class)
public class StopPoint {
    @JsonProperty(namespace = "trias")
    private String stopPointRef;

    @JsonProperty(namespace = "trias")
    private Name stopPointName;

    @JsonProperty(namespace = "trias")
    private String localityRef;

    public String getStopPointRef() {
        return stopPointRef;
    }

    public void setStopPointRef(String stopPointRef) {
        this.stopPointRef = stopPointRef;
    }

    public Name getLocationName() {
        return stopPointName;
    }

    public void setLocationName(Name locationName) {
        this.stopPointName = locationName;
    }

    public String getLocalityRef() {
        return localityRef;
    }

    public void setLocalityRef(String localityRef) {
        this.localityRef = localityRef;
    }
}
