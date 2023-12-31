package tobetojava1b.rent_a_car.services.dtos.responses.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tobetojava1b.rent_a_car.services.dtos.responses.brand.GetBrandResponse;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetModelResponse {
    private String name;
    private String year;
    private GetBrandResponse brand;
}
