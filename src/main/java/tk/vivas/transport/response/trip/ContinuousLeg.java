package tk.vivas.transport.response.trip;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import tk.vivas.transport.RealLocalDateTimeDeserializer;
import tk.vivas.transport.response.Location;

import java.time.Duration;
import java.time.LocalDateTime;

@JsonNaming(PropertyNamingStrategies.UpperCamelCaseStrategy.class)
public class ContinuousLeg implements LegMarker {
    @JsonProperty(namespace = "trias")
    private Location legStart;

    @JsonProperty(namespace = "trias")
    private Location legEnd;

    @JsonProperty(namespace = "trias")
    private ContinuousService service;

    @JsonDeserialize(using = RealLocalDateTimeDeserializer.class)
    @JsonProperty(namespace = "trias")
    private LocalDateTime timeWindowStart;

    @JsonDeserialize(using = RealLocalDateTimeDeserializer.class)
    @JsonProperty(namespace = "trias")
    private LocalDateTime timeWindowEnd;

    @JsonProperty(namespace = "trias")
    private Duration duration;

    @JsonProperty(namespace = "trias")
    private int length;

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

    public ContinuousService getService() {
        return service;
    }

    public void setService(ContinuousService service) {
        this.service = service;
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

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
