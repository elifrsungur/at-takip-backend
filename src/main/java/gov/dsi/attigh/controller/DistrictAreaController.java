package gov.dsi.attigh.controller;


import gov.dsi.attigh.dto.DistrictAreaDto;
import gov.dsi.attigh.model.DistrictArea;
import gov.dsi.attigh.service.DistrictAreaService;
import org.springframework.aop.scope.ScopedProxyUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/districtAreas")
@CrossOrigin(origins = "*")
public class DistrictAreaController {

    private final DistrictAreaService districtAreaService;

    public DistrictAreaController(DistrictAreaService districtAreaService) {
        this.districtAreaService = districtAreaService;
    }

    @GetMapping
    public ResponseEntity<List<DistrictArea>> getAllProject(){
        List<DistrictArea> districtAreas = districtAreaService.getAllDistrictAreas();
        return ResponseEntity.ok(districtAreas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DistrictArea> getDistrictAreaById(@PathVariable Long id) {
        DistrictArea districtArea = districtAreaService.getDistrictAreaById(id);
        return ResponseEntity.ok(districtArea);
    }

    @PostMapping
    public ResponseEntity<List<DistrictArea>> createDistrictArea(@RequestBody DistrictAreaDto districtArea){
        List<DistrictArea> createdDistrictArea = districtAreaService.createDistrictArea(districtArea);
        //return ResponseEntity.status(HttpStatus.CREATED).body(createdDistrictArea);
        return  new ResponseEntity<>(createdDistrictArea, CREATED);
    }


}


