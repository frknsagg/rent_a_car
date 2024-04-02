package tobetojava1b.rent_a_car.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.factory.Mappers;
import tobetojava1b.rent_a_car.entities.HoldProperty;
import tobetojava1b.rent_a_car.services.dtos.requests.holdproperty.HoldPropertyDTO;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface HoldPropertyMapper {

    HoldPropertyMapper INSTANCE = Mappers.getMapper(HoldPropertyMapper.class);

    HoldPropertyDTO toDto(HoldProperty entity);
    HoldProperty toEntity(HoldPropertyDTO dto);

//    HoldProperty toEntity(HoldPropertyDTO dto);
//
//    HoldPropertyDTO toDTO(HoldProperty entity);
//
//    default List<HoldPropertyDTO> toDTOs(List<HoldProperty> entities) {
//        return entities.stream().map(this::toDTO).collect(Collectors.toList());
//    }
}
