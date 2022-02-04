package tk.vivas.transport.tripResponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.UpperCamelCaseStrategy.class)
public class LegStartEnd {
    @JsonProperty(namespace = "trias")
    private String stopPointRef;

    @JsonProperty(namespace = "trias")
    private Name locationName;

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
}
