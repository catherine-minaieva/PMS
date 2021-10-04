package ua.goit.repositoty;

import ua.goit.model.Developer;
import ua.goit.model.Project;

import java.util.List;

public interface QueryRepository {
    Double getSumOfSalariesForProject(Long id);
    List<Developer> getDevelopersOfProject(Long id);
    List<Developer> getDevelopersByLanguage(String language);
    List<Developer> getDevelopersByLevel(String level);

    List<Project> getProjectsWithDate();
}
