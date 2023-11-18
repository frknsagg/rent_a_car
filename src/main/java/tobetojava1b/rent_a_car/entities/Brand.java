package tobetojava1b.rent_a_car.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "brands")
public class Brand {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "brand") //attribute ismi
    private List<Car> cars;

    @OneToMany(mappedBy = "brand")
    private List<Model> models;
}
