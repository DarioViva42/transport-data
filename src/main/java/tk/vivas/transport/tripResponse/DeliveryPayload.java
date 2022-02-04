package tk.vivas.transport.tripResponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.UpperCamelCaseStrategy.class)
public class DeliveryPayload {
    @JsonProperty(namespace = "trias")
    private TripResponse tripResponse;

    public TripResponse getTripResponse() {
        return tripResponse;
    }

    public void setTripResponse(TripResponse tripResponse) {
        this.tripResponse = tripResponse;
    }
}
