package tobetojava1b.rent_a_car.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tobetojava1b.rent_a_car.entities.Order;
import tobetojava1b.rent_a_car.repositories.*;
import tobetojava1b.rent_a_car.services.abstracts.OrderService;
import tobetojava1b.rent_a_car.services.dtos.requests.order.AddOrderRequest;
import tobetojava1b.rent_a_car.services.dtos.requests.order.UpdateOrderRequest;
import tobetojava1b.rent_a_car.services.dtos.responses.order.GetOrderResponse;

import java.util.List;

@RestController
@RequestMapping("api/orders")
@AllArgsConstructor
public class OrdersController {

    private final OrderService orderService;
    @GetMapping
    public List<Order> getAll() {
        return orderService.getAll();
    }
    @GetMapping("{id}")
    public GetOrderResponse getById(@PathVariable int id) {
        return orderService.getById(id);
    }
    @PostMapping
    public void add(@RequestBody AddOrderRequest request) {
        orderService.add(request);
    }
    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody UpdateOrderRequest updatedOrder) {
        orderService.update(id, updatedOrder);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        orderService.delete(id);
    }
}
