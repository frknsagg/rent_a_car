package tobetojava1b.rent_a_car.services.concretes;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tobetojava1b.rent_a_car.entities.AircraftHoldProperty;
import tobetojava1b.rent_a_car.entities.AircraftHoldPropertyRegistration;
import tobetojava1b.rent_a_car.repositories.AircraftHoldPropertyRegistrationRepository;
import tobetojava1b.rent_a_car.services.abstracts.AircraftHoldPropertyRegistrationService;
import tobetojava1b.rent_a_car.services.dtos.requests.holdproperty.AircraftHoldPropertyRegistrationDTO;

import java.util.List;

@Service
@AllArgsConstructor
public class AircraftHoldPropertyRegistrationManager implements AircraftHoldPropertyRegistrationService {

    private final AircraftHoldPropertyRegistrationRepository aircraftHoldPropertyRegistrationRepository;

    @Override
    public List<AircraftHoldPropertyRegistration> findAll() {
        List<AircraftHoldPropertyRegistration> entities = aircraftHoldPropertyRegistrationRepository.findAll();
        return entities;
    }

    @Override
    public void save(AircraftHoldPropertyRegistrationDTO dto) {


    }
}
