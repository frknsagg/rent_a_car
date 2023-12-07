package tobetojava1b.rent_a_car.services.abstracts;

import org.springframework.data.jpa.repository.Query;
import tobetojava1b.rent_a_car.entities.Model;
import tobetojava1b.rent_a_car.services.dtos.requests.customer.AddCustomerRequest;
import tobetojava1b.rent_a_car.services.dtos.requests.customer.UpdateCustomerRequest;
import tobetojava1b.rent_a_car.services.dtos.requests.model.AddModelRequest;
import tobetojava1b.rent_a_car.services.dtos.requests.model.UpdateModelRequest;
import tobetojava1b.rent_a_car.services.dtos.responses.model.GetModelListResponse;
import tobetojava1b.rent_a_car.services.dtos.responses.model.GetModelResponse;

import java.util.List;

public interface ModelService {
    void add(AddModelRequest request);

    GetModelResponse getById(int id);

    void update(int id, UpdateModelRequest request);

    void delete(int id);

    List<Model> getAll();
    List<Model> getNameIsNot(String name);
    List<Model> findByNameStartingWith(String name);

   List<GetModelListResponse> search(String name);
   List<GetModelListResponse> findModelYearEquals(String year);
}
