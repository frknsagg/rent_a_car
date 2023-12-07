package tobetojava1b.rent_a_car.services.concretes;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tobetojava1b.rent_a_car.entities.RentalDetail;
import tobetojava1b.rent_a_car.repositories.RentalDetailRepository;
import tobetojava1b.rent_a_car.services.abstracts.RentalDetailService;
import tobetojava1b.rent_a_car.services.dtos.requests.rentalDetail.AddRentalDetailRequest;
import tobetojava1b.rent_a_car.services.dtos.requests.rentalDetail.UpdateRentalDetailRequest;
import tobetojava1b.rent_a_car.services.dtos.responses.brand.GetBrandResponse;
import tobetojava1b.rent_a_car.services.dtos.responses.rentalDetail.GetRentalDetailResponse;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class RentalDetailManager implements RentalDetailService {
    private final RentalDetailRepository rentalDetailRepository;
    @Override
    public void add(AddRentalDetailRequest request) {
        RentalDetail rentalDetail = new RentalDetail();
        rentalDetail.setStartDate(request.getStartDate());
        rentalDetail.setEndDate(request.getEndDate());
        rentalDetail.setTotalPrice(request.getTotalPrice());
        rentalDetail.setRentalStatus(request.isRentalStatus());
        rentalDetailRepository.save(rentalDetail);
    }
    @Override
    public GetRentalDetailResponse getById(int id) {
        new RentalDetail();
        RentalDetail rentalDetail = rentalDetailRepository.findById(id).orElseThrow();
        GetRentalDetailResponse dto = new GetRentalDetailResponse();
      /*  dto.setStartDate(rentalDetail.getStartDate());
        dto.setEndDate(rentalDetail.getEndDate());
        dto.setTotalPrice(rentalDetail.getTotalPrice());
        dto.setStatus(rentalDetail.isRentalStatus());*/

        return dto;
    }
    @Override
    public void update(int id, UpdateRentalDetailRequest request) {
        RentalDetail rentalDetail = rentalDetailRepository.findById(id).orElseThrow();
        rentalDetail.setRentalStatus(request.isStatus());
        rentalDetail.setStartDate(request.getStartDate());
        rentalDetail.setEndDate(request.getEndDate());
        rentalDetail.setTotalPrice(request.getTotalPrice());
        rentalDetailRepository.save(rentalDetail);
    }

    @Override
    public void delete(int id) {
        rentalDetailRepository.deleteById(id);
    }

    @Override
    public List<RentalDetail> getAll() {
        return rentalDetailRepository.findAll();
    }

    @Override
    public List<RentalDetail> findByTotalPriceLessThan(Integer price) {
        return rentalDetailRepository.findByTotalPriceLessThan(price);
    }

    @Override
    public List<GetRentalDetailResponse> findByTotalPriceBetween(Integer startPrice, Integer endPrice) {
       List<RentalDetail> rentalDetails = rentalDetailRepository.findByTotalPriceBetween(startPrice,endPrice);
       List<GetRentalDetailResponse> responses = new ArrayList<>();
       for (RentalDetail rentalDetail : rentalDetails){
           responses.add(new GetRentalDetailResponse(rentalDetail.getStartDate(),rentalDetail.getEndDate(),rentalDetail.getTotalPrice(),rentalDetail.isRentalStatus()));
       }
        return responses;
    }

    @Override
    public List<GetRentalDetailResponse> search(Boolean status) {
        return rentalDetailRepository.getActiveRental(status);
    }

    @Override
    public List<GetRentalDetailResponse> getRentalByOutOfDate(LocalDate date) {

        return rentalDetailRepository.getRentalByOutOfDate(date);
    }


}
