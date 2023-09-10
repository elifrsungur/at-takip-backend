package gov.dsi.attigh.repository;

import gov.dsi.attigh.model.Physical;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhysicalRepository extends JpaRepository<Physical, Long> {
}