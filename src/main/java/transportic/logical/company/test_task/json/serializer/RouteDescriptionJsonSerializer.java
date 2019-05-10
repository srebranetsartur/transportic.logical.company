package transportic.logical.company.test_task.json.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import transportic.logical.company.test_task.domain.RouteDescription;

import java.io.IOException;

public class RouteDescriptionJsonSerializer extends StdSerializer<RouteDescription> {

    public RouteDescriptionJsonSerializer() {
        this(null);
    }

    public RouteDescriptionJsonSerializer(Class<RouteDescription> t) {
        super(t);
    }

    @Override
    public void serialize(RouteDescription routeDescription, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("from", routeDescription.getFrom().getId());
        jsonGenerator.writeNumberField("to", routeDescription.getTo().getId());
        jsonGenerator.writeNumberField("distance", routeDescription.getDistance());
        jsonGenerator.writeEndObject();
    }
}
