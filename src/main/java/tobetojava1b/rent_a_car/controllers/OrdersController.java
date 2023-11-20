package tobetojava1b.rent_a_car.controllers;

import org.springframework.web.bind.annotation.*;
import tobetojava1b.rent_a_car.entities.Order;
import tobetojava1b.rent_a_car.repositories.OrderRepository;

import java.util.List;

@RestController
@RequestMapping("api/orders")
public class OrdersController {
    private final OrderRepository orderRepository;

    public OrdersController(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    @GetMapping
    public List<Order> getAll(){
        return orderRepository.findAll();
    }

    @PostMapping
    public void add(@RequestBody Order order){
        orderRepository.save(order);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody Order updatedOrder){
        Order order = orderRepository.findById(id).orElseThrow();

    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        orderRepository.deleteById(id);
    }
}
