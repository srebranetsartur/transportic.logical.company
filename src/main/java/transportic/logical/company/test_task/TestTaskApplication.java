package transportic.logical.company.test_task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import transportic.logical.company.test_task.data.LocationsRepository;
import transportic.logical.company.test_task.data.RouteRepository;
import transportic.logical.company.test_task.domain.Locations;
import transportic.logical.company.test_task.domain.Route;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@ComponentScan(basePackages = "transportic.logical.company.test_task")
public class TestTaskApplication implements CommandLineRunner {
    @Autowired
    private LocationsRepository locationsRepository;

    @Autowired
    private RouteRepository routeRepository;


    public static void main(String[] args) {
        SpringApplication.run(TestTaskApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Locations kiev = locationsRepository.save(new Locations("Kiev", 2, 5, true));
        List<Locations> locs = new ArrayList<>();

        locs.add(locationsRepository.save(new Locations("C1", 5, 2, false)));
        locs.add(locationsRepository.save(new Locations("C2", 4, 4, false)));
        locs.add(locationsRepository.save(new Locations("C3", 2, 1, false)));
        locs.add(locationsRepository.save(new Locations("C4", 5, 5, false)));

        Route route = routeRepository.save(new Route("Kiev-Krolevets", kiev, locs));
    }
}
