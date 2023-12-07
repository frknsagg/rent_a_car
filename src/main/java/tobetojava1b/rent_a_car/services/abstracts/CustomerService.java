package tobetojava1b.rent_a_car.services.abstracts;



import tobetojava1b.rent_a_car.entities.Customer;
import tobetojava1b.rent_a_car.services.dtos.requests.customer.AddCustomerRequest;
import tobetojava1b.rent_a_car.services.dtos.requests.customer.UpdateCustomerRequest;
import tobetojava1b.rent_a_car.services.dtos.responses.customer.GetCustomerResponse;

import java.util.List;

public interface CustomerService {
    void add(AddCustomerRequest request);

    GetCustomerResponse getById(int id);

    void update(int id, UpdateCustomerRequest request);

    void delete(int id);

    List<Customer> getAll();
    List<GetCustomerResponse> findByNameStartingWith(String prefix);
    List<GetCustomerResponse> findByNameEndingWith(String suffix);
    List<GetCustomerResponse> getPhoneNumberIsNotNull();
    List<GetCustomerResponse> search(String firstName);
}
