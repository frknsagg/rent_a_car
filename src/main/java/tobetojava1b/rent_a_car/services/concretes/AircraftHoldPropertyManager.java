package tobetojava1b.rent_a_car.services.concretes;


import org.springframework.stereotype.Service;
import tobetojava1b.rent_a_car.entities.AircraftHoldProperty;
import tobetojava1b.rent_a_car.repositories.AircraftHoldPropertyRepository;
import tobetojava1b.rent_a_car.services.abstracts.AircraftHoldPropertyService;

import java.util.List;

@Service

public class AircraftHoldPropertyManager implements AircraftHoldPropertyService {

    private final AircraftHoldPropertyRepository aircraftHoldPropertyRepository;
//    private final AircraftHoldPropertyMapper aircraftHoldPropertyMapper;

    public AircraftHoldPropertyManager(AircraftHoldPropertyRepository aircraftHoldPropertyRepository) {
        this.aircraftHoldPropertyRepository = aircraftHoldPropertyRepository;
//        this.aircraftHoldPropertyMapper = aircraftHoldPropertyMapper;
    }

    public List<AircraftHoldProperty> findAll() {
        List<AircraftHoldProperty> entities = aircraftHoldPropertyRepository.findAll();
        return entities;
    }
    @Override
    public void save(AircraftHoldProperty dto) {
        aircraftHoldPropertyRepository.save(dto);
    }
}
