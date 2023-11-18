package tobetojava1b.rent_a_car.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "method")
    private String paymentMethod;


    @OneToMany(mappedBy = "payment")
    private List<Order> orders;
}
