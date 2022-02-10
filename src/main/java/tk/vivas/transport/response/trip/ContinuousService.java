package tk.vivas.transport.response.trip;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.UpperCamelCaseStrategy.class)
public class ContinuousService {
    @JsonProperty(namespace = "trias")
    private String individualMode;

    public String getIndividualMode() {
        return individualMode;
    }

    public void setIndividualMode(String individualMode) {
        this.individualMode = individualMode;
    }
}
