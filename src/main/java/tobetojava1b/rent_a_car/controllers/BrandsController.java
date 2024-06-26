package tobetojava1b.rent_a_car.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tobetojava1b.rent_a_car.services.abstracts.BrandService;
import tobetojava1b.rent_a_car.services.dtos.requests.brand.AddBrandRequest;
import tobetojava1b.rent_a_car.services.dtos.requests.brand.UpdateBrandRequest;
import tobetojava1b.rent_a_car.services.dtos.responses.brand.GetBrandListResponse;
import tobetojava1b.rent_a_car.services.dtos.responses.brand.GetBrandResponse;
import tobetojava1b.rent_a_car.entities.Brand;
import tobetojava1b.rent_a_car.repositories.BrandRepository;

import java.util.List;

@RestController
@RequestMapping("api/brands")

public class BrandsController {

    private final BrandService brandService;

    public BrandsController(BrandService brandService) {
        this.brandService = brandService;
    }

    /*@GetMapping
        public List<GetBrandResponse> getAll(){
            return brandService.getAll();
        }*/
    @GetMapping("{id}")
    public GetBrandResponse getById(@PathVariable int id) {
        return this.brandService.getById(id);
    }
    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody @Valid AddBrandRequest request) {
        this.brandService.add(request);
    }
    @PutMapping("{id}")
    public void update(@PathVariable int id,@RequestBody UpdateBrandRequest request){
        this.brandService.update(id,request);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        this.brandService.delete(id);
    }

    @GetMapping()
    public List<GetBrandListResponse> getByName(@RequestParam String name,@RequestParam int id){
        return this.brandService.getByName(name,id);
    }
    @GetMapping("/getAll")
    public List<GetBrandListResponse> getAll(@RequestParam String name){
        return brandService.search3(name);
    }

}