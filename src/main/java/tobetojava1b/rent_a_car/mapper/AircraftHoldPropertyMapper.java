package tobetojava1b.rent_a_car.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import tobetojava1b.rent_a_car.entities.AircraftHoldProperty;

@Mapper(componentModel = "spring")
public interface AircraftHoldPropertyMapper {
    AircraftHoldPropertyMapper INSTANCE = Mappers.getMapper(AircraftHoldPropertyMapper.class);


    GetAircraftHoldProperyListDTO toDTO(AircraftHoldProperty entity);
}
