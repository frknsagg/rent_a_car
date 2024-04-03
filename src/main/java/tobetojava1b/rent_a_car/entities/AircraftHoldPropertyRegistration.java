package tobetojava1b.rent_a_car.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "AIRCRAFT_HOLD_PROPERTY_REGISTRATION")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@AllArgsConstructor
@NoArgsConstructor
public class AircraftHoldPropertyRegistration {

    private static final String SEQUENCE_GENERATOR = "AircraftHoldPropertyRegistrationSequenceGenerator";
    private static final String SEQUENCE_NAME = "AIRCRAFT_HOLD_PROPERTY_REGISTRATION_SEQUENCE";
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_GENERATOR)
    @SequenceGenerator(name = SEQUENCE_GENERATOR, sequenceName = SEQUENCE_NAME, allocationSize = 1)
    @Column(name = "ID")
    private Long id;

//    @OneToMany(mappedBy = "aircraftHoldPropertyRegistration", cascade = CascadeType.ALL)
//    private List<HoldProperty> holdProperties ;

    @ManyToOne()
    @JoinColumn(name = "AIRCRAFT_HOLD_PROPERTY_ID")
    private AircraftHoldProperty aircraftHoldProperty;

    @Column(name = "REGISTRATION_GROUP")
    private String registrationGroup;

//    @ElementCollection
//    @CollectionTable(name = "AIRCRAFT_REGISTRATION_NUMBERS",
//            joinColumns = @JoinColumn(name = "REGISTRATION_ID"))
//    @Column(name = "REGISTRATION_NUMBER")
//    private List<String> registrationNumbers;

    @Column(name = "COMMENT")
    private String comment;
}