package tobetojava1b.rent_a_car.services.dtos.requests.insurance;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddInsuranceRequest {
    @NotBlank(message = "Şirket ismi boş bırakılamaz")
    private String companyName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;
    private LocalDate endDate;
    @NotBlank()
    @Pattern(regexp = "\\d{6}", message = "Altı haneli bir sayı giriniz")
    private String policyNumber;
}
