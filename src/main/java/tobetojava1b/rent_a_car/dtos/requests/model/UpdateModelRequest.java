package tobetojava1b.rent_a_car.dtos.requests.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateModelRequest {
    private String name;
    private String modelYear;
    private int  brandId;
}
