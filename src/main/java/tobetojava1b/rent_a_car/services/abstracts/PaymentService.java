package tobetojava1b.rent_a_car.services.abstracts;

import tobetojava1b.rent_a_car.entities.Customer;
import tobetojava1b.rent_a_car.entities.Payment;
import tobetojava1b.rent_a_car.services.dtos.requests.customer.AddCustomerRequest;
import tobetojava1b.rent_a_car.services.dtos.requests.customer.UpdateCustomerRequest;
import tobetojava1b.rent_a_car.services.dtos.requests.payment.AddPaymentRequest;
import tobetojava1b.rent_a_car.services.dtos.requests.payment.UpdatePaymentRequest;
import tobetojava1b.rent_a_car.services.dtos.responses.customer.GetCustomerResponse;
import tobetojava1b.rent_a_car.services.dtos.responses.payment.GetPaymentResponse;

import java.util.List;

public interface PaymentService {
    void add(AddPaymentRequest request);

    GetPaymentResponse getById(int id);

    void update(int id, UpdatePaymentRequest request);

    void delete(int id);

    List<Payment> getAll();
}
