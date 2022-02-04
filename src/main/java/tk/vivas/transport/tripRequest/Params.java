package tk.vivas.transport.tripRequest;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.UpperCamelCaseStrategy.class)
public class Params {
    private boolean numberOfResults;

    private boolean includeTrackSections;

    private boolean includeLegProjection;

    private boolean includeIntermediateStops;

    public boolean isNumberOfResults() {
        return numberOfResults;
    }

    public void setNumberOfResults(boolean numberOfResults) {
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
