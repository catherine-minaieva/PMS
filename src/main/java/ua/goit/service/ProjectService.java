package ua.goit.service;

import ua.goit.View.InputString;
import ua.goit.model.Company;
import ua.goit.model.Project;
import ua.goit.repositoty.ProjectRepositoryImpl;
import java.util.Collection;
import java.util.List;

public class ProjectService implements BaseService<Project>{

    private final ProjectRepositoryImpl repository;

    public ProjectService(ProjectRepositoryImpl repository) {
        this.repository = repository;
    }

    @Override
    public Project findByID(Long id) {
        return null;
    }

    @Override
    public List<Project> findAll() {
        Collection<Project> all = repository.findAll();
        return (List<Project>) all;
    }

    @Override
    public void create(Project project) {
        repository.create(project);
    }


    @Override
    public void update(long ID, Project project) {
        repository.update(ID, project);
    }

    @Override
    public void delete(Long ID) {
        repository.deleteById(ID);
    }

    public Project mapProject(InputString input) {
        String[] parameters = input.getParameters();

        Long id  = Long.parseLong(parameters[1]);
        String name = parameters[2];
        String baseTechnology = parameters[3];
        String creationDate  = parameters[4];
        Long cost = Long.parseLong(parameters[5]);

        Project project = new Project();
        project.setId(id);
        project.setName(name);
        project.setBaseTechnology(baseTechnology);
        project.setCreationDate(creationDate);
        project.setCost(cost);

        return project;
    }
}
