package tk.vivas.transport.tripRequest;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import java.time.LocalDateTime;

@JsonNaming(PropertyNamingStrategies.UpperCamelCaseStrategy.class)
public class Origin {
    private LocationRef locationRef;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime depArrTime;

    public LocationRef getLocationRef() {
        return locationRef;
    }

    public void setLocationRef(LocationRef locationRef) {
        this.locationRef = locationRef;
    }

    public LocalDateTime getDepArrTime() {
        return depArrTime;
    }

    public void setDepArrTime(LocalDateTime depArrTime) {
        this.depArrTime = depArrTime;
    }
}
