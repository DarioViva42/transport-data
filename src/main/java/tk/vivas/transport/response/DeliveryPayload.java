package tk.vivas.transport.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import tk.vivas.transport.response.locationInformation.LocationInformationResponse;
import tk.vivas.transport.response.trip.TripResponse;

@JsonNaming(PropertyNamingStrategies.UpperCamelCaseStrategy.class)
public class DeliveryPayload {
    @JsonProperty(namespace = "trias")
    private TripResponse tripResponse;

    @JsonProperty(namespace = "trias")
    private LocationInformationResponse locationInformationResponse;

    public TripResponse getTripResponse() {
        return tripResponse;
    }

    public void setTripResponse(TripResponse tripResponse) {
        this.tripResponse = tripResponse;
    }

    public LocationInformationResponse getLocationInformationResponse() {
        return locationInformationResponse;
    }

    public void setLocationInformationResponse(LocationInformationResponse locationInformationResponse) {
        this.locationInformationResponse = locationInformationResponse;
    }
}
