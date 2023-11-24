package tobetojava1b.rent_a_car.controllers;

import org.springframework.web.bind.annotation.*;
import tobetojava1b.rent_a_car.dtos.requests.model.AddModelRequest;
import tobetojava1b.rent_a_car.dtos.requests.model.UpdateModelRequest;
import tobetojava1b.rent_a_car.dtos.responses.model.GetModelResponse;
import tobetojava1b.rent_a_car.entities.Brand;
import tobetojava1b.rent_a_car.entities.Model;
import tobetojava1b.rent_a_car.repositories.BrandRepository;
import tobetojava1b.rent_a_car.repositories.ModelRepository;

import java.util.List;

@RestController
@RequestMapping("api/models")
public class ModelsController {

    private final ModelRepository modelRepository;
    private final BrandRepository brandRepository;

    public ModelsController(ModelRepository modelRepository,BrandRepository brandRepository) {
        this.modelRepository = modelRepository;
        this.brandRepository = brandRepository;
    }

    @GetMapping
    public List<Model> getAll() {
        return modelRepository.findAll();
    }

    @GetMapping("{id}")
    public GetModelResponse getById(@PathVariable int id) {
        GetModelResponse dto = new GetModelResponse();
        Model model = modelRepository.findById(id).orElseThrow();
        dto.setName(model.getName());
        dto.setYear(model.getModelYear());
        return dto;
    }

    @PostMapping
    public void add(@RequestBody AddModelRequest addModelRequest) {
        Model model = new Model();
        model.setBrand(brandRepository.findById(addModelRequest.getBrandId()).orElseThrow());
        model.setModelYear(addModelRequest.getModelYear());
        model.setName(addModelRequest.getName());
        modelRepository.save(model);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody UpdateModelRequest updateModelRequest) {
        Model model = modelRepository.findById(id).orElseThrow();
        model.setModelYear(updateModelRequest.getModelYear());
        model.setName(updateModelRequest.getName());
        model.setBrand(brandRepository.findById(updateModelRequest.getBrandId()).orElseThrow());
        modelRepository.save(model);
    }


    @DeleteMapping
    public void delete(@PathVariable int id) {
        modelRepository.deleteById(id);
    }

}
