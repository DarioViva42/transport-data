package tk.vivas.transport.response.trip;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import tk.vivas.transport.RealLocalDateTimeDeserializer;

import java.time.LocalDateTime;

@JsonNaming(PropertyNamingStrategies.UpperCamelCaseStrategy.class)
public class ServiceDepartureArrival {
    @JsonDeserialize(using = RealLocalDateTimeDeserializer.class)
    @JsonProperty(namespace = "trias")
    private LocalDateTime timetabledTime;

    @JsonDeserialize(using = RealLocalDateTimeDeserializer.class)
    @JsonProperty(namespace = "trias")
    private LocalDateTime estimatedTime;

    public LocalDateTime getTimetabledTime() {
        return timetabledTime;
    }

    public void setTimetabledTime(LocalDateTime timetabledTime) {
        this.timetabledTime = timetabledTime;
    }

    public LocalDateTime getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(LocalDateTime estimatedTime) {
        this.estimatedTime = estimatedTime;
    }
}
