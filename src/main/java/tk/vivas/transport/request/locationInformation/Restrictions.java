package tk.vivas.transport.request.locationInformation;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.UpperCamelCaseStrategy.class)
public class Restrictions {
    private String type;

    private int numberOfResults;

    private boolean includePtModes;

    public Restrictions(String type, int numberOfResults, boolean includePtModes) {
        this.type = type;
        this.numberOfResults = numberOfResults;
        this.includePtModes = includePtModes;
    }

    public Restrictions(int numberOfResults) {
        this.type = "stop";
        this.numberOfResults = numberOfResults;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNumberOfResults() {
        return numberOfResults;
    }

    public void setNumberOfResults(int numberOfResults) {
        this.numberOfResults = numberOfResults;
    }

    public boolean isIncludePtModes() {
        return includePtModes;
    }

    public void setIncludePtModes(boolean includePtModes) {
        this.includePtModes = includePtModes;
    }
}
