package tobetojava1b.rent_a_car.services.dtos.requests.holdproperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HoldPropertyDTO {
    private Long id;
    private String hold;
    private boolean ventilation;
    private boolean cargoTemperatureControlSystem;
    private int cargoTemperatureMin;
    private int cargoTemperatureMax;
}
