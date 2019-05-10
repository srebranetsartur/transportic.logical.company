package transportic.logical.company.test_task.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.OneToMany;
import java.util.List;

@Data
@NoArgsConstructor
public class RoutePlan extends ResourceSupport {
    @OneToMany(targetEntity = RouteDescription.class)
    private List<RouteDescription> routes;
    private double totalDistance;

    @JsonCreator
    public RoutePlan(@JsonProperty("routes") List<RouteDescription> routes,
                     @JsonProperty("totalDistance") double totalDistance) {
        this.routes = routes;
        this.totalDistance = totalDistance;
    }
}
