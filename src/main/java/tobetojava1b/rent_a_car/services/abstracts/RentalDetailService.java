package tobetojava1b.rent_a_car.services.abstracts;

import tobetojava1b.rent_a_car.entities.Customer;
import tobetojava1b.rent_a_car.entities.RentalDetail;
import tobetojava1b.rent_a_car.services.dtos.requests.customer.AddCustomerRequest;
import tobetojava1b.rent_a_car.services.dtos.requests.customer.UpdateCustomerRequest;
import tobetojava1b.rent_a_car.services.dtos.requests.rentalDetail.AddRentalDetailRequest;
import tobetojava1b.rent_a_car.services.dtos.requests.rentalDetail.UpdateRentalDetailRequest;
import tobetojava1b.rent_a_car.services.dtos.responses.customer.GetCustomerResponse;
import tobetojava1b.rent_a_car.services.dtos.responses.rentalDetail.GetRentalDetailResponse;

import java.util.List;

public interface RentalDetailService {
    void add(AddRentalDetailRequest request);

    GetRentalDetailResponse getById(int id);

    void update(int id, UpdateRentalDetailRequest request);

    void delete(int id);

    List<RentalDetail> getAll();
}
