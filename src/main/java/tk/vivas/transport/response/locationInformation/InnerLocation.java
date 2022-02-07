package tk.vivas.transport.response.locationInformation;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import tk.vivas.transport.response.Name;
import tk.vivas.transport.response.Location;
import tk.vivas.transport.response.StopPoint;

@JsonNaming(PropertyNamingStrategies.UpperCamelCaseStrategy.class)
public class InnerLocation {
    private StopPoint stopPoint;

    private Name locationName;

    private GeoPosition geoPosition;

    public StopPoint getStopPoint() {
        return stopPoint;
    }

    public void setStopPoint(StopPoint stopPoint) {
        this.stopPoint = stopPoint;
    }

    public Name getLocationName() {
        return locationName;
    }

    public void setLocationName(Name locationName) {
        this.locationName = locationName;
    }

    public GeoPosition getGeoPosition() {
        return geoPosition;
    }

    public void setGeoPosition(GeoPosition geoPosition) {
        this.geoPosition = geoPosition;
    }
}
