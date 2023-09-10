package gov.dsi.attigh.controller;


import gov.dsi.attigh.model.Contractor;
import gov.dsi.attigh.model.Exploration;
import gov.dsi.attigh.model.Project;
import gov.dsi.attigh.service.ContractorService;
import gov.dsi.attigh.service.ExplorationService;
import gov.dsi.attigh.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/explorations")
public class ExplorationController {

    private final ExplorationService explorationService;
    private final ProjectService projectService;
    private final ContractorService contractorService;


    public ExplorationController(ExplorationService explorationService,
                                 ProjectService projectService,
                                 ContractorService contractorService
                                 ) {
        this.explorationService = explorationService;
        this.projectService = projectService;
        this.contractorService = contractorService;
    }


    @GetMapping
    public ResponseEntity<List<Exploration>> getAllExplorations() {
        List<Exploration> explorations = explorationService.getAllExplorations();
        return ResponseEntity.ok(explorations);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Exploration> getExplorationById(@PathVariable Long id) {
        Exploration exploration = explorationService.getExplorationById(id);
        if (exploration != null) {
            return ResponseEntity.ok(exploration);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Exploration> createExploration(@RequestBody Exploration exploration) {

        Project project = projectService.getProjectById(exploration.getProject().getId());
        Contractor contractor = contractorService.getContractorById(exploration.getContractor().getId());



        if (project != null && contractor != null) {
            if(project.getContractPrice() == null){
                project.setContractPrice(0.0);
            }

            Double totalExplorationPrice = project.getContractPrice() + exploration.getExplorationPrice();
            project.setContractPrice(totalExplorationPrice);
            projectService.updateProject(project.getId(), project);

            exploration.setProject(project);
            exploration.setContractor(contractor);

            Exploration createdExploration = explorationService.createExploration(exploration);
            return new ResponseEntity<>(createdExploration, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<Exploration> updateExploration(@PathVariable Long id, @RequestBody Exploration exploration) {
        Exploration updatedExploration = explorationService.updateExploration(id, exploration);
        if (updatedExploration != null) {
            return ResponseEntity.ok(updatedExploration);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExploration(@PathVariable Long id) {
        boolean deleted = explorationService.deleteExploration(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
