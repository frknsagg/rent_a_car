package tobetojava1b.rent_a_car.services.dtos.requests.holdproperty;

import jakarta.websocket.server.ServerEndpoint;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AircraftHoldPropertyRegistrationDTO {
    private Long aircraftHoldPropertyId; // Yeni eklenen alan
    private String registrationGroup;
    private String comment;
//    private List<HoldPropertyDTO> holdProperties;
}
