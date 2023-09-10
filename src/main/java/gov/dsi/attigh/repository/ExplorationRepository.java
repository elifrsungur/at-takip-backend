package gov.dsi.attigh.repository;

import gov.dsi.attigh.model.Exploration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExplorationRepository extends JpaRepository<Exploration, Long> {
}