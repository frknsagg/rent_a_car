package tobetojava1b.rent_a_car.services.abstracts;

import tobetojava1b.rent_a_car.services.dtos.requests.brand.AddBrandRequest;
import tobetojava1b.rent_a_car.services.dtos.requests.brand.UpdateBrandRequest;
import tobetojava1b.rent_a_car.services.dtos.responses.brand.GetBrandResponse;

import java.util.List;

public interface BrandService {
    void add(AddBrandRequest addBrandRequest);

    GetBrandResponse getById(int id);

    void update(int id, UpdateBrandRequest request);

    void delete(int id);

    List<GetBrandResponse> getAll();
}
