package tobetojava1b.rent_a_car.services.dtos.requests.holdproperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AircraftHoldPropertyDTO {
    private Long id;
    private String aircraftGroup;
    private String aircraftOwner;
    private String aircraftSubtype;
    private LocalDateTime validSince;
    private LocalDateTime validUntil;
    private List<AircraftHoldPropertyRegistrationDTO> aircraftHoldPropertyRegistrations;

}