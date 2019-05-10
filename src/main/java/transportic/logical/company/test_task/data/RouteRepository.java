package transportic.logical.company.test_task.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import transportic.logical.company.test_task.domain.Route;

@Repository
public interface RouteRepository extends CrudRepository<Route, Long> {

}
