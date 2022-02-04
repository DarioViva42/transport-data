package tk.vivas.transport.tripRequest;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.UpperCamelCaseStrategy.class)
public class Destination {
    private LocationRef locationRef;

    public Destination(LocationRef locationRef) {
        this.locationRef = locationRef;
    }

    public LocationRef getLocationRef() {
        return locationRef;
    }

    public void setLocationRef(LocationRef locationRef) {
        this.locationRef = locationRef;
    }
}
