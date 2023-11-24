package tobetojava1b.rent_a_car.controllers;


import org.springframework.web.bind.annotation.*;
import tobetojava1b.rent_a_car.dtos.requests.payment.AddPaymentRequest;
import tobetojava1b.rent_a_car.dtos.requests.payment.UpdatePaymentRequest;
import tobetojava1b.rent_a_car.dtos.responses.payment.GetPaymentResponse;
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
    @GetMapping("{id}")
    public GetPaymentResponse getById(@PathVariable int id){
        Payment payment = paymentRepository.findById(id).orElseThrow();
        GetPaymentResponse dto = new GetPaymentResponse();
        dto.setPaymentMethod(payment.getPaymentMethod());
        return dto;
    }

    @PostMapping
    public void add(@RequestBody AddPaymentRequest addPaymentRequest){
        Payment payment = new Payment();
        payment.setPaymentMethod(addPaymentRequest.getPaymentMethod());
        paymentRepository.save(payment);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id,@RequestBody UpdatePaymentRequest updatePaymentRequest){
        Payment payment = paymentRepository.findById(id).orElseThrow();

        payment.setPaymentMethod(updatePaymentRequest.getPaymentMethod());
        paymentRepository.save(payment);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        paymentRepository.deleteById(id);
    }


}
