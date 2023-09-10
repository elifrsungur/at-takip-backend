package gov.dsi.attigh.controller;


import gov.dsi.attigh.model.Contractor;
import gov.dsi.attigh.model.ProgressPayment;
import gov.dsi.attigh.model.Project;
import gov.dsi.attigh.service.ContractorService;
import gov.dsi.attigh.service.ProgressPaymentService;
import gov.dsi.attigh.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/progress-payments")
public class ProgressPaymentController {

    private final ProgressPaymentService progressPaymentService;
    private final ProjectService projectService;
    private final ContractorService contractorService;

    public ProgressPaymentController(ProgressPaymentService progressPaymentService,
                                     ProjectService projectService,
                                     ContractorService contractorService) {
        this.progressPaymentService = progressPaymentService;
        this.projectService = projectService;
        this.contractorService = contractorService;
    }

    @GetMapping
    public ResponseEntity<List<ProgressPayment>> getAllProgressPayments() {
        List<ProgressPayment> progressPayments = progressPaymentService.getAllProgressPayment();
        return ResponseEntity.ok(progressPayments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProgressPayment> getProgressPaymentById(@PathVariable Long id) {
        ProgressPayment progressPayment = progressPaymentService.getProgressPaymentById(id);
        if (progressPayment != null) {
            return ResponseEntity.ok(progressPayment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<ProgressPayment> createProgressPayment(@RequestBody ProgressPayment progressPayment) {

        Project project = projectService.getProjectById(progressPayment.getProject().getId());
        Contractor contractor = contractorService.getContractorById(progressPayment.getContractor().getId());


        if (project != null && contractor != null) {
            progressPayment.setProject(project);
            progressPayment.setContractor(contractor);

            ProgressPayment createdProgressPayment = progressPaymentService.createProgressPayment(progressPayment);
            return new ResponseEntity<>(createdProgressPayment, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProgressPayment> updateProgressPayment(@PathVariable Long id, @RequestBody ProgressPayment progressPayment) {
        ProgressPayment updatedProgressPayment = progressPaymentService.updateExploration(id, progressPayment);
        if (updatedProgressPayment != null) {
            return ResponseEntity.ok(updatedProgressPayment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProgressPayment(@PathVariable Long id) {
        boolean deleted = progressPaymentService.deleteExploration(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
