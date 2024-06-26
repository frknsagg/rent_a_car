package tobetojava1b.rent_a_car.services.dtos.responses.holdproperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAircraftHoldProperyListDTO  {
     private Long id;
    private String aircraftGroup;
    private String aircraftOwner;
    private String aircraftSubtype;
    private LocalDateTime validSince;
    private LocalDateTime validUntil;

}
