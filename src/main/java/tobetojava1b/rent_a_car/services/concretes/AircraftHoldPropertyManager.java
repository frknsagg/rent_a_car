package tobetojava1b.rent_a_car.services.concretes;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tobetojava1b.rent_a_car.entities.AircraftHoldProperty;
import tobetojava1b.rent_a_car.entities.AircraftHoldPropertyRegistration;
import tobetojava1b.rent_a_car.mapper.AircraftHoldPropertyMapper;
import tobetojava1b.rent_a_car.mapper.AircraftHoldPropertyRegistrationMapper;
import tobetojava1b.rent_a_car.repositories.AircraftHoldPropertyRegistrationRepository;
import tobetojava1b.rent_a_car.repositories.AircraftHoldPropertyRepository;
import tobetojava1b.rent_a_car.services.abstracts.AircraftHoldPropertyService;
import tobetojava1b.rent_a_car.services.dtos.requests.holdproperty.AircraftHoldPropertyDTO;
import tobetojava1b.rent_a_car.services.dtos.requests.holdproperty.AircraftHoldPropertyRegistrationDTO;

import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AircraftHoldPropertyManager implements AircraftHoldPropertyService {

    private final AircraftHoldPropertyRepository aircraftHoldPropertyRepository;
    private final AircraftHoldPropertyRegistrationRepository aircraftHoldPropertyRegistrationRepository;

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
        // DTO'dan Entity'e dönüşüm
        AircraftHoldProperty aircraftHoldProperty = AircraftHoldPropertyMapper.INSTANCE.toEntity(aircraftHoldPropertyDTO);

        // Entity'nin kaydedilmesi
        aircraftHoldProperty = aircraftHoldPropertyRepository.save(aircraftHoldProperty);

        System.out.println("[INFO] " + " saveleme işlemi başarılı");

        // Oluşturulan Entity'nin ID'sinin alınması
        Long aircraftHoldPropertyId = aircraftHoldProperty.getId();


        System.out.println("[INFO] " + " aircraftHoldPropertyId: " + aircraftHoldPropertyId);

        List<AircraftHoldPropertyRegistration> aircraftHoldPropertyRegistrations = aircraftHoldPropertyDTO.getAircraftHoldPropertyRegistrations().stream()
                .peek(dto -> dto.setAircraftHoldPropertyId(aircraftHoldPropertyId)) // Her bir DTO nesnesine aircraftHoldPropertyId özelliğini ayarlayın
                .map(AircraftHoldPropertyRegistrationMapper.INSTANCE::toEntity) // Dönüştürülmüş DTO nesnelerini entity nesnelerine dönüştürün
                .collect(Collectors.toList());


        // Entity'lerin kaydedilmesi
        aircraftHoldPropertyRegistrationRepository.saveAll(aircraftHoldPropertyRegistrations);

        // DTO'ya dönüşüm ve geri döndürme
        return AircraftHoldPropertyMapper.INSTANCE.toDto(aircraftHoldProperty);
    }


}
