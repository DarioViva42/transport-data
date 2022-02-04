package tk.vivas.transport.tripResponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import java.util.List;

@JsonNaming(PropertyNamingStrategies.UpperCamelCaseStrategy.class)
public class Trip {
    @JsonProperty(namespace = "trias")
    private String tripId;

    @JsonProperty(namespace = "trias")
    private String duration;

    @JsonProperty(namespace = "trias")
    private String startTime;

    @JsonProperty(namespace = "trias")
    private String endTime;

    @JsonProperty(namespace = "trias")
    private int interchanges;

    @JsonProperty(namespace = "trias")
    private int distance;

    @JacksonXmlElementWrapper(useWrapping = false)
    @JsonProperty(namespace = "trias")
    private List<TripLeg> tripLeg;

    public String getTripId() {
        return tripId;
    }

    public void setTripId(String tripId) {
        this.tripId = tripId;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getInterchanges() {
        return interchanges;
    }

    public void setInterchanges(int interchanges) {
        this.interchanges = interchanges;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public List<TripLeg> getTripLeg() {
        return tripLeg;
    }

    public void setTripLeg(List<TripLeg> tripLeg) {
        this.tripLeg = tripLeg;
    }
}
