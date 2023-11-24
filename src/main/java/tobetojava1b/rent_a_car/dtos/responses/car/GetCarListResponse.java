package tobetojava1b.rent_a_car.dtos.responses.car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetCarListResponse {

    private int modelId;
    private int insuranceId;
}
