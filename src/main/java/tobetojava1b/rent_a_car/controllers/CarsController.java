package tobetojava1b.rent_a_car.controllers;

import org.springframework.web.bind.annotation.*;
import tobetojava1b.rent_a_car.entities.Car;
import tobetojava1b.rent_a_car.repositories.CarRepository;

import java.util.List;

@RestController
@RequestMapping("api/cars")
public class CarsController {

    private final CarRepository carRepository;

    public CarsController(CarRepository carRepository) {

        this.carRepository = carRepository;
    }

    @GetMapping
    public List<Car> getAll() {
        return carRepository.findAll();
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody Car updatedCar) {
        Car car = carRepository.findById(id).orElseThrow();
        car.setModel(updatedCar.getModel());
        car.setInsurance(updatedCar.getInsurance());
        carRepository.save(car);
    }

    @PostMapping
    public void save(@RequestBody Car car) {
        carRepository.save(car);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        carRepository.deleteById(id);
    }
}
