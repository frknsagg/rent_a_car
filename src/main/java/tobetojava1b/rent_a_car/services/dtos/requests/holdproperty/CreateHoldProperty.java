package tobetojava1b.rent_a_car.services.dtos.requests.holdproperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateHoldProperty {
    private Long aircraftHoldRegistrationId;
    private String holdName;
    private boolean ventilation;
    private boolean cargoTemperatureControlSystem;
    private int cargoTemperatureMin;
    private int cargoTemperatureMax;
}
