package tobetojava1b.rent_a_car.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "cars")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private  Model model;

    @ManyToOne()
    @JoinColumn(name = "insurance_id")
    private Insurance insurance;


    @OneToMany(mappedBy = "car")
    @JsonIgnore
    private List<Order> orders;



}
