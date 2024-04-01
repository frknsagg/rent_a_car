package tobetojava1b.rent_a_car.mapper;

import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MapperConfig {
    @Bean
    public AircraftHoldPropertyMapper aircraftHoldPropertyMapper() {
        return Mappers.getMapper(AircraftHoldPropertyMapper.class);
    }
}
