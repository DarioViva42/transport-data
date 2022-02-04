package tk.vivas.transport.tripRequest;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.UpperCamelCaseStrategy.class)
public class Params {
    private int numberOfResults;

    private boolean includeTrackSections;

    private boolean includeLegProjection;

    private boolean includeIntermediateStops;

    public Params(int numberOfResults,
                  boolean includeTrackSections, boolean includeLegProjection, boolean includeIntermediateStops) {
        this.numberOfResults = numberOfResults;
        this.includeTrackSections = includeTrackSections;
        this.includeLegProjection = includeLegProjection;
        this.includeIntermediateStops = includeIntermediateStops;
    }

    public Params(int numberOfResults) {
        this.numberOfResults = numberOfResults;
    }

    public int getNumberOfResults() {
        return numberOfResults;
    }

    public void setNumberOfResults(int numberOfResults) {
        this.numberOfResults = numberOfResults;
    }

    public boolean isIncludeTrackSections() {
        return includeTrackSections;
    }

    public void setIncludeTrackSections(boolean includeTrackSections) {
        this.includeTrackSections = includeTrackSections;
    }

    public boolean isIncludeLegProjection() {
        return includeLegProjection;
    }

    public void setIncludeLegProjection(boolean includeLegProjection) {
        this.includeLegProjection = includeLegProjection;
    }

    public boolean isIncludeIntermediateStops() {
        return includeIntermediateStops;
    }

    public void setIncludeIntermediateStops(boolean includeIntermediateStops) {
        this.includeIntermediateStops = includeIntermediateStops;
    }
}
