package gov.dsi.attigh.service;


import gov.dsi.attigh.model.Contractor;
import gov.dsi.attigh.repository.ContractorRepository;
import gov.dsi.attigh.repository.ExplorationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContractorService {

    private final ContractorRepository contractorRepository;

    public ContractorService(ContractorRepository contractorRepository ) {
        this.contractorRepository = contractorRepository ;
    }

    public List<Contractor> getAllContractors() {
        return contractorRepository.findAll();
    }

    public Contractor getContractorById(Long id) {
        Optional<Contractor> contractor = contractorRepository.findById(id);
        return contractor.orElse(null);
    }

    public Contractor createContractor(Contractor contractor) {
        return contractorRepository.save(contractor);
    }


}
