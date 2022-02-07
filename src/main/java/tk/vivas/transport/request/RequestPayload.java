package tk.vivas.transport.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import tk.vivas.transport.request.locationInformation.LocationInformationRequest;
import tk.vivas.transport.request.trip.TripRequest;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.UpperCamelCaseStrategy.class)
public class RequestPayload {
    private TripRequest tripRequest;

    private LocationInformationRequest locationInformationRequest;

    public RequestPayload(TripRequest tripRequest) {
        this.tripRequest = tripRequest;
    }

    public RequestPayload(LocationInformationRequest locationInformationRequest) {
        this.locationInformationRequest = locationInformationRequest;
    }

    public TripRequest getTripRequest() {
        return tripRequest;
    }

    public void setTripRequest(TripRequest tripRequest) {
        this.tripRequest = tripRequest;
    }

    public LocationInformationRequest getLocationInformationRequest() {
        return locationInformationRequest;
    }

    public void setLocationInformationRequest(LocationInformationRequest locationInformationRequest) {
        this.locationInformationRequest = locationInformationRequest;
    }
}
