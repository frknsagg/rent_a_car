package tobetojava1b.rent_a_car.services.dtos.requests.payment;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddPaymentRequest {
    private String paymentMethod;
}
