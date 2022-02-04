package tk.vivas.transport.tripResponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

import java.time.LocalDateTime;

@JsonNaming( PropertyNamingStrategies.UpperCamelCaseStrategy.class)
public class ServiceDelivery {

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonProperty(namespace = "siri")
    private LocalDateTime responseTimestamp;

    @JsonProperty(namespace = "siri")
    private String producerRef;

    @JsonProperty(namespace = "siri")
    private boolean status;

    @JsonProperty(namespace = "trias")
    private String language;

    @JsonProperty(namespace = "trias")
    private int calcTime;

    @JsonProperty(namespace = "trias")
    private DeliveryPayload deliveryPayload;

    public LocalDateTime getResponseTimestamp() {
        return responseTimestamp;
    }

    public void setResponseTimestamp(LocalDateTime responseTimestamp) {
        this.responseTimestamp = responseTimestamp;
    }

    public String getProducerRef() {
        return producerRef;
    }

    public void setProducerRef(String producerRef) {
        this.producerRef = producerRef;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getCalcTime() {
        return calcTime;
    }

    public void setCalcTime(int calcTime) {
        this.calcTime = calcTime;
    }

    public DeliveryPayload getDeliveryPayload() {
        return deliveryPayload;
    }

    public void setDeliveryPayload(DeliveryPayload deliveryPayload) {
        this.deliveryPayload = deliveryPayload;
    }
}
