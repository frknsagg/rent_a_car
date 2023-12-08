package tobetojava1b.rent_a_car.services.dtos.requests.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tobetojava1b.rent_a_car.entities.Brand;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddModelRequest {
    @NotBlank(message = "Model adı boş bırakılamaz")
    private String name;
    @Min(value = 1990,message ="1990 yılından daha eski araçlar eklenemez")
    private String modelYear;
    private int  brandId;
}
