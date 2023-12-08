package tobetojava1b.rent_a_car.services.dtos.requests.payment;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddPaymentRequest {
    @NotBlank(message = "Method ismi boş bırakılamaz")
    @Size(min = 2,max = 30,message = "Method ismi en az 2 maksimum 30 karakter olabilir.")
    private String paymentMethod;
}
