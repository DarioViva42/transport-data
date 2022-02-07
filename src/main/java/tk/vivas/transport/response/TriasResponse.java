package tk.vivas.transport.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TriasResponse {
    @JsonProperty(namespace = "trias", value = "ServiceDelivery")
    private ServiceDelivery serviceDelivery;

    private String version;

    public ServiceDelivery getServiceDelivery() {
        return serviceDelivery;
    }

    public void setServiceDelivery(ServiceDelivery serviceDelivery) {
        this.serviceDelivery = serviceDelivery;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
