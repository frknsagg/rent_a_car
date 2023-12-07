package tobetojava1b.rent_a_car.services.dtos.responses.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import tobetojava1b.rent_a_car.services.dtos.responses.brand.GetBrandListResponse;
import tobetojava1b.rent_a_car.services.dtos.responses.brand.GetBrandResponse;

@Data
@AllArgsConstructor
public class GetModelListResponse {
    private String name;
    private String modelYear;
    private GetBrandListResponse brands;
}
