package transportic.logical.company.test_task.domain;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import transportic.logical.company.test_task.json.serializer.RouteDescriptionJsonSerializer;

import java.io.IOException;

/**Helper class to hold Routes Property
 * Map to JSON dynamically
 */
@Data
@AllArgsConstructor
@JsonSerialize(using = RouteDescriptionJsonSerializer.class)
public class RouteDescription {
    private Locations from;
    private Locations to;

    private double distance;

}

