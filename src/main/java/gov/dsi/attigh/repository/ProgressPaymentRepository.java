package gov.dsi.attigh.repository;

import gov.dsi.attigh.model.ProgressPayment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgressPaymentRepository extends JpaRepository<ProgressPayment, Long> {
}