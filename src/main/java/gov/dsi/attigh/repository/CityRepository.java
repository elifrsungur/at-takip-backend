package gov.dsi.attigh.repository;

import gov.dsi.attigh.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {
}