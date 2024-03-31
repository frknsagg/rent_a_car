package tobetojava1b.rent_a_car.services.abstracts;



import tobetojava1b.rent_a_car.entities.AircraftHoldProperty;

import java.util.List;

public interface AircraftHoldPropertyService {
    List<AircraftHoldProperty> findAll();

    void save(AircraftHoldProperty dto);
}
