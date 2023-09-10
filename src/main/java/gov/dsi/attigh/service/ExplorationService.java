package gov.dsi.attigh.service;

import gov.dsi.attigh.model.Exploration;
import gov.dsi.attigh.repository.ExplorationRepository;
import gov.dsi.attigh.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExplorationService {

    private final ExplorationRepository explorationRepository;

    public ExplorationService(ExplorationRepository explorationRepository) {
        this.explorationRepository = explorationRepository;
    }

    public List<Exploration> getAllExplorations() {
        return explorationRepository.findAll();
    }

    public Exploration getExplorationById(Long id) {
        Optional<Exploration> optionalExploration = explorationRepository.findById(id);
        return optionalExploration.orElse(null);
    }

    public Exploration createExploration(Exploration exploration) {
        return explorationRepository.save(exploration);
    }

    public Exploration updateExploration(Long id, Exploration exploration) {
        Optional<Exploration> optionalExploration = explorationRepository.findById(id);
        if (optionalExploration.isPresent()) {
            Exploration existingExploration = optionalExploration.get();
            existingExploration.setProject(exploration.getProject());
            existingExploration.setContractor(exploration.getContractor());
            existingExploration.setExplorationDate(exploration.getExplorationDate());
            existingExploration.setWorkGroupEnum(exploration.getWorkGroupEnum());
            existingExploration.setExplorationPrice(exploration.getExplorationPrice());

            return explorationRepository.save(existingExploration);
        } else {
            return null;
        }
    }

    public boolean deleteExploration(Long id) {
        Optional<Exploration> optionalExploration = explorationRepository.findById(id);
        if (optionalExploration.isPresent()) {
            explorationRepository.delete(optionalExploration.get());
            return true;
        } else {
            return false;
        }
    }
}
