package tobetojava1b.rent_a_car.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tobetojava1b.rent_a_car.services.abstracts.ModelService;
import tobetojava1b.rent_a_car.services.dtos.requests.model.AddModelRequest;
import tobetojava1b.rent_a_car.services.dtos.requests.model.UpdateModelRequest;
import tobetojava1b.rent_a_car.services.dtos.responses.model.GetModelListResponse;
import tobetojava1b.rent_a_car.services.dtos.responses.model.GetModelResponse;
import tobetojava1b.rent_a_car.entities.Model;
import tobetojava1b.rent_a_car.repositories.BrandRepository;
import tobetojava1b.rent_a_car.repositories.ModelRepository;

import java.util.List;

@RestController
@RequestMapping("api/models")
@AllArgsConstructor
public class ModelsController {

    private final ModelService modelService;

    @GetMapping
    public List<Model> getAll() {
        return modelService.getAll();
    }

    @GetMapping("{id}")
    public GetModelResponse getById(@PathVariable int id) {
       return modelService.getById(id);
    }

    @PostMapping
    public void add(@RequestBody AddModelRequest addModelRequest) {
     modelService.add(addModelRequest);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody UpdateModelRequest updateModelRequest) {
      modelService.update(id,updateModelRequest);
    }


    @DeleteMapping
    public void delete(@PathVariable int id) {
        modelService.delete(id);
    }

    @GetMapping("/getName")
    public List<Model> getNameIsNot(@RequestParam String name){
        return modelService.getNameIsNot(name);
    }

    @GetMapping("/getName2")
    public List<Model> findByNameStartingWith(@RequestParam String name)
    {
        return modelService.findByNameStartingWith(name);
    }
    @GetMapping("/search")
    public List<GetModelListResponse> search(@RequestParam String name){
        return this.modelService.search(name);
    }
    @GetMapping("/getYearEquals")
    public List<GetModelListResponse> getModelYearEquals(@RequestParam String year)
    {
        return modelService.findModelYearEquals(year);
    }

}
