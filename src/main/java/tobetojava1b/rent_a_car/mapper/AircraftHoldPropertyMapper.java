package tobetojava1b.rent_a_car.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.factory.Mappers;
import tobetojava1b.rent_a_car.entities.AircraftHoldProperty;
import tobetojava1b.rent_a_car.entities.AircraftHoldPropertyRegistration;
import tobetojava1b.rent_a_car.repositories.AircraftHoldPropertyRepository;
import tobetojava1b.rent_a_car.services.dtos.requests.holdproperty.AircraftHoldPropertyDTO;
import tobetojava1b.rent_a_car.services.dtos.requests.holdproperty.AircraftHoldPropertyRegistrationDTO;
import tobetojava1b.rent_a_car.services.dtos.responses.holdproperty.GetAircraftHoldProperyListDTO;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring",
nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
uses = AircraftHoldPropertyRegistrationMapper.class)
public interface AircraftHoldPropertyMapper {

    AircraftHoldPropertyMapper INSTANCE = Mappers.getMapper(AircraftHoldPropertyMapper.class);

    AircraftHoldPropertyDTO toDto(AircraftHoldProperty entity);

    AircraftHoldProperty toEntity(AircraftHoldPropertyDTO dto);

    AircraftHoldPropertyRegistration registrationDtoToEntity(AircraftHoldPropertyRegistrationDTO dto);


    default AircraftHoldPropertyDTO entityToDto(AircraftHoldProperty entity) {
        return Mappers.getMapper(AircraftHoldPropertyMapper.class).toDto(entity);
    }
//    AircraftHoldPropertyMapper INSTANCE = Mappers.getMapper(AircraftHoldPropertyMapper.class);
//
//
//    GetAircraftHoldProperyListDTO toDTO(AircraftHoldProperty entity);
//
//
//
//    @Mapping(target = "aircraftHoldPropertyRegistrations", ignore = true)
//    AircraftHoldProperty toEntity(CreateAircraftHoldProperty createAircraftHoldProperty);
//
//
//    default List<GetAircraftHoldProperyListDTO> toDTOs(List<AircraftHoldProperty> entities) {
//        return entities.stream().map(this::toDTO).collect(Collectors.toList());
//    }
}
