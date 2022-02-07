package tk.vivas.transport.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import tk.vivas.transport.response.Name;

@JsonNaming(PropertyNamingStrategies.UpperCamelCaseStrategy.class)
public class Location {
    @JsonProperty(namespace = "trias")
    private String stopPointRef;

    @JsonProperty(namespace = "trias")
    private Name locationName;

    @JsonProperty(namespace = "trias")
    private String localityRef;

    public String getStopPointRef() {
        return stopPointRef;
    }

    public void setStopPointRef(String stopPointRef) {
        this.stopPointRef = stopPointRef;
    }

    public Name getLocationName() {
        return locationName;
    }

    public void setLocationName(Name locationName) {
        this.locationName = locationName;
    }

    public String getLocalityRef() {
        return localityRef;
    }

    public void setLocalityRef(String localityRef) {
        this.localityRef = localityRef;
    }
}
