package tobetojava1b.rent_a_car.controllers;


import org.springframework.web.bind.annotation.*;
import tobetojava1b.rent_a_car.entities.Payment;
import tobetojava1b.rent_a_car.repositories.PaymentRepository;

import java.util.List;

@RestController
@RequestMapping("api/payments")
public class PaymentsController {
    private final PaymentRepository paymentRepository;

    public PaymentsController(PaymentRepository paymentRepository){
        this.paymentRepository = paymentRepository;
    }

    @GetMapping
    public List<Payment> getAll(){
        return paymentRepository.findAll();
    }

    @PostMapping
    public void add(@RequestBody Payment payment){
        paymentRepository.save(payment);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id,@RequestBody Payment updatedPayment){
        Payment payment = paymentRepository.findById(id).orElseThrow();

        payment.setPaymentMethod(updatedPayment.getPaymentMethod());
        paymentRepository.save(payment);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        paymentRepository.deleteById(id);
    }


}
