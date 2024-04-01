package tobetojava1b.rent_a_car.services.dtos.requests.holdproperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AircraftHoldRegistrationDTO {

    private Long aircraftHoldpropertyId;
    private String registrationGroup;
    private List<String> registrationNumbers;
    private String comment;
    private List<HoldPropertyDTO> holdPropertyDTOS;
}
