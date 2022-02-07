package tk.vivas.transport;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;

public class RealLocalDateTimeDeserializer extends LocalDateTimeDeserializer {
    @Override
    public LocalDateTime deserialize(JsonParser parser, DeserializationContext context) throws IOException {
        return super.deserialize(parser, context).plus(Duration.ofHours(1));
    }
}
