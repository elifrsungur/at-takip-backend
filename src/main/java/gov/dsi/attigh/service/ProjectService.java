package gov.dsi.attigh.service;


import gov.dsi.attigh.exception.ProjectNotFoundException;
import gov.dsi.attigh.model.Project;
import gov.dsi.attigh.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Project getProjectById(Long id) {
        return projectRepository.findById(id)
                .orElseThrow(() -> new ProjectNotFoundException("Project not found with id: " + id));
    }

    public Project createProject(Project project) {
        return projectRepository.save(project);
    }


    public Project updateProject(Long id, Project project) {
        Project existingProject = getProjectById(id);

        existingProject.setProjectName(project.getProjectName());
        existingProject.setProjectCode(project.getProjectCode());
        existingProject.setContractPrice(project.getContractPrice());
        existingProject.setCityList(project.getCityList());
        existingProject.setVillageList(project.getVillageList());
        existingProject.setContractorList(project.getContractorList());
        existingProject.setTypeOfProjectEnum(project.getTypeOfProjectEnum());
        existingProject.setTypeOfApplicationEnum(project.getTypeOfApplicationEnum());
        existingProject.setTypeOfStageEnum(project.getTypeOfStageEnum());


        return projectRepository.save(existingProject);
    }

    public void deleteProject(Long id) {
        Project project = getProjectById(id);
        projectRepository.delete(project);
    }
}
