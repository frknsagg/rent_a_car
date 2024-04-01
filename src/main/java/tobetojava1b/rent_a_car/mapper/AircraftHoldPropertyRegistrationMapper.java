package tobetojava1b.rent_a_car.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.factory.Mappers;
import tobetojava1b.rent_a_car.entities.AircraftHoldProperty;
import tobetojava1b.rent_a_car.entities.AircraftHoldPropertyRegistration;
import tobetojava1b.rent_a_car.services.dtos.requests.holdproperty.AircraftHoldRegistrationDTO;
import tobetojava1b.rent_a_car.services.dtos.requests.holdproperty.CreateAircraftHoldRegistration;
import tobetojava1b.rent_a_car.services.dtos.responses.holdproperty.GetAircraftHoldProperyListDTO;

@Mapper(componentModel = "spring",nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
uses = HoldPropertyMapper.class )
public interface AircraftHoldPropertyRegistrationMapper {

    AircraftHoldPropertyMapper INSTANCE = Mappers.getMapper(AircraftHoldPropertyMapper.class);


    AircraftHoldPropertyRegistration toEntity(CreateAircraftHoldRegistration entity);

    @Mapping(target = "holdProperties", ignore = true)
    AircraftHoldRegistrationDTO toDTO(AircraftHoldPropertyRegistration entity);
}
