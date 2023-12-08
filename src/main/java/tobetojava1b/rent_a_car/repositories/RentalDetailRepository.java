package tobetojava1b.rent_a_car.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tobetojava1b.rent_a_car.entities.RentalDetail;
import tobetojava1b.rent_a_car.services.dtos.responses.rentalDetail.GetRentalDetailResponse;

import java.time.LocalDate;
import java.util.List;

public interface RentalDetailRepository extends JpaRepository<RentalDetail,Integer> {
    List<RentalDetail> findByTotalPriceLessThan(Integer price);
    List<RentalDetail> findByTotalPriceBetween(Integer startPrice,Integer endPrice);

    @Query("Select new tobetojava1b.rent_a_car.services.dtos.responses.rentalDetail." +
            "GetRentalDetailResponse(r.startDate,r.endDate,r.totalPrice,r.rentalStatus)" +
            "FROM RentalDetail r Where r.rentalStatus = :status")
    List<GetRentalDetailResponse> getActiveRental(Boolean status);
    @Query("Select new tobetojava1b.rent_a_car.services.dtos.responses.rentalDetail." +
            "GetRentalDetailResponse(r.startDate,r.endDate,r.totalPrice,r.rentalStatus) " +
            "FROM RentalDetail r Where r.endDate < :date")
    List<GetRentalDetailResponse> getRentalByOutOfDate(LocalDate date);


}

