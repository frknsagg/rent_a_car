package tobetojava1b.rent_a_car.services.concretes;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tobetojava1b.rent_a_car.entities.Customer;
import tobetojava1b.rent_a_car.repositories.CustomerRepository;
import tobetojava1b.rent_a_car.services.abstracts.CustomerService;
import tobetojava1b.rent_a_car.services.dtos.requests.customer.AddCustomerRequest;
import tobetojava1b.rent_a_car.services.dtos.requests.customer.UpdateCustomerRequest;
import tobetojava1b.rent_a_car.services.dtos.responses.customer.GetCustomerResponse;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class CustomerManager implements CustomerService {
    private final CustomerRepository customerRepository;

    @Override
    public void add(AddCustomerRequest request) {
        Customer customer = new Customer();
        customer.setFirstName(request.getFirstName());
        customer.setLastName(request.getLastName());
        customer.setEmail(request.getEmail());
        customer.setPhoneNumber(request.getPhone());
        customerRepository.save(customer);
    }

    @Override
    public GetCustomerResponse getById(int id) {
        Customer customer = customerRepository.findById(id).orElseThrow();

        GetCustomerResponse dto = new GetCustomerResponse();
        dto.setEmail(customer.getEmail());
        dto.setPhone(customer.getPhoneNumber());
        dto.setFirstName(customer.getFirstName());
        dto.setLastName(customer.getLastName());
        return dto;
    }

    @Override
    public void update(int id, UpdateCustomerRequest request) {
        Customer customer = customerRepository.findById(id).orElseThrow();
        customer.setFirstName(request.getFirstName());
        customer.setLastName(request.getLastName());
        customer.setEmail(request.getEmail());
        customer.setPhoneNumber(request.getPhone());
        customerRepository.save(customer);
    }

    @Override
    public void delete(int id) {
        customerRepository.deleteById(id);
    }

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public List<GetCustomerResponse> findByNameStartingWith(String prefix) {
       List<Customer> customers = customerRepository.findByFirstNameStartingWith(prefix);
       List<GetCustomerResponse> responses = new ArrayList<>();
       for (Customer customer : customers){
           responses.add(new GetCustomerResponse
                   (customer.getFirstName(),customer.getLastName(),customer.getEmail(),customer.getPhoneNumber()));
       }
       return responses;
    }

    @Override
    public List<GetCustomerResponse> findByNameEndingWith(String suffix) {
        List<Customer> customers = customerRepository.findByLastNameEndingWith(suffix);
        List<GetCustomerResponse> responses = new ArrayList<>();
        for (Customer customer : customers){
            responses.add(new GetCustomerResponse
                    (customer.getFirstName(),customer.getLastName(),customer.getEmail(),customer.getPhoneNumber()));
        }
        return responses;
    }

    @Override
    public List<GetCustomerResponse> getPhoneNumberIsNotNull() {
        return customerRepository.getPhoneNumberIsNotNull();
    }

    @Override
    public List<GetCustomerResponse> search(String firstName) {
        return customerRepository.search(firstName);
    }
}
