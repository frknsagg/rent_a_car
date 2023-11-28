package tobetojava1b.rent_a_car.services.concretes;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tobetojava1b.rent_a_car.entities.Car;
import tobetojava1b.rent_a_car.repositories.CarRepository;
import tobetojava1b.rent_a_car.repositories.InsuranceRepository;
import tobetojava1b.rent_a_car.repositories.ModelRepository;
import tobetojava1b.rent_a_car.services.abstracts.CarService;
import tobetojava1b.rent_a_car.services.dtos.requests.car.AddCarRequest;
import tobetojava1b.rent_a_car.services.dtos.requests.car.UpdateCarRequest;
import tobetojava1b.rent_a_car.services.dtos.responses.car.GetCarResponse;

import java.util.List;

@AllArgsConstructor
@Service
public class CarManager implements CarService {
    private final CarRepository carRepository;
    private final InsuranceRepository insuranceRepository;
    private final ModelRepository modelRepository;
    @Override
    public void add(AddCarRequest request) {
        Car car = new Car();

        car.setInsurance(insuranceRepository.findById(request.getInsuranceId()).orElseThrow());
        car.setModel(modelRepository.findById(request.getModelId()).orElseThrow());
        carRepository.save(car);
    }

    @Override
    public GetCarResponse getById(int id) {
        Car car = carRepository.findById(id).orElseThrow();

        GetCarResponse dto = new GetCarResponse();
        dto.setInsuranceCompanyName(car.getInsurance().getCompanyName());
        dto.setInsuranceStartDate(car.getInsurance().getStartDate());
        dto.setModelName(car.getModel().getName());
        dto.setModelYear(car.getModel().getModelYear());

        return dto;
    }

    @Override
    public void update(int id, UpdateCarRequest request) {
        Car car = carRepository.findById(id).orElseThrow();
        car.setModel(modelRepository.findById(request.getModelId()).orElseThrow());
        car.setInsurance(insuranceRepository.findById(request.getInsuranceId()).orElseThrow());
        carRepository.save(car);
    }

    @Override
    public void delete(int id) {
        carRepository.deleteById(id);
    }

    @Override
    public List<Car> getAll() {
        return carRepository.findAll();
    }
}
