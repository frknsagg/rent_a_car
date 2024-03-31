package tobetojava1b.rent_a_car.controllers;


import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tobetojava1b.rent_a_car.entities.AircraftHoldProperty;
import tobetojava1b.rent_a_car.services.abstracts.AircraftHoldPropertyService;

import java.util.List;

@RestController
@RequestMapping("/aircraft-hold-properties")
@AllArgsConstructor
public class AircraftHoldpropertyController {
    private AircraftHoldPropertyService aircraftHoldPropertyService;

    @GetMapping("/getAll")
    public List<AircraftHoldProperty> getAll(){
        List<AircraftHoldProperty> propertyList = aircraftHoldPropertyService.findAll();
//        if(propertyList != null){
//            return new ResponseEntity<>(propertyList, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return propertyList;
//        }
    }

    @PostMapping("/add")
    public String save(@RequestBody @Valid AircraftHoldProperty dto){
         this.aircraftHoldPropertyService.save(dto);
         return "Success";
    }
}
