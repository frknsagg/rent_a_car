package tobetojava1b.rent_a_car.controllers;


import org.springframework.web.bind.annotation.*;
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
    @PostMapping
    public void add(@RequestBody Customer customer){
        customerRepository.save(customer);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id,@RequestBody Customer customer){

    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        customerRepository.deleteById(id);
    }
}
