package gov.dsi.attigh.controller;

import gov.dsi.attigh.model.Contractor;
import gov.dsi.attigh.service.ContractorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contractor")
public class ContractorController {

    private final ContractorService contractorService;

    public ContractorController(ContractorService contractorService) {
        this.contractorService = contractorService;
    }

    @GetMapping
    public ResponseEntity<List<Contractor>> getAllContractors() {
        List<Contractor> contractors = contractorService.getAllContractors();
        return ResponseEntity.ok(contractors);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contractor> getContractorById(@PathVariable Long id) {
        Contractor contractor = contractorService.getContractorById(id);
        if (contractor != null) {
            return ResponseEntity.ok(contractor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Contractor> createContractor(@RequestBody Contractor contractor) {
        Contractor createdContractor = contractorService.createContractor(contractor);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdContractor);
    }

}
