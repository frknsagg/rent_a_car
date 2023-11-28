package tobetojava1b.rent_a_car.services.dtos.responses.payment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetPaymentResponse {
    private String paymentMethod;
}
