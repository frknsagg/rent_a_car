package tobetojava1b.rent_a_car.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tobetojava1b.rent_a_car.entities.Car;
import tobetojava1b.rent_a_car.services.dtos.responses.car.GetCarListResponse;

import java.util.List;

public interface CarRepository extends JpaRepository<Car,Integer> {

    @Query("Select new tobetojava1b.rent_a_car.services.dtos.responses.car" +
            ".GetCarListResponse(c.id, new tobetojava1b.rent_a_car.services.dtos.responses.model.GetModelResponse(b.name,b.modelYear)) " +
            "from Car c INNER JOIN c.model b")
    List<GetCarListResponse> getAll();
}
