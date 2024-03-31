package tobetojava1b.rent_a_car.services.concretes;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tobetojava1b.rent_a_car.core.utilities.mappers.ModelMapperService;
import tobetojava1b.rent_a_car.entities.Brand;
import tobetojava1b.rent_a_car.repositories.BrandRepository;
import tobetojava1b.rent_a_car.services.abstracts.BrandService;
import tobetojava1b.rent_a_car.services.dtos.requests.brand.AddBrandRequest;
import tobetojava1b.rent_a_car.services.dtos.requests.brand.UpdateBrandRequest;
import tobetojava1b.rent_a_car.services.dtos.responses.brand.GetBrandListResponse;
import tobetojava1b.rent_a_car.services.dtos.responses.brand.GetBrandResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class BrandManager implements BrandService {

    private final BrandRepository brandRepository;
    private final ModelMapperService modelMapperService;
    @Override
    public void add(AddBrandRequest addBrandRequest) {
       if (brandRepository.existsByName(addBrandRequest.getName().trim())){
           throw new RuntimeException("Aynı isimle iki marka eklenemez");
       }
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

        List<GetBrandResponse> brandResponses = brands.stream().
                map(brand -> this.modelMapperService.forResponse().map(brand,GetBrandResponse.class)).
                collect(Collectors.toList());
         return brandResponses;
    }

    @Override
    public List<GetBrandListResponse> getByName(String name,int id) {
        List<Brand> brands = brandRepository.findAllByNameLikeOrIdEquals("%"+name+"%",id);
        List<GetBrandListResponse> response = new ArrayList<>();

        for (Brand brand:brands){
            response.add(new GetBrandListResponse(brand.getName()));
        }
        return response;
    }

    @Override
    public List<GetBrandListResponse> search3(String name) {
        return brandRepository.search3(name);
    }
}
