package tobetojava1b.rent_a_car.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@Entity
@Table(name = "HOLD_PROPERTY")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@AllArgsConstructor
@NoArgsConstructor
public class HoldProperty{

    private static final String SEQUENCE_GENERATOR = "AircraftHoldPropertySequenceGenerator";
    private static final String SEQUENCE_NAME = "AIRCRAFT_HOLD_PROPERTY_SEQUENCE";
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_GENERATOR)
    @SequenceGenerator(name = SEQUENCE_GENERATOR, sequenceName = SEQUENCE_NAME, allocationSize = 1)
    @Column(name = "ID")
    private Long id;

    @Column(name = "HOLD")
    private String hold;

    @Column(name = "VENTILATION")
    private boolean ventilation;

    @Column(name = "CARGO_TEMPERATURE_CONTROL_SYSTEM")
    private boolean cargoTemperatureControlSystem;

    @Column(name = "CARGO_TEMPERATURE_MIN")
    private int cargoTemperatureMin;

    @Column(name = "CARGO_TEMPERATURE_MAX")
    private int cargoTemperatureMax;

    @ManyToOne()
    @JoinColumn(name = "AIRCRAFT_HOLD_REGISTRATION_ID", nullable = false)
    private AircraftHoldPropertyRegistration aircraftHoldPropertyRegistration;

}
