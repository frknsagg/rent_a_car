package tobetojava1b.rent_a_car.services.concretes;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tobetojava1b.rent_a_car.entities.Customer;
import tobetojava1b.rent_a_car.entities.Payment;
import tobetojava1b.rent_a_car.repositories.PaymentRepository;
import tobetojava1b.rent_a_car.services.abstracts.PaymentService;
import tobetojava1b.rent_a_car.services.dtos.requests.customer.AddCustomerRequest;
import tobetojava1b.rent_a_car.services.dtos.requests.customer.UpdateCustomerRequest;
import tobetojava1b.rent_a_car.services.dtos.requests.payment.AddPaymentRequest;
import tobetojava1b.rent_a_car.services.dtos.requests.payment.UpdatePaymentRequest;
import tobetojava1b.rent_a_car.services.dtos.responses.customer.GetCustomerResponse;
import tobetojava1b.rent_a_car.services.dtos.responses.payment.GetPaymentResponse;

import java.util.List;

@AllArgsConstructor
@Service
public class PaymentManager implements PaymentService {
    private final PaymentRepository paymentRepository;


    @Override
    public void add(AddPaymentRequest request) {
        if (paymentRepository.existsByPaymentMethod(request.getPaymentMethod())){
            throw new RuntimeException("Aynı method bulunmaktadır.");
        }

        Payment payment = new Payment();
        payment.setPaymentMethod(request.getPaymentMethod());
        paymentRepository.save(payment);
    }

    @Override
    public GetPaymentResponse getById(int id) {
        Payment payment = paymentRepository.findById(id).orElseThrow();
        GetPaymentResponse dto = new GetPaymentResponse();
        dto.setPaymentMethod(payment.getPaymentMethod());
        return dto;
    }

    @Override
    public void update(int id, UpdatePaymentRequest request) {
        Payment payment = paymentRepository.findById(id).orElseThrow();

        payment.setPaymentMethod(request.getPaymentMethod());
        paymentRepository.save(payment);
    }

    @Override
    public void delete(int id) {
        paymentRepository.deleteById(id);
    }

    @Override
    public List<Payment> getAll() {
        return paymentRepository.findAll();
    }
}
