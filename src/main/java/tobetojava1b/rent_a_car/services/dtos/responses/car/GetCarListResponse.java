package tobetojava1b.rent_a_car.services.dtos.responses.car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tobetojava1b.rent_a_car.entities.Model;
import tobetojava1b.rent_a_car.services.dtos.responses.model.GetModelResponse;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetCarListResponse {
    private int id;
    private GetModelResponse model;

}
