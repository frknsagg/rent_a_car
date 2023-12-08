package tobetojava1b.rent_a_car.controllers;


import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tobetojava1b.rent_a_car.services.abstracts.PaymentService;
import tobetojava1b.rent_a_car.services.dtos.requests.payment.AddPaymentRequest;
import tobetojava1b.rent_a_car.services.dtos.requests.payment.UpdatePaymentRequest;
import tobetojava1b.rent_a_car.services.dtos.responses.payment.GetPaymentResponse;
import tobetojava1b.rent_a_car.entities.Payment;
import tobetojava1b.rent_a_car.repositories.PaymentRepository;

import java.util.List;

@RestController
@RequestMapping("api/payments")
@AllArgsConstructor
public class PaymentsController {
    private final PaymentService paymentService;

    @GetMapping
    public List<Payment> getAll(){
        return paymentService.getAll();
    }
    @GetMapping("{id}")
    public GetPaymentResponse getById(@PathVariable int id){
       return paymentService.getById(id);
    }

    @PostMapping
    public void add(@RequestBody @Valid AddPaymentRequest addPaymentRequest){
      paymentService.add(addPaymentRequest);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id,@RequestBody UpdatePaymentRequest updatePaymentRequest){
     paymentService.update(id,updatePaymentRequest);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        paymentService.delete(id);
    }


}
