package tobetojava1b.rent_a_car.services.concretes;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tobetojava1b.rent_a_car.entities.AircraftHoldProperty;
import tobetojava1b.rent_a_car.mapper.AircraftHoldPropertyMapper;
import tobetojava1b.rent_a_car.repositories.AircraftHoldPropertyRepository;
import tobetojava1b.rent_a_car.services.abstracts.AircraftHoldPropertyService;
import tobetojava1b.rent_a_car.services.dtos.requests.holdproperty.AircraftHoldPropertyDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class AircraftHoldPropertyManager implements AircraftHoldPropertyService {

    private final AircraftHoldPropertyRepository aircraftHoldPropertyRepository;


    public AircraftHoldPropertyManager(AircraftHoldPropertyRepository aircraftHoldPropertyRepository) {
        this.aircraftHoldPropertyRepository = aircraftHoldPropertyRepository;

    }

    @Override
    public List<AircraftHoldProperty> findAll() {
        List<AircraftHoldProperty> entities = aircraftHoldPropertyRepository.findAll();
        return entities;
    }
    @Override
    public List<AircraftHoldPropertyDTO> getAllAircraftHoldProperties() {
        List<AircraftHoldProperty> aircraftHoldProperties = aircraftHoldPropertyRepository.findAll();
        return aircraftHoldProperties.stream()
                .map(AircraftHoldPropertyMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }
    @Override
    public void save(AircraftHoldProperty dto) {
        aircraftHoldPropertyRepository.save(dto);
    }

    @Override
    public AircraftHoldPropertyDTO createAircraftHoldProperty(AircraftHoldPropertyDTO aircraftHoldPropertyDTO) {
        AircraftHoldProperty aircraftHoldProperty = AircraftHoldPropertyMapper.INSTANCE.toEntity(aircraftHoldPropertyDTO);
        aircraftHoldProperty = aircraftHoldPropertyRepository.save(aircraftHoldProperty);
        return AircraftHoldPropertyMapper.INSTANCE.toDto(aircraftHoldProperty);
    }


}
