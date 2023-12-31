package tobetojava1b.rent_a_car.services.dtos.responses.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetCustomerResponse {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
}
