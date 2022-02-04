package tk.vivas.transport.tripRequest;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import java.time.LocalDateTime;

@JsonNaming(PropertyNamingStrategies.UpperCamelCaseStrategy.class)
public class Origin {
    private LocationRef locationRef;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime depArrTime;

    public Origin(LocationRef locationRef, LocalDateTime depArrTime) {
        this.locationRef = locationRef;
        this.depArrTime = depArrTime;
    }

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
