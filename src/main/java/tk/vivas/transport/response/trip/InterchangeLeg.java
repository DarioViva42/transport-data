package tk.vivas.transport.response.trip;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import tk.vivas.transport.response.Location;

import java.time.Duration;
import java.time.LocalDateTime;

@JsonNaming(PropertyNamingStrategies.UpperCamelCaseStrategy.class)
public class InterchangeLeg implements LegMarker {
    @JsonProperty(namespace = "trias")
    private String interchangeMode;

    @JsonProperty(namespace = "trias")
    private Location legStart;

    @JsonProperty(namespace = "trias")
    private Location legEnd;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonProperty(namespace = "trias")
    private LocalDateTime timeWindowStart;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonProperty(namespace = "trias")
    private LocalDateTime timeWindowEnd;

    @JsonProperty(namespace = "trias")
    private Duration duration;

    public String getInterchangeMode() {
        return interchangeMode;
    }

    public void setInterchangeMode(String interchangeMode) {
        this.interchangeMode = interchangeMode;
    }

    public Location getLegStart() {
        return legStart;
    }

    public void setLegStart(Location legStart) {
        this.legStart = legStart;
    }

    public Location getLegEnd() {
        return legEnd;
    }

    public void setLegEnd(Location legEnd) {
        this.legEnd = legEnd;
    }

    public LocalDateTime getTimeWindowStart() {
        return timeWindowStart;
    }

    public void setTimeWindowStart(LocalDateTime timeWindowStart) {
        this.timeWindowStart = timeWindowStart;
    }

    public LocalDateTime getTimeWindowEnd() {
        return timeWindowEnd;
    }

    public void setTimeWindowEnd(LocalDateTime timeWindowEnd) {
        this.timeWindowEnd = timeWindowEnd;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }
}
