package tk.vivas.transport.response.trip;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import tk.vivas.transport.response.Message;

import java.util.List;

@JsonNaming(PropertyNamingStrategies.UpperCamelCaseStrategy.class)
public class TripResponse {
    @JsonProperty(namespace = "trias")
    private Message errorMessage;

    @JsonProperty(namespace = "trias")
    private TripResponseContext tripResponseContext;

    @JacksonXmlElementWrapper(useWrapping = false)
    @JsonProperty(namespace = "trias")
    private List<TripResult> tripResult;

    public Message getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(Message errorMessage) {
        this.errorMessage = errorMessage;
    }

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
