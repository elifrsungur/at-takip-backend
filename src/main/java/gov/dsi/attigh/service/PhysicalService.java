package gov.dsi.attigh.service;

import gov.dsi.attigh.model.Physical;
import gov.dsi.attigh.repository.PhysicalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhysicalService {

    private final PhysicalRepository physicalRepository;

    public PhysicalService(PhysicalRepository physicalRepository) {
        this.physicalRepository = physicalRepository;
    }

    public List<Physical> getAllPhysicals() {
        return physicalRepository.findAll();
    }

    public Physical getPhysicalById(Long id) {
        Optional<Physical> optionalPhysical = physicalRepository.findById(id);
        return optionalPhysical.orElse(null);
    }

    public Physical createPhysical(Physical physical) {
        return physicalRepository.save(physical);
    }

    public Physical updatePhysical(Long id, Physical physical) {
        Optional<Physical> optionalPhysical = physicalRepository.findById(id);
        if (optionalPhysical.isPresent()) {
            Physical existingPhysical = optionalPhysical.get();
            existingPhysical.setProject(physical.getProject());
            existingPhysical.setAlani(physical.getAlani());
            // Set other fields as needed
            // ...

            return physicalRepository.save(existingPhysical);
        } else {
            return null;
        }
    }

    public boolean deletePhysical(Long id) {
        Optional<Physical> optionalPhysical = physicalRepository.findById(id);
        if (optionalPhysical.isPresent()) {
            physicalRepository.delete(optionalPhysical.get());
            return true;
        } else {
            return false;
        }
    }
}
