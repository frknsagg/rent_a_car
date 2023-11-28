package tobetojava1b.rent_a_car.services.concretes;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tobetojava1b.rent_a_car.entities.Order;
import tobetojava1b.rent_a_car.repositories.*;
import tobetojava1b.rent_a_car.services.abstracts.OrderService;
import tobetojava1b.rent_a_car.services.dtos.requests.order.AddOrderRequest;
import tobetojava1b.rent_a_car.services.dtos.requests.order.UpdateOrderRequest;
import tobetojava1b.rent_a_car.services.dtos.responses.order.GetOrderResponse;

import java.util.List;

@AllArgsConstructor
@Service
public class OrderManager implements OrderService {
    private final OrderRepository orderRepository;
    private final CarRepository carRepository;
    private final CustomerRepository customerRepository;
    private final PaymentRepository paymentRepository;
    private final RentalDetailRepository rentalDetailRepository;
    @Override
    public void add(AddOrderRequest request) {
        Order order = new Order();
        order.setCar(carRepository.findById(request.getCarId()).orElseThrow());
        order.setPayment(paymentRepository.findById(request.getPaymentId()).orElseThrow());
        order.setCustomer(customerRepository.findById(request.getCustomerId()).orElseThrow());
        order.setRentalDetail(rentalDetailRepository.findById(request.getRentalDetailId()).orElseThrow());
        orderRepository.save(order);
    }

    @Override
    public GetOrderResponse getById(int id) {
        GetOrderResponse dto = new GetOrderResponse();
        Order order = orderRepository.findById(id).orElseThrow();
        dto.setCarName(order.getCar().getModel().getName());
        dto.setCustomerName(order.getCustomer().getFirstName());
        dto.setPaymentMethod(order.getPayment().getPaymentMethod());

        return dto;
    }
    @Override
    public void update(int id, UpdateOrderRequest request) {
        Order order = orderRepository.findById(id).orElseThrow();
        order.setCar(carRepository.findById(request.getCarId()).orElseThrow());
        order.setCustomer(customerRepository.findById(request.getPaymentId()).orElseThrow());
        order.setPayment(paymentRepository.findById(request.getPaymentId()).orElseThrow());
        order.setRentalDetail(rentalDetailRepository.findById(request.getPaymentId()).orElseThrow());
    }
    @Override
    public void delete(int id) {
        orderRepository.deleteById(id);
    }
    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }
}
