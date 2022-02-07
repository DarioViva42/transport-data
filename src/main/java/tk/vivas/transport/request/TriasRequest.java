package tk.vivas.transport.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class TriasRequest {
    @JacksonXmlProperty(isAttribute = true)
    private String version;

    @JacksonXmlProperty(isAttribute = true)
    private String xmlns;

    @JacksonXmlProperty(isAttribute = true, localName = "xmlns:siri")
    private String siri;

    @JacksonXmlProperty(isAttribute = true, localName = "xmlns:xsi")
    private String xsi;

    @JsonProperty("ServiceRequest")
    private ServiceRequest serviceRequest;

    public TriasRequest(ServiceRequest serviceRequest) {
        this.serviceRequest = serviceRequest;

        version = "1.1";
        xmlns = "http://www.vdv.de/trias";
        siri = "http://www.siri.org.uk/siri";
        xsi = "http://www.w3.org/2001/XMLSchema-instance";
    }

    public ServiceRequest getServiceRequest() {
        return serviceRequest;
    }

    public void setServiceRequest(ServiceRequest serviceRequest) {
        this.serviceRequest = serviceRequest;
    }
}
