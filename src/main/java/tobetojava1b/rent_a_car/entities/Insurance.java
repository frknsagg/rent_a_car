package tobetojava1b.rent_a_car.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "insurances")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Insurance {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "company_name")
    private String companyName;
    @Column(name = "start_date")
    private LocalDate startDate;
    @Column(name = "end_date")
    private LocalDate endDate;
    @Column(name = "policy_number")
    private String policyNumber;

    @OneToMany(mappedBy = "insurance")
    @JsonIgnore
    private List<Car> cars;

}
