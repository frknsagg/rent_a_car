package tobetojava1b.rent_a_car.services.dtos.requests.insurance;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateInsuranceRequest {
    private String companyName;
    private LocalDate startDate;
    private LocalDate endDate;
    private String policyNumber;
}
