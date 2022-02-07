package tk.vivas.transport.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import tk.vivas.transport.response.Name;

@JsonNaming(PropertyNamingStrategies.UpperCamelCaseStrategy.class)
public class Message {
    @JsonProperty(namespace = "trias")
    private Name text;

    @JsonProperty(namespace = "trias")
    private String code;

    public Name getText() {
        return text;
    }

    public void setText(Name text) {
        this.text = text;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
