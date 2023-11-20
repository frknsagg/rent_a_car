package tobetojava1b.rent_a_car.controllers;


import org.springframework.web.bind.annotation.*;
import tobetojava1b.rent_a_car.entities.Insurance;
import tobetojava1b.rent_a_car.repositories.InsuranceRepository;

import java.util.List;

@RestController
@RequestMapping("api/insurances")
public class InsurancesController {

    private final InsuranceRepository insuranceRepository;

    public InsurancesController(InsuranceRepository insuranceRepository) {
        this.insuranceRepository = insuranceRepository;
    }

    @GetMapping
    public List<Insurance> getAll() {
        return insuranceRepository.findAll();
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody Insurance updatedInsurance) {
        Insurance insurance = insuranceRepository.findById(id).orElseThrow();
        insurance.setCompanyName(updatedInsurance.getCompanyName());
        insurance.setStartDate(updatedInsurance.getStartDate());
        insurance.setEndDate(updatedInsurance.getEndDate());
        insurance.setPolicyNumber(updatedInsurance.getPolicyNumber());

        insuranceRepository.save(insurance);
    }

    @PostMapping
    public void save(@RequestBody Insurance insurance) {
        insuranceRepository.save(insurance);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        insuranceRepository.deleteById(id);
    }
}
