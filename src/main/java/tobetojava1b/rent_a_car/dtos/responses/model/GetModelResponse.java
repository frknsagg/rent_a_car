package tobetojava1b.rent_a_car.dtos.responses.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetModelResponse {
    private String name;
    private String year;
}
