package tobetojava1b.rent_a_car.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tobetojava1b.rent_a_car.entities.Payment;

public interface PaymentRepository extends JpaRepository<Payment,Integer> {
    boolean existsByPaymentMethod(String name);
}
