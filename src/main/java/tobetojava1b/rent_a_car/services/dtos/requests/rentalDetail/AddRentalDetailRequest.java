package tobetojava1b.rent_a_car.services.dtos.requests.rentalDetail;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddRentalDetailRequest {
    @NotBlank(message = "method adı boş bırakılamaz.")
    public String methodName;
    public LocalDate startDate;
    public LocalDate endDate;
    @Min(value = 0,message = "Toplam fiyat 0 veya 0'dan daha düşük olamaz.")
    public int totalPrice;
    public boolean rentalStatus;

}
