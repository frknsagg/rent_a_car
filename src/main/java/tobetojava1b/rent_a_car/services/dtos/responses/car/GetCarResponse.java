package tobetojava1b.rent_a_car.services.dtos.responses.car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetCarResponse {

    private String modelName;
    private String modelYear;
    private String insuranceCompanyName;
    private LocalDate insuranceStartDate;
}