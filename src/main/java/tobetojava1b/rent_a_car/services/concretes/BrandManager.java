package tobetojava1b.rent_a_car.services.concretes;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tobetojava1b.rent_a_car.entities.Brand;
import tobetojava1b.rent_a_car.repositories.BrandRepository;
import tobetojava1b.rent_a_car.services.abstracts.BrandService;
import tobetojava1b.rent_a_car.services.dtos.requests.brand.AddBrandRequest;
import tobetojava1b.rent_a_car.services.dtos.requests.brand.UpdateBrandRequest;
import tobetojava1b.rent_a_car.services.dtos.responses.brand.GetBrandListResponse;
import tobetojava1b.rent_a_car.services.dtos.responses.brand.GetBrandResponse;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class BrandManager implements BrandService {

    private final BrandRepository brandRepository;
    @Override
    public void add(AddBrandRequest addBrandRequest) {
        //Manual Mapping => Auto Mapping
        Brand brand = new Brand();
        brand.setName(addBrandRequest.getName());
        brandRepository.save(brand);
    }

    @Override
    public GetBrandResponse getById(int id) {
        Brand brand = brandRepository.findById(id).orElseThrow();

        GetBrandResponse dto = new GetBrandResponse();
        dto.setName(brand.getName());

        return dto;
    }

    @Override
    public void update(int id, UpdateBrandRequest request) {
        Brand brand = brandRepository.findById(id).orElseThrow();
        brand.setName(request.getName());
        brandRepository.save(brand);
    }

    @Override
    public void delete(int id) {
        brandRepository.deleteById(id);
    }

    @Override
    public List<GetBrandResponse> getAll() {
       List<Brand> brands = brandRepository.findAll();
       List<GetBrandResponse> getBrandListResponseList = new ArrayList<>();
        for (int i = 0; i < brands.size(); i++) {
            GetBrandResponse getBrandResponse = new GetBrandResponse();
            getBrandResponse.setName(brands.get(i).getName());


             getBrandListResponseList.add(getBrandResponse);
        }
         return getBrandListResponseList;
    }
}
