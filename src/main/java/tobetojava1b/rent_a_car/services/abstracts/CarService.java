package tobetojava1b.rent_a_car.services.abstracts;

import tobetojava1b.rent_a_car.entities.Car;
import tobetojava1b.rent_a_car.services.dtos.requests.car.AddCarRequest;
import tobetojava1b.rent_a_car.services.dtos.requests.car.UpdateCarRequest;
import tobetojava1b.rent_a_car.services.dtos.responses.car.GetCarResponse;


import java.util.List;

public interface CarService {
    void add(AddCarRequest request);

    GetCarResponse getById(int id);

    void update(int id, UpdateCarRequest request);

    void delete(int id);

    List<Car> getAll();
}
