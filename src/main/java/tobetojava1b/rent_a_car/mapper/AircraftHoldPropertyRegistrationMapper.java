package tobetojava1b.rent_a_car.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.factory.Mappers;
import tobetojava1b.rent_a_car.entities.AircraftHoldPropertyRegistration;
import tobetojava1b.rent_a_car.services.dtos.requests.holdproperty.AircraftHoldPropertyRegistrationDTO;

@Mapper(componentModel = "spring",nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
uses = HoldPropertyMapper.class )
public interface AircraftHoldPropertyRegistrationMapper {

    AircraftHoldPropertyRegistrationMapper INSTANCE = Mappers.getMapper(AircraftHoldPropertyRegistrationMapper.class);

    AircraftHoldPropertyRegistrationDTO toDto(AircraftHoldPropertyRegistration entity);
    AircraftHoldPropertyRegistration toEntity(AircraftHoldPropertyRegistrationDTO dto);

//    AircraftHoldPropertyMapper INSTANCE = Mappers.getMapper(AircraftHoldPropertyMapper.class);
//
//
//    AircraftHoldPropertyRegistration toEntity(CreateAircraftHoldRegistration dto);
//
//    @Mapping(target = "holdPropertyDTOS", ignore = true)
//    AircraftHoldRegistrationDTO toDTO(AircraftHoldPropertyRegistration entity);
}
