package tobetojava1b.rent_a_car.controllers;

import org.springframework.web.bind.annotation.*;
import tobetojava1b.rent_a_car.entities.Order;
import tobetojava1b.rent_a_car.entities.RentalDetail;
import tobetojava1b.rent_a_car.repositories.OrderRepository;
import tobetojava1b.rent_a_car.repositories.RentalDetailRepository;

import java.util.List;

@RestController
@RequestMapping("api/rentaldetails")
public class RentalDetailsController {

    private final RentalDetailRepository rentalDetailRepository;

    public RentalDetailsController(RentalDetailRepository rentalDetailRepository){
        this.rentalDetailRepository = rentalDetailRepository;
    }

    @GetMapping
    public List<RentalDetail> getAll(){
        return rentalDetailRepository.findAll();
    }

    @PostMapping
    public void add(@RequestBody RentalDetail rentalDetail){
        rentalDetailRepository.save(rentalDetail);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody RentalDetail updatedRentailDetail){
        RentalDetail rentalDetail = rentalDetailRepository.findById(id).orElseThrow();

    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        rentalDetailRepository.deleteById(id);
    }
}
