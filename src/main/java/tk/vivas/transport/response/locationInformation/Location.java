package tk.vivas.transport.response.locationInformation;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import tk.vivas.transport.response.Mode;

@JsonNaming(PropertyNamingStrategies.UpperCamelCaseStrategy.class)
public class Location {
    private InnerLocation location;

    private boolean complete;

    private float probability;

    private Mode mode;

    public InnerLocation getLocation() {
        return location;
    }

    public void setLocation(InnerLocation location) {
        this.location = location;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public float getProbability() {
        return probability;
    }

    public void setProbability(float probability) {
        this.probability = probability;
    }

    public Mode getMode() {
        return mode;
    }

    public void setMode(Mode mode) {
        this.mode = mode;
    }
}
