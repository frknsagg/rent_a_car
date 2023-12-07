package tobetojava1b.rent_a_car.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tobetojava1b.rent_a_car.entities.Customer;
import tobetojava1b.rent_a_car.services.dtos.responses.customer.GetCustomerResponse;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    List<Customer> findByFirstNameStartingWith(String prefix);
    List<Customer> findByLastNameEndingWith(String suffix);

    @Query("Select new tobetojava1b.rent_a_car.services.dtos.responses.customer." +
            "GetCustomerResponse(c.firstName,c.lastName,c.email,c.phoneNumber)" +
            "From Customer c Where c.phoneNumber != '' OR c.phoneNumber IS NOT NULL")
    List<GetCustomerResponse> getPhoneNumberIsNotNull();

    @Query("Select new tobetojava1b.rent_a_car.services.dtos.responses.customer." +
            "GetCustomerResponse(c.firstName,c.lastName,c.email,c.phoneNumber)" +
            "From Customer c Where c.firstName = :firstName")
    List<GetCustomerResponse> search(String firstName);
}
