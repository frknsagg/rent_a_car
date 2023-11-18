package tobetojava1b.rent_a_car.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "models")
public class Model {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "model_year")
    private String modelYear;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @OneToMany(mappedBy = "model") //attribute ismi
    private List<Car> cars;


}
