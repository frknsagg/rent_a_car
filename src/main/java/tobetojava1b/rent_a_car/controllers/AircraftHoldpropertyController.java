package tobetojava1b.rent_a_car.controllers;


import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tobetojava1b.rent_a_car.entities.AircraftHoldProperty;
import tobetojava1b.rent_a_car.mapper.AircraftHoldPropertyMapper;
import tobetojava1b.rent_a_car.services.abstracts.AircraftHoldPropertyService;
import tobetojava1b.rent_a_car.services.dtos.requests.holdproperty.AircraftHoldPropertyDTO;
import tobetojava1b.rent_a_car.services.dtos.responses.holdproperty.GetAircraftHoldProperyListDTO;

import java.util.List;

@RestController
@RequestMapping("/aircraft-hold-properties")
@RequiredArgsConstructor
public class AircraftHoldpropertyController {
    private final AircraftHoldPropertyService aircraftHoldPropertyService;

//    public AircraftHoldpropertyController(AircraftHoldPropertyService aircraftHoldPropertyService, AircraftHoldPropertyMapper aircraftHoldPropertyMapper) {
//        this.aircraftHoldPropertyService = aircraftHoldPropertyService;
//        this.aircraftHoldPropertyMapper = aircraftHoldPropertyMapper;
//    }

    @GetMapping("/getAll")
    public ResponseEntity<List<GetAircraftHoldProperyListDTO>> getAll(){
        List<AircraftHoldProperty> propertyList = aircraftHoldPropertyService.findAll();
//        if(propertyList != null){
//            return new ResponseEntity<>(propertyList, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

//        List<GetAircraftHoldProperyListDTO> aircraftHoldProperyListDTOS= aircraftHoldPropertyMapper.toDTOs(propertyList);
//        return new ResponseEntity<>(aircraftHoldProperyListDTOS,HttpStatus.OK);
////        }
        return null;
    }

    @PostMapping("/add")
    public String save(@RequestBody @Valid AircraftHoldProperty dto){
         this.aircraftHoldPropertyService.save(dto);
         return "Success";
    }
    @PostMapping("/add2")
    public AircraftHoldPropertyDTO save(@RequestBody  AircraftHoldPropertyDTO dto){
        return aircraftHoldPropertyService.createAircraftHoldProperty(dto);
    }
    @GetMapping
    public List<AircraftHoldPropertyDTO> getAllAircraftHoldProperties() {
        return aircraftHoldPropertyService.getAllAircraftHoldProperties();
    }
}
