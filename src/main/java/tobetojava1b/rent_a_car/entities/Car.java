package tobetojava1b.rent_a_car.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;

import java.util.List;

@Table(name = "cars")
@Entity
public class Car {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private  Model model;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @ManyToOne()
    @JoinColumn(name = "insurance_id")
    private Insurance insurance;


    @OneToMany(mappedBy = "car")
    private List<Order> orders;



}
