package transportic.logical.company.test_task.domain;

import lombok.*;
import org.hibernate.annotations.Type;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;

@Entity
@Getter
@EqualsAndHashCode(of = "id")
@Setter
@NoArgsConstructor
public class Locations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double x;
    private double y;

    @Column(nullable = false)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean head;

    public Locations(String name, double x, double y, boolean isHead) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.head = isHead;
    }
}


