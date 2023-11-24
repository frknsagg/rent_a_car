package tobetojava1b.rent_a_car.controllers;


import org.springframework.web.bind.annotation.*;
import tobetojava1b.rent_a_car.dtos.requests.customer.AddCustomerRequest;
import tobetojava1b.rent_a_car.dtos.requests.customer.UpdateCustomerRequest;
import tobetojava1b.rent_a_car.dtos.responses.customer.GetCustomerResponse;
import tobetojava1b.rent_a_car.entities.Customer;
import tobetojava1b.rent_a_car.repositories.CustomerRepository;

import java.util.List;

@RestController
@RequestMapping("api/customers")
public class CustomersController {
    private final CustomerRepository customerRepository;

    public CustomersController(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @GetMapping
    public List<Customer> getAll(){
        return customerRepository.findAll();
    }
    @GetMapping("{id}")
    public GetCustomerResponse getById(@PathVariable int id){
        Customer customer = customerRepository.findById(id).orElseThrow();

        GetCustomerResponse dto = new GetCustomerResponse();
        dto.setEmail(customer.getEmail());
        dto.setPhone(customer.getPhoneNumber());
        dto.setFirstName(customer.getFirstName());
        dto.setLastName(customer.getLastName());
        return dto;
    }
    @PostMapping
    public void add(@RequestBody AddCustomerRequest addCustomerRequest){
        Customer customer = new Customer();
        customer.setFirstName(addCustomerRequest.getFirstName());
        customer.setLastName(addCustomerRequest.getLastName());
        customer.setEmail(addCustomerRequest.getEmail());
        customer.setPhoneNumber(addCustomerRequest.getPhone());
        customerRepository.save(customer);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id,@RequestBody UpdateCustomerRequest updateCustomerRequest){
        Customer customer = customerRepository.findById(id).orElseThrow();
        customer.setFirstName(updateCustomerRequest.getFirstName());
        customer.setLastName(updateCustomerRequest.getLastName());
        customer.setEmail(updateCustomerRequest.getEmail());
        customer.setPhoneNumber(updateCustomerRequest.getPhone());
        customerRepository.save(customer);

    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        customerRepository.deleteById(id);
    }
}
