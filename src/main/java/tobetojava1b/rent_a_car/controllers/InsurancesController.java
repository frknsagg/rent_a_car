package tobetojava1b.rent_a_car.controllers;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tobetojava1b.rent_a_car.services.abstracts.InsuranceService;
import tobetojava1b.rent_a_car.services.dtos.requests.insurance.AddInsuranceRequest;
import tobetojava1b.rent_a_car.services.dtos.requests.insurance.UpdateInsuranceRequest;
import tobetojava1b.rent_a_car.services.dtos.responses.insurance.GetInsuranceResponse;
import tobetojava1b.rent_a_car.entities.Insurance;
import tobetojava1b.rent_a_car.repositories.InsuranceRepository;

import java.util.List;

@RestController
@RequestMapping("api/insurances")
@AllArgsConstructor
public class InsurancesController {

    private final InsuranceService insuranceService;

    @GetMapping
    public List<Insurance> getAll() {
        return  insuranceService.getAll();

    }
    @GetMapping("{id}")
    public GetInsuranceResponse getById(@PathVariable int id){
      return insuranceService.getById(id);
    }
    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody UpdateInsuranceRequest updateInsuranceRequest) {
       insuranceService.update(id,updateInsuranceRequest);
    }

    @PostMapping
    public void add(@RequestBody AddInsuranceRequest addInsuranceRequest) {
        insuranceService.add(addInsuranceRequest);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        insuranceService.delete(id);
    }
}
