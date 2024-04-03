package tobetojava1b.rent_a_car.services.abstracts;

import tobetojava1b.rent_a_car.entities.AircraftHoldProperty;
import tobetojava1b.rent_a_car.entities.AircraftHoldPropertyRegistration;
import tobetojava1b.rent_a_car.services.dtos.requests.holdproperty.AircraftHoldPropertyDTO;
import tobetojava1b.rent_a_car.services.dtos.requests.holdproperty.AircraftHoldPropertyRegistrationDTO;

import java.util.List;

public interface AircraftHoldPropertyRegistrationService {

    List<AircraftHoldPropertyRegistration> findAll();

    void save(AircraftHoldPropertyRegistrationDTO dto);
}
