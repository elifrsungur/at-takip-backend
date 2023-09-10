package gov.dsi.attigh.repository;

import gov.dsi.attigh.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
