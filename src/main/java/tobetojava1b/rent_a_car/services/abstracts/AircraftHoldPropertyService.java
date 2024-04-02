package tobetojava1b.rent_a_car.services.abstracts;



import tobetojava1b.rent_a_car.entities.AircraftHoldProperty;
import tobetojava1b.rent_a_car.services.dtos.requests.holdproperty.AircraftHoldPropertyDTO;

import java.util.List;

public interface AircraftHoldPropertyService {
    List<AircraftHoldProperty> findAll();

    void save(AircraftHoldProperty dto);

     AircraftHoldPropertyDTO createAircraftHoldProperty(AircraftHoldPropertyDTO aircraftHoldPropertyDTO) ;


     List<AircraftHoldPropertyDTO> getAllAircraftHoldProperties();



}
