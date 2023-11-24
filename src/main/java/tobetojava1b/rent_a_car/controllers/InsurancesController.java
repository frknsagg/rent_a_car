package tobetojava1b.rent_a_car.controllers;


import org.springframework.web.bind.annotation.*;
import tobetojava1b.rent_a_car.dtos.requests.insurance.AddInsuranceRequest;
import tobetojava1b.rent_a_car.dtos.requests.insurance.UpdateInsuranceRequest;
import tobetojava1b.rent_a_car.dtos.responses.insurance.GetInsuranceResponse;
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
        return  insuranceRepository.findAll();

    }
    @GetMapping("{id}")
    public GetInsuranceResponse getById(@PathVariable int id){
        Insurance insurance = insuranceRepository.findById(id).orElseThrow();
        GetInsuranceResponse dto = new GetInsuranceResponse();
        dto.setCompanyName(insurance.getCompanyName());
        dto.setPolicyNumber(insurance.getPolicyNumber());
        dto.setStartDate(insurance.getStartDate());
        dto.setEndDate(insurance.getEndDate());

        return dto;
    }
    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody UpdateInsuranceRequest updateInsuranceRequest) {
        Insurance insurance = insuranceRepository.findById(id).orElseThrow();

        insurance.setCompanyName(updateInsuranceRequest.getCompanyName());
        insurance.setStartDate(updateInsuranceRequest.getStartDate());
        insurance.setEndDate(updateInsuranceRequest.getEndDate());
        insurance.setPolicyNumber(updateInsuranceRequest.getPolicyNumber());

        insuranceRepository.save(insurance);
    }

    @PostMapping
    public void save(@RequestBody AddInsuranceRequest addInsuranceRequest) {
        Insurance insurance = new Insurance();
        insurance.setPolicyNumber(addInsuranceRequest.getPolicyNumber());
        insurance.setCompanyName(addInsuranceRequest.getCompanyName());
        insurance.setStartDate(addInsuranceRequest.getStartDate());
        insurance.setEndDate(addInsuranceRequest.getEndDate());

        insuranceRepository.save(insurance);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        insuranceRepository.deleteById(id);
    }
}
