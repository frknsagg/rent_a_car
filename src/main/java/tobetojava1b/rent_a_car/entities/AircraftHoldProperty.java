package tobetojava1b.rent_a_car.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "AIRCRAFT_HOLD_PROPERTY")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
@AllArgsConstructor
@NoArgsConstructor
public class AircraftHoldProperty {


    private static final String SEQUENCE_GENERATOR = "AircraftHoldPropertySequenceGenerator";
    private static final String SEQUENCE_NAME = "AIRCRAFT_HOLD_PROPERTY_SEQUENCE";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = SEQUENCE_GENERATOR)
    @SequenceGenerator(name = SEQUENCE_GENERATOR,sequenceName = SEQUENCE_NAME,allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @OneToMany(mappedBy = "aircraftHoldProperty", cascade = CascadeType.ALL)
    private List<AircraftHoldPropertyRegistration> aircraftHoldPropertyRegistrations;

    @Column(name = "AIRCRAFT_GROUP")
    private String aircraftGroup;

    @Column(name = "AIRCRAFT_OWNER")
    private String aircraftOwner;

    @Column(name = "AIRCRAFT_SUBTYPE")
    private String aircraftSubtype;

    @Column(name = "VALID_SINCE")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime validSince;

    @Column(name = "VALID_UNTIL")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime validUntil;



}
