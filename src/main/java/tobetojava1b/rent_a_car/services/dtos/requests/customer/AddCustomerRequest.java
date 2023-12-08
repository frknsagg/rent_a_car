package tobetojava1b.rent_a_car.services.dtos.requests.customer;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddCustomerRequest {
    @NotBlank(message = "İsim alanı boş bırakılamaz.")
    @Size(min = 2,max = 25,message = "İsim en az 2 en fazla 25 karakter olabilir")
    private String firstName;
    @NotBlank(message = "Soyisim alanı boş bırakılamaz.")
    @Size(min = 2,max = 25,message = "Soyisim en az 2 en fazla 25 karakter olabilir")
    private String lastName;
    @Email(message = "Hatalı email")
    private String email;
    @Pattern(regexp = "[0-9\\\\s]{12}",message = "Telefon numaranızı istenen formatta giriniz.")
    private String phone;
}
