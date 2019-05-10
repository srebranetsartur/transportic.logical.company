package transportic.logical.company.test_task.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class Route {
    @Id
    @GeneratedValue
    private Long id;

    public Route(String name, Locations head, List<Locations> locations) {
        this.name = name;
        this.head = head;
        this.locations = locations;
    }

    private String name;
    @OneToOne(targetEntity = Locations.class)
    private Locations head;

    @Setter(AccessLevel.PRIVATE)
    @OneToMany(targetEntity = Locations.class)
    private List<Locations> locations = new ArrayList<>();
}
