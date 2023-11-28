package tobetojava1b.rent_a_car.services.dtos.requests.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tobetojava1b.rent_a_car.entities.Brand;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddModelRequest {
    private String name;
    private String modelYear;
    private int  brandId;
}
