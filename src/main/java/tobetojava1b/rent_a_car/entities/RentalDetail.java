package tobetojava1b.rent_a_car.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "rental_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RentalDetail {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "total_price")
    private int totalPrice;

    @Column(name = "status")
    private boolean rentalStatus;

    @OneToMany(mappedBy = "rentalDetail")
    @JsonIgnore
    private List<Order> orders;
}
