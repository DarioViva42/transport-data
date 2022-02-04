package tk.vivas.transport.tripResponse;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LegBoard extends Leg {
    @JsonProperty(namespace = "trias")
    private ServiceDepartureArrival serviceDeparture;

    public ServiceDepartureArrival getServiceDeparture() {
        return serviceDeparture;
    }

    public void setServiceDeparture(ServiceDepartureArrival serviceDeparture) {
        this.serviceDeparture = serviceDeparture;
    }
}
