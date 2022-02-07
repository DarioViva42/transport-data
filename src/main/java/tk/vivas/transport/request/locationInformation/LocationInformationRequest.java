package tk.vivas.transport.request.locationInformation;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.UpperCamelCaseStrategy.class)
public class LocationInformationRequest {
    private InitialInput initialInput;

    private Restrictions restrictions;

    public LocationInformationRequest(InitialInput initialInput, Restrictions restrictions) {
        this.initialInput = initialInput;
        this.restrictions = restrictions;
    }

    public InitialInput getInitialInput() {
        return initialInput;
    }

    public void setInitialInput(InitialInput initialInput) {
        this.initialInput = initialInput;
    }

    public Restrictions getRestrictions() {
        return restrictions;
    }

    public void setRestrictions(Restrictions restrictions) {
        this.restrictions = restrictions;
    }
}
