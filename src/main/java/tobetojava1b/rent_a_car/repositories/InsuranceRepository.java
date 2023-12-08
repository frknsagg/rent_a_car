package tobetojava1b.rent_a_car.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tobetojava1b.rent_a_car.entities.Insurance;
import tobetojava1b.rent_a_car.services.dtos.responses.insurance.GetInsuranceResponse;
import tobetojava1b.rent_a_car.services.dtos.responses.rentalDetail.GetRentalDetailResponse;

import java.time.LocalDate;
import java.util.List;

public interface InsuranceRepository extends JpaRepository<Insurance,Integer> {
    List<Insurance> findByCompanyNameLike(String name);
    List<Insurance> findByStartDateAfter(LocalDate date);

    @Query("Select new tobetojava1b.rent_a_car.services.dtos.responses.insurance." +
            "GetInsuranceResponse(i.companyName,i.startDate,i.endDate,i.policyNumber)" +
            "FROM Insurance i WHERE i.policyNumber = :policyNumber")
    List<GetInsuranceResponse> getAllPolicyNumber(String policyNumber);

    @Query("Select new tobetojava1b.rent_a_car.services.dtos.responses.insurance." +
            "GetInsuranceResponse(i.companyName,i.startDate,i.endDate,i.policyNumber) " +
            "FROM Insurance i Where i.endDate < :date")
    List<GetInsuranceResponse> getRentalByOutOfDate(LocalDate date);

    boolean existsByPolicyNumber(String policyNumber);
}
