package gov.dsi.attigh.repository;

import gov.dsi.attigh.model.Contractor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractorRepository extends JpaRepository<Contractor, Long> {
}