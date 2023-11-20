package tobetojava1b.rent_a_car.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tobetojava1b.rent_a_car.entities.Order;

public interface OrderRepository extends JpaRepository<Order,Integer> {
}
