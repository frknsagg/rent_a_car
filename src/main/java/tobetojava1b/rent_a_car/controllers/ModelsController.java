package tobetojava1b.rent_a_car.controllers;

import org.springframework.web.bind.annotation.*;
import tobetojava1b.rent_a_car.entities.Brand;
import tobetojava1b.rent_a_car.entities.Model;
import tobetojava1b.rent_a_car.repositories.ModelRepository;

import java.util.List;

@RestController
@RequestMapping("api/models")
public class ModelsController {

    private final ModelRepository modelRepository;

    public ModelsController(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    @GetMapping
    public List<Model> getAll() {
        return modelRepository.findAll();
    }

    @GetMapping("{id}")
    public Model getById(@PathVariable int id) {
        return modelRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Model model) {
        modelRepository.save(model);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody Model updatedModel) {
        Model model = modelRepository.findById(id).orElseThrow();
        model.setModelYear(updatedModel.getModelYear());
        model.setName(updatedModel.getName());
        model.setBrand(updatedModel.getBrand());
        modelRepository.save(model);
    }


    @DeleteMapping
    public void delete(@PathVariable int id) {
        modelRepository.deleteById(id);
    }

}
