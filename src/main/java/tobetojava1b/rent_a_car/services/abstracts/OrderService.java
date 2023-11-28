package tobetojava1b.rent_a_car.services.abstracts;

import tobetojava1b.rent_a_car.entities.Customer;
import tobetojava1b.rent_a_car.entities.Order;
import tobetojava1b.rent_a_car.services.dtos.requests.customer.AddCustomerRequest;
import tobetojava1b.rent_a_car.services.dtos.requests.customer.UpdateCustomerRequest;
import tobetojava1b.rent_a_car.services.dtos.requests.order.AddOrderRequest;
import tobetojava1b.rent_a_car.services.dtos.requests.order.UpdateOrderRequest;
import tobetojava1b.rent_a_car.services.dtos.responses.customer.GetCustomerResponse;
import tobetojava1b.rent_a_car.services.dtos.responses.order.GetOrderResponse;

import java.util.List;

public interface OrderService {
    void add(AddOrderRequest request);

    GetOrderResponse getById(int id);

    void update(int id, UpdateOrderRequest request);

    void delete(int id);

    List<Order> getAll();
}
