package tobetojava1b.rent_a_car.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tobetojava1b.rent_a_car.services.abstracts.CarService;
import tobetojava1b.rent_a_car.services.dtos.requests.car.AddCarRequest;
import tobetojava1b.rent_a_car.services.dtos.requests.car.UpdateCarRequest;
import tobetojava1b.rent_a_car.services.dtos.responses.car.GetCarResponse;
import tobetojava1b.rent_a_car.entities.Car;
import tobetojava1b.rent_a_car.repositories.CarRepository;
import tobetojava1b.rent_a_car.repositories.InsuranceRepository;
import tobetojava1b.rent_a_car.repositories.ModelRepository;

import java.util.List;

@RestController
@RequestMapping("api/cars")
@AllArgsConstructor
public class CarsController {

    private final CarRepository carRepository;
    private final InsuranceRepository insuranceRepository;
    private final ModelRepository modelRepository;
    private final CarService carService;


    @GetMapping
    public List<Car> getAll() {
        return carService.getAll();
    }
    @GetMapping("{id}")
    public GetCarResponse getById(@PathVariable int id) {
      return carService.getById(id);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody UpdateCarRequest updateCarRequest) {
        carService.update(id,updateCarRequest);
    }

    @PostMapping
    public void add(@RequestBody AddCarRequest addCarRequest) {
     carService.add(addCarRequest);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
       carService.delete(id);
    }
}
