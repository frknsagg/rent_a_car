package tobetojava1b.rent_a_car.services.concretes;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tobetojava1b.rent_a_car.entities.Model;
import tobetojava1b.rent_a_car.repositories.BrandRepository;
import tobetojava1b.rent_a_car.repositories.ModelRepository;
import tobetojava1b.rent_a_car.services.abstracts.ModelService;
import tobetojava1b.rent_a_car.services.dtos.requests.model.AddModelRequest;
import tobetojava1b.rent_a_car.services.dtos.requests.model.UpdateModelRequest;
import tobetojava1b.rent_a_car.services.dtos.responses.model.GetModelListResponse;
import tobetojava1b.rent_a_car.services.dtos.responses.model.GetModelResponse;

import java.util.List;

@AllArgsConstructor
@Service
public class ModelManager implements ModelService {

    private final ModelRepository modelRepository;
    private final BrandRepository brandRepository;
    @Override
    public void add(AddModelRequest request) {
        Model model = new Model();
        model.setBrand(brandRepository.findById(request.getBrandId()).orElseThrow());
        model.setModelYear(request.getModelYear());
        model.setName(request.getName());
        modelRepository.save(model);
    }

    @Override
    public GetModelResponse getById(int id) {
        GetModelResponse dto = new GetModelResponse();
        Model model = modelRepository.findById(id).orElseThrow();
        dto.setName(model.getName());
        dto.setYear(model.getModelYear());
        return dto;
    }

    @Override
    public void update(int id, UpdateModelRequest request) {
        Model model = modelRepository.findById(id).orElseThrow();
        model.setModelYear(request.getModelYear());
        model.setName(request.getName());
        model.setBrand(brandRepository.findById(request.getBrandId()).orElseThrow());
        modelRepository.save(model);
    }

    @Override
    public void delete(int id) {
        modelRepository.deleteById(id);
    }

    @Override
    public List<Model> getAll() {
        return modelRepository.findAll();
    }

    @Override
    public List<Model> getNameIsNot(String name) {
        return modelRepository.findByNameIsNot(name);
    }

    @Override
    public List<Model> findByNameStartingWith(String name) {
        return modelRepository.findByNameStartingWith(name);
    }

    @Override
    public List<GetModelListResponse> search(String name) {
        return modelRepository.search(name);
    }

    @Override
    public List<GetModelListResponse> findModelYearEquals(String year) {
        return modelRepository.findModelYearEquals(year);
    }
}
