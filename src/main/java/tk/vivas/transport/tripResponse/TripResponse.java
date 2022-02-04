package tk.vivas.transport.tripResponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import java.util.List;

@JsonNaming(PropertyNamingStrategies.UpperCamelCaseStrategy.class)
public class TripResponse {
    @JsonProperty(namespace = "trias")
    private TripResponseContext tripResponseContext;

    @JacksonXmlElementWrapper(useWrapping = false)
    @JsonProperty(namespace = "trias")
    private List<TripResult> tripResult;

    public TripResponseContext getTripResponseContext() {
        return tripResponseContext;
    }

    public void setTripResponseContext(TripResponseContext tripResponseContext) {
        this.tripResponseContext = tripResponseContext;
    }

    public List<TripResult> getTripResult() {
        return tripResult;
    }

    public void setTripResult(List<TripResult> tripResult) {
        this.tripResult = tripResult;
    }
}
