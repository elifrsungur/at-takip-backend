package gov.dsi.attigh.controller;


import gov.dsi.attigh.model.District;
import gov.dsi.attigh.service.DistrictService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/districts")
@CrossOrigin(origins = "*")
public class DistrictController {

    private final DistrictService districtService;

    public DistrictController(DistrictService districtService) {
        this.districtService = districtService;
    }

    @GetMapping
    public ResponseEntity<List<District>> getAllDistricts() {
        List<District> districts = districtService.getAllDistricts();
        return ResponseEntity.ok(districts);
    }

    @GetMapping("/{cityId}")
    public ResponseEntity<List<District>> getDistrictsByCityId(@PathVariable Long cityId) {
        List<District> districts = districtService.getDistrictsByCityId(cityId);
        return ResponseEntity.ok(districts);
    }
}