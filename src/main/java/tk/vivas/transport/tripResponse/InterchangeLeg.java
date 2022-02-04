package tk.vivas.transport.tripResponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

import java.time.LocalDateTime;

@JsonNaming(PropertyNamingStrategies.UpperCamelCaseStrategy.class)
public class InterchangeLeg extends AbstractLeg {
    @JsonProperty(namespace = "trias")
    private String interchangeMode;

    @JsonProperty(namespace = "trias")
    private LegStartEnd legStart;

    @JsonProperty(namespace = "trias")
    private LegStartEnd legEnd;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonProperty(namespace = "trias")
    private LocalDateTime timeWindowStart;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonProperty(namespace = "trias")
    private LocalDateTime timeWindowEnd;

    @JsonProperty(namespace = "trias")
    private String duration;

    public String getInterchangeMode() {
        return interchangeMode;
    }

    public void setInterchangeMode(String interchangeMode) {
        this.interchangeMode = interchangeMode;
    }

    public LegStartEnd getLegStart() {
        return legStart;
    }

    public void setLegStart(LegStartEnd legStart) {
        this.legStart = legStart;
    }

    public LegStartEnd getLegEnd() {
        return legEnd;
    }

    public void setLegEnd(LegStartEnd legEnd) {
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

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
