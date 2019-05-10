package transportic.logical.company.test_task.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import transportic.logical.company.test_task.domain.Locations;

@Repository
public interface LocationsRepository extends CrudRepository<Locations, Long> {
}
