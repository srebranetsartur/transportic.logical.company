package transportic.logical.company.test_task.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import transportic.logical.company.test_task.data.RouteRepository;
import transportic.logical.company.test_task.domain.Locations;
import transportic.logical.company.test_task.domain.Route;
import transportic.logical.company.test_task.domain.RouteDescription;
import transportic.logical.company.test_task.domain.RoutePlan;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/routes")
public class RoutePlanController {
    private RouteRepository routeRepository;

    @Autowired
    public RoutePlanController(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }


    @GetMapping(path = "/{id}/plan")
    public ResponseEntity<RoutePlan> planRoute(@PathVariable Long id) {
        ResponseEntity<RoutePlan> response = new ResponseEntity<>(HttpStatus.NOT_FOUND);

        RoutePlan routePlan = new RoutePlan();
        Optional<Route> routeById = routeRepository.findById(id);

        if(routeById.isPresent()) {
            List<RouteDescription> routes;
            Route route = routeById.get();
            Locations head = route.getHead();

            if(head.isHead()) {
                routes = initRouteDescription(route);
                double totalDistance = routes.stream().mapToDouble(RouteDescription::getDistance).sum();

                routePlan.setRoutes(routes);
                routePlan.setTotalDistance(totalDistance);
                response = new ResponseEntity<>(routePlan, HttpStatus.OK);
            }
            else {
                response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }


        }

        return response;
    }

    /**
     * Helper function to init resources
     * @param route - object that hold list of locations
     * @return
     */
    private List<RouteDescription> initRouteDescription(Route route) {
        List<RouteDescription> routes = new ArrayList<>();

        //Fill the resources list by reducing all elements from route starting with head
        route.getLocations().stream().reduce(route.getHead(), (from, to) -> {
                    double distance = distanceBetweenTwoLocation(from, to);
                    routes.add(new RouteDescription(from, to, distance));
                    return to;
                }
        );

        return routes;
    }


    /**
     * Function to calculate distance between two locations
     * @param loc1
     * @param loc2
     * @return calculated distances
     */
    private double distanceBetweenTwoLocation(Locations loc1, Locations loc2) {
        return Math.sqrt(Math.pow(loc2.getX() - loc1.getX(), 2) + Math.pow(loc2.getY() - loc1.getY(), 2));
    }


}

