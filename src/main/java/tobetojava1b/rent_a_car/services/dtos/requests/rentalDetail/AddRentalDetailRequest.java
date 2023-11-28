package tobetojava1b.rent_a_car.services.dtos.requests.rentalDetail;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddRentalDetailRequest {
    public String methodName;
    public LocalDate startDate;
    public LocalDate endDate;
    public int totalPrice;
    public boolean rentalStatus;

}
