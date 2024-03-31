package tobetojava1b.rent_a_car.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tobetojava1b.rent_a_car.entities.HoldProperty;

public interface HoldPropertyRepository extends JpaRepository<HoldProperty,Long>{
}
