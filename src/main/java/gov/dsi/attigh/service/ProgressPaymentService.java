package gov.dsi.attigh.service;


import gov.dsi.attigh.model.ProgressPayment;
import gov.dsi.attigh.repository.ProgressPaymentRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ProgressPaymentService {

    private final ProgressPaymentRepository progressPaymentRepository;

    public ProgressPaymentService(ProgressPaymentRepository progressPaymentRepository) {
        this.progressPaymentRepository = progressPaymentRepository;
    }

    public List<ProgressPayment> getAllProgressPayment() {
        return progressPaymentRepository.findAll();
    }

    public ProgressPayment getProgressPaymentById(Long id) {
        Optional<ProgressPayment> optionalExploration = progressPaymentRepository.findById(id);
        return optionalExploration.orElse(null);
    }

    public ProgressPayment createProgressPayment(ProgressPayment progressPayment) {
        return progressPaymentRepository.save(progressPayment);
    }

    public ProgressPayment updateExploration(Long id, ProgressPayment progressPayment) {
        Optional<ProgressPayment> optionalProgressPayment = progressPaymentRepository.findById(id);
        if (optionalProgressPayment.isPresent()) {
            ProgressPayment existingProgressPayment = optionalProgressPayment.get();
            existingProgressPayment.setProject(progressPayment.getProject());
            existingProgressPayment.setContractor(progressPayment.getContractor());
            existingProgressPayment.setProgressPaymentDate(progressPayment.getProgressPaymentDate());
            existingProgressPayment.setProgressPaymentNo(progressPayment.getProgressPaymentNo());
            existingProgressPayment.setSf(progressPayment.getSf());
            existingProgressPayment.setFf(progressPayment.getFf());
            existingProgressPayment.setKdv(progressPayment.getKdv());
            existingProgressPayment.setTotalPayment(progressPayment.getTotalPayment());
            existingProgressPayment.setSfKalan(progressPayment.getSfKalan());
            existingProgressPayment.setNakdiGerceklesme(progressPayment.getNakdiGerceklesme());
            existingProgressPayment.setWorkGroupEnum(progressPayment.getWorkGroupEnum());


            return progressPaymentRepository.save(progressPayment);
        } else {
            return null;
        }
    }

    public boolean deleteExploration(Long id) {
        Optional<ProgressPayment> optionalExploration = progressPaymentRepository.findById(id);
        if (optionalExploration.isPresent()) {
            progressPaymentRepository.delete(optionalExploration.get());
            return true;
        } else {
            return false;
        }
    }
}
