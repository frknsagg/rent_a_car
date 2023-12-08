package tobetojava1b.rent_a_car.controllers;


import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tobetojava1b.rent_a_car.services.abstracts.CustomerService;
import tobetojava1b.rent_a_car.services.dtos.requests.customer.AddCustomerRequest;
import tobetojava1b.rent_a_car.services.dtos.requests.customer.UpdateCustomerRequest;
import tobetojava1b.rent_a_car.services.dtos.responses.customer.GetCustomerResponse;
import tobetojava1b.rent_a_car.entities.Customer;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/customers")
public class CustomersController {
    private final CustomerService customerService;

    @GetMapping
    public List<Customer> getAll() {
        return customerService.getAll();
    }

    @GetMapping("{id}")
    public GetCustomerResponse getById(@PathVariable int id) {
        return customerService.getById(id);
    }

    @PostMapping
    public void add(@RequestBody @Valid AddCustomerRequest request) {
        customerService.add(request);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody UpdateCustomerRequest updateCustomerRequest) {
        customerService.update(id, updateCustomerRequest);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        customerService.delete(id);
    }
    @GetMapping("/getStartWithWord")
    public List<GetCustomerResponse> getCustomerStartsWith(@RequestParam String prefix){
        return customerService.findByNameStartingWith(prefix);
    }
    @GetMapping("/getEndingWithWord")
    public List<GetCustomerResponse> getCustomerEndingWith(@RequestParam String suffix){
        return customerService.findByNameEndingWith(suffix);
    }
    @GetMapping("/phoneNumberIsNotNull")
    public List<GetCustomerResponse> getPhoneNumberIsNotNull(){
        return customerService.getPhoneNumberIsNotNull();
    }
    @GetMapping("equalWithName")
    public List<GetCustomerResponse> search(@RequestParam String firstName){
        return customerService.search(firstName);
    }
}
