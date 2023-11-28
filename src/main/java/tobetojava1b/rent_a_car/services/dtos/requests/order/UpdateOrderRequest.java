package tobetojava1b.rent_a_car.services.dtos.requests.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateOrderRequest {
    public int carId;
    public int customerId;
    public int paymentId;
    public int rentalDetailId;
}
