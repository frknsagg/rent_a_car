package tobetojava1b.rent_a_car.services.dtos.requests.brand;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateBrandRequest {
    private int id;
    private String name;
}
