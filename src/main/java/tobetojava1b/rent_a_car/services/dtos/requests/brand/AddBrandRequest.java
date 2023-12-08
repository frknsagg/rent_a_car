package tobetojava1b.rent_a_car.services.dtos.requests.brand;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddBrandRequest {

    @NotBlank(message = "Marka Adı boş olamaz.")
    @Size(min = 3,max = 20,message = "Marka adı 3 ile 20 arasında olamaz.")
    private String name;
}
