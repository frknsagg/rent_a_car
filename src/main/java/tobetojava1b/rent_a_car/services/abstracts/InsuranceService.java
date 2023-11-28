package tobetojava1b.rent_a_car.services.abstracts;

import tobetojava1b.rent_a_car.entities.Customer;
import tobetojava1b.rent_a_car.entities.Insurance;
import tobetojava1b.rent_a_car.services.dtos.requests.customer.AddCustomerRequest;
import tobetojava1b.rent_a_car.services.dtos.requests.customer.UpdateCustomerRequest;
import tobetojava1b.rent_a_car.services.dtos.requests.insurance.AddInsuranceRequest;
import tobetojava1b.rent_a_car.services.dtos.requests.insurance.UpdateInsuranceRequest;
import tobetojava1b.rent_a_car.services.dtos.responses.customer.GetCustomerResponse;
import tobetojava1b.rent_a_car.services.dtos.responses.insurance.GetInsuranceResponse;

import java.util.List;

public interface InsuranceService {
    void add(AddInsuranceRequest request);

    GetInsuranceResponse getById(int id);

    void update(int id, UpdateInsuranceRequest request);

    void delete(int id);

    List<Insurance> getAll();
}
