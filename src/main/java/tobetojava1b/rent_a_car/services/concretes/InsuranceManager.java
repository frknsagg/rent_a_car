package tobetojava1b.rent_a_car.services.concretes;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tobetojava1b.rent_a_car.entities.Insurance;
import tobetojava1b.rent_a_car.repositories.InsuranceRepository;
import tobetojava1b.rent_a_car.services.abstracts.InsuranceService;
import tobetojava1b.rent_a_car.services.dtos.requests.insurance.AddInsuranceRequest;
import tobetojava1b.rent_a_car.services.dtos.requests.insurance.UpdateInsuranceRequest;
import tobetojava1b.rent_a_car.services.dtos.responses.insurance.GetInsuranceResponse;

import java.util.List;

@AllArgsConstructor
@Service
public class InsuranceManager implements InsuranceService {
    private final InsuranceRepository insuranceRepository;
    @Override
    public void add(AddInsuranceRequest request) {
        Insurance insurance = new Insurance();
        insurance.setPolicyNumber(request.getPolicyNumber());
        insurance.setCompanyName(request.getCompanyName());
        insurance.setStartDate(request.getStartDate());
        insurance.setEndDate(request.getEndDate());

        insuranceRepository.save(insurance);
    }

    @Override
    public GetInsuranceResponse getById(int id) {
        Insurance insurance = insuranceRepository.findById(id).orElseThrow();
        GetInsuranceResponse dto = new GetInsuranceResponse();
        dto.setCompanyName(insurance.getCompanyName());
        dto.setPolicyNumber(insurance.getPolicyNumber());
        dto.setStartDate(insurance.getStartDate());
        dto.setEndDate(insurance.getEndDate());

        return dto;
    }

    @Override
    public void update(int id, UpdateInsuranceRequest request) {
        Insurance insurance = insuranceRepository.findById(id).orElseThrow();

        insurance.setCompanyName(request.getCompanyName());
        insurance.setStartDate(request.getStartDate());
        insurance.setEndDate(request.getEndDate());
        insurance.setPolicyNumber(request.getPolicyNumber());

        insuranceRepository.save(insurance);
    }

    @Override
    public void delete(int id) {
        insuranceRepository.deleteById(id);
    }

    @Override
    public List<Insurance> getAll() {
        return insuranceRepository.findAll();
    }
}
