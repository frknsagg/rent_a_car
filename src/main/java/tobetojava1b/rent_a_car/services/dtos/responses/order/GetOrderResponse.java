package tobetojava1b.rent_a_car.services.dtos.responses.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetOrderResponse {
    public String carName;
    public String paymentMethod;
    public String CustomerName;
}
