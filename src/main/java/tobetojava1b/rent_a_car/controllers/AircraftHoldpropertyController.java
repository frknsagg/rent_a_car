package tobetojava1b.rent_a_car.controllers;


import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tobetojava1b.rent_a_car.entities.AircraftHoldProperty;
import tobetojava1b.rent_a_car.entities.AircraftHoldPropertyRegistration;
import tobetojava1b.rent_a_car.mapper.AircraftHoldPropertyMapper;
import tobetojava1b.rent_a_car.mapper.AircraftHoldPropertyRegistrationMapper;
import tobetojava1b.rent_a_car.services.abstracts.AircraftHoldPropertyRegistrationService;
import tobetojava1b.rent_a_car.services.abstracts.AircraftHoldPropertyService;
import tobetojava1b.rent_a_car.services.dtos.requests.holdproperty.AircraftHoldPropertyDTO;
import tobetojava1b.rent_a_car.services.dtos.requests.holdproperty.AircraftHoldPropertyRegistrationDTO;
import tobetojava1b.rent_a_car.services.dtos.responses.holdproperty.GetAircraftHoldProperyListDTO;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/aircraft-hold-properties")

public class AircraftHoldpropertyController {
    private final AircraftHoldPropertyService aircraftHoldPropertyService;
    private final AircraftHoldPropertyRegistrationService aircraftHoldPropertyRegistrationServiceService;
    private final AircraftHoldPropertyMapper aircraftHoldPropertyMapper;

    public AircraftHoldpropertyController(AircraftHoldPropertyService aircraftHoldPropertyService, AircraftHoldPropertyRegistrationService aircraftHoldPropertyRegistrationServiceService, AircraftHoldPropertyMapper aircraftHoldPropertyMapper) {
        this.aircraftHoldPropertyService = aircraftHoldPropertyService;
        this.aircraftHoldPropertyRegistrationServiceService = aircraftHoldPropertyRegistrationServiceService;
        this.aircraftHoldPropertyMapper = aircraftHoldPropertyMapper;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<AircraftHoldPropertyDTO>> getAll(){
        List<AircraftHoldProperty> propertyList = aircraftHoldPropertyService.findAll();

       List<AircraftHoldPropertyDTO> aircraftHoldProperyListDTOS= propertyList.stream()
               .map(AircraftHoldPropertyMapper.INSTANCE::toDto)
               .collect(Collectors.toList());
        return new ResponseEntity<>(aircraftHoldProperyListDTOS,HttpStatus.OK);
    }

    @GetMapping("/getAllReg")
    public ResponseEntity<List<AircraftHoldPropertyRegistrationDTO>> getAll2(){
        List<AircraftHoldPropertyRegistration> propertyList = aircraftHoldPropertyRegistrationServiceService.findAll();

        List<AircraftHoldPropertyRegistrationDTO> AircraftHoldPropertyRegistrationDTO= propertyList.stream()
                .map(AircraftHoldPropertyRegistrationMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
        return new ResponseEntity<>(AircraftHoldPropertyRegistrationDTO,HttpStatus.OK);
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
