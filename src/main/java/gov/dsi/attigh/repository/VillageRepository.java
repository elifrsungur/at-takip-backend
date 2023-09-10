package gov.dsi.attigh.repository;

import gov.dsi.attigh.model.Village;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VillageRepository extends JpaRepository<Village, Long> {
}