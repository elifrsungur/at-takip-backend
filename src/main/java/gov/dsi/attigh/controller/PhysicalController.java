package gov.dsi.attigh.controller;

import gov.dsi.attigh.model.Physical;
import gov.dsi.attigh.model.Project;
import gov.dsi.attigh.service.PhysicalService;
import gov.dsi.attigh.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/physicals")
public class PhysicalController {

    private final PhysicalService physicalService;
    private final ProjectService projectService;

    public PhysicalController(PhysicalService physicalService, ProjectService projectService) {
        this.physicalService = physicalService;
        this.projectService = projectService;
    }

    @GetMapping
    public ResponseEntity<List<Physical>> getAllPhysicals() {
        List<Physical> physicals = physicalService.getAllPhysicals();
        return ResponseEntity.ok(physicals);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Physical> getPhysicalById(@PathVariable Long id) {
        Physical physical = physicalService.getPhysicalById(id);
        if (physical != null) {
            return ResponseEntity.ok(physical);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Physical> createPhysical(@RequestBody Physical physical) {


        Project project = projectService.getProjectById(physical.getProject().getId());

        if (project != null) {

            physical.setProject(project);

            Physical createdPhysical = physicalService.createPhysical(physical);
            return new ResponseEntity<>(createdPhysical, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Physical> updatePhysical(@PathVariable Long id, @RequestBody Physical physical) {
        Physical updatedPhysical = physicalService.updatePhysical(id, physical);
        if (updatedPhysical != null) {
            return ResponseEntity.ok(updatedPhysical);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePhysical(@PathVariable Long id) {
        boolean deleted = physicalService.deletePhysical(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
