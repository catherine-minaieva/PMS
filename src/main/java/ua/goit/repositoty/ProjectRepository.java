package ua.goit.repositoty;

import ua.goit.model.Project;

import java.util.List;

public interface ProjectRepository extends BaseRepository<Project, Long> {
    List<String> getProjectsWithDate();
}
