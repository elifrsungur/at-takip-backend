package gov.dsi.attigh.repository;

import gov.dsi.attigh.model.District;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DistrictRepository extends JpaRepository<District, Long> {

    List<District> findByCityId(Long cityId);

}