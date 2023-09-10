package gov.dsi.attigh.repository;

import gov.dsi.attigh.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}