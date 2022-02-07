package tk.vivas.transport.response.trip;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LegAlight extends Leg{
    @JsonProperty(namespace = "trias")
    private ServiceDepartureArrival serviceArrival;

    public ServiceDepartureArrival getServiceArrival() {
        return serviceArrival;
    }

    public void setServiceArrival(ServiceDepartureArrival serviceArrival) {
        this.serviceArrival = serviceArrival;
    }
}
