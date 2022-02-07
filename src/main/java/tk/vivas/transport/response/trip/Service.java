package tk.vivas.transport.response.trip;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import tk.vivas.transport.response.Message;
import tk.vivas.transport.response.Mode;
import tk.vivas.transport.response.Name;

import java.util.List;

@JsonNaming(PropertyNamingStrategies.UpperCamelCaseStrategy.class)
public class Service {
    @JsonProperty(namespace = "trias")
    private String operatingDayRef;

    @JsonProperty(namespace = "trias")
    private String journeyRef;

    @JsonProperty(namespace = "trias")
    private String lineRef;

    @JsonProperty(namespace = "trias")
    private String directionRef;

    @JsonProperty(namespace = "trias")
    private Mode mode;

    @JsonProperty(namespace = "trias")
    private Name publishedLineName;

    @JsonProperty(namespace = "trias")
    private String operatorRef;

    @JacksonXmlElementWrapper(useWrapping = false)
    @JsonProperty(namespace = "trias")
    private List<Message> attribute;

    @JsonProperty(namespace = "trias")
    private Name originText;

    @JsonProperty(namespace = "trias")
    private String destinationStopPointRef;

    @JsonProperty(namespace = "trias")
    private Name destinationText;

    @JsonProperty(namespace = "trias")
    private boolean deviation;

    public String getOperatingDayRef() {
        return operatingDayRef;
    }

    public void setOperatingDayRef(String operatingDayRef) {
        this.operatingDayRef = operatingDayRef;
    }

    public String getJourneyRef() {
        return journeyRef;
    }

    public void setJourneyRef(String journeyRef) {
        this.journeyRef = journeyRef;
    }

    public String getLineRef() {
        return lineRef;
    }

    public void setLineRef(String lineRef) {
        this.lineRef = lineRef;
    }

    public String getDirectionRef() {
        return directionRef;
    }

    public void setDirectionRef(String directionRef) {
        this.directionRef = directionRef;
    }

    public Mode getMode() {
        return mode;
    }

    public void setMode(Mode mode) {
        this.mode = mode;
    }

    public Name getPublishedLineName() {
        return publishedLineName;
    }

    public void setPublishedLineName(Name publishedLineName) {
        this.publishedLineName = publishedLineName;
    }

    public String getOperatorRef() {
        return operatorRef;
    }

    public void setOperatorRef(String operatorRef) {
        this.operatorRef = operatorRef;
    }

    public List<Message> getAttribute() {
        return attribute;
    }

    public void setAttribute(List<Message> attribute) {
        this.attribute = attribute;
    }

    public Name getOriginText() {
        return originText;
    }

    public void setOriginText(Name originText) {
        this.originText = originText;
    }

    public String getDestinationStopPointRef() {
        return destinationStopPointRef;
    }

    public void setDestinationStopPointRef(String destinationStopPointRef) {
        this.destinationStopPointRef = destinationStopPointRef;
    }

    public Name getDestinationText() {
        return destinationText;
    }

    public void setDestinationText(Name destinationText) {
        this.destinationText = destinationText;
    }

    public boolean isDeviation() {
        return deviation;
    }

    public void setDeviation(boolean deviation) {
        this.deviation = deviation;
    }
}
