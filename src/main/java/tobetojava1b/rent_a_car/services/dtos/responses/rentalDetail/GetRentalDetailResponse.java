package tobetojava1b.rent_a_car.services.dtos.responses.rentalDetail;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tobetojava1b.rent_a_car.services.dtos.responses.payment.GetPaymentResponse;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetRentalDetailResponse {
    public LocalDate startDate;
    public LocalDate endDate;
    public int totalPrice;
    public boolean status;
}
