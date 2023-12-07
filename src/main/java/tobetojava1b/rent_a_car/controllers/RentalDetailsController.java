package tobetojava1b.rent_a_car.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tobetojava1b.rent_a_car.entities.Order;
import tobetojava1b.rent_a_car.entities.RentalDetail;
import tobetojava1b.rent_a_car.repositories.OrderRepository;
import tobetojava1b.rent_a_car.repositories.RentalDetailRepository;
import tobetojava1b.rent_a_car.services.abstracts.RentalDetailService;
import tobetojava1b.rent_a_car.services.dtos.requests.rentalDetail.AddRentalDetailRequest;
import tobetojava1b.rent_a_car.services.dtos.requests.rentalDetail.UpdateRentalDetailRequest;
import tobetojava1b.rent_a_car.services.dtos.responses.rentalDetail.GetRentalDetailResponse;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/rentaldetails")
@AllArgsConstructor
public class RentalDetailsController {

    private final RentalDetailService rentalDetailService;

    @GetMapping
    public List<RentalDetail> getAll(){
        return rentalDetailService.getAll();
    }
    @GetMapping("{id}")
    public GetRentalDetailResponse getById(@PathVariable int id){
        return rentalDetailService.getById(id);
    }

    @PostMapping
    public void add(@RequestBody AddRentalDetailRequest request){
        rentalDetailService.add(request);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody UpdateRentalDetailRequest request){
       rentalDetailService.update(id,request);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        rentalDetailService.delete(id);
    }
    @GetMapping("/getLessPrice")
    public List<RentalDetail> getRentalDetailLessThan(@RequestParam Integer price){
        return rentalDetailService.findByTotalPriceLessThan(price);
    }
    @GetMapping("/getPriceBetween")
    public List<GetRentalDetailResponse> getRentalDetailBetweenPrice(@RequestParam Integer startPrice,@RequestParam Integer endPrice)
    {
        return rentalDetailService.findByTotalPriceBetween(startPrice,endPrice);
    }
    @GetMapping("/search")
    public List<GetRentalDetailResponse> search(@RequestParam Boolean status){
        return rentalDetailService.search(status);
    }
    @GetMapping("/getOutOfDate")
    public List<GetRentalDetailResponse> getOutOfDate(@RequestParam LocalDate date)
    {
        return rentalDetailService.getRentalByOutOfDate(date);
    }


}
