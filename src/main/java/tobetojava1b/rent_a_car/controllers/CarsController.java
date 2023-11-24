package tobetojava1b.rent_a_car.controllers;

import org.springframework.web.bind.annotation.*;
import tobetojava1b.rent_a_car.dtos.requests.car.AddCarRequest;
import tobetojava1b.rent_a_car.dtos.requests.car.UpdateCarRequest;
import tobetojava1b.rent_a_car.dtos.responses.car.GetCarResponse;
import tobetojava1b.rent_a_car.entities.Brand;
import tobetojava1b.rent_a_car.entities.Car;
import tobetojava1b.rent_a_car.entities.Model;
import tobetojava1b.rent_a_car.repositories.CarRepository;
import tobetojava1b.rent_a_car.repositories.InsuranceRepository;
import tobetojava1b.rent_a_car.repositories.ModelRepository;

import java.util.List;

@RestController
@RequestMapping("api/cars")
public class CarsController {

    private final CarRepository carRepository;
    private final InsuranceRepository insuranceRepository;
    private final ModelRepository modelRepository;

    public CarsController(CarRepository carRepository,InsuranceRepository insuranceRepository,ModelRepository modelRepository) {

        this.carRepository = carRepository;
        this.insuranceRepository=insuranceRepository;
        this.modelRepository=modelRepository;
    }

    @GetMapping
    public List<Car> getAll() {
        return carRepository.findAll();
    }
    @GetMapping("{id}")
    public GetCarResponse getById(@PathVariable int id) {
        Car car = carRepository.findById(id).orElseThrow();

        GetCarResponse dto = new GetCarResponse();
        dto.setInsuranceCompanyName(car.getInsurance().getCompanyName());
        dto.setInsuranceStartDate(car.getInsurance().getStartDate());
        dto.setModelName(car.getModel().getName());
        dto.setModelYear(car.getModel().getModelYear());

        return dto;
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody UpdateCarRequest updateCarRequest) {
        Car car = carRepository.findById(id).orElseThrow();
        car.setModel(modelRepository.findById(updateCarRequest.getModelId()).orElseThrow());
        car.setInsurance(insuranceRepository.findById(updateCarRequest.getInsuranceId()).orElseThrow());
        carRepository.save(car);
    }

    @PostMapping
    public void save(@RequestBody AddCarRequest addCarRequest) {
        Car car = new Car();

        car.setInsurance(insuranceRepository.findById(addCarRequest.getInsuranceId()).orElseThrow());
        car.setModel(modelRepository.findById(addCarRequest.getModelId()).orElseThrow());
        carRepository.save(car);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        carRepository.deleteById(id);
    }
}
