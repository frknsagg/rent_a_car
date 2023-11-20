package tobetojava1b.rent_a_car.controllers;

import org.springframework.web.bind.annotation.*;
import tobetojava1b.rent_a_car.entities.Brand;
import tobetojava1b.rent_a_car.repositories.BrandRepository;

import java.util.List;

@RestController
@RequestMapping("api/brands")
public class BrandsController {

    private final BrandRepository brandRepository;

    public BrandsController(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @GetMapping
    public List<Brand> getAll() {
        return brandRepository.findAll();
    }

    @GetMapping("{id}")
    public Brand getById(@PathVariable int id) {
        return brandRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void save(@RequestBody Brand brand) {
        brandRepository.save(brand);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody Brand updatedBrand) {
        Brand brand = brandRepository.findById(id).orElseThrow();
        brand.setName(updatedBrand.getName());
        brandRepository.save(brand);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
      /*  Brand brandToDelete = brandRepository.findById(id).orElseThrow();
      // özel kontroller
        // kod buraya geliyor ise exception fırlamamıştır..
        brandRepository.delete(brandToDelete);*/

        brandRepository.deleteById(id);
    }
}
