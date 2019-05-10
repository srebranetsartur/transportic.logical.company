package transportic.logical.company.test_task.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import transportic.logical.company.test_task.data.LocationsRepository;

@Service
public class LocationsService {
    private LocationsRepository locationsRepository;

    @Autowired
    public LocationsService(LocationsRepository locationsRepository) {
        this.locationsRepository = locationsRepository;
    }


}
