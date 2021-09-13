package ua.goit.repositoty;

import ua.goit.model.Project;
import ua.goit.service.DbConnection;
import ua.goit.util.PropertiesLoader;

import java.sql.Connection;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class ProjectRepository implements ProjectRep {

    private final Connection CONNECTION = DbConnection.getInstance().getConnection();
    private final String SCHEMA_NAME = PropertiesLoader.getProperty("db.schemaName");

    @Override
    public Collection<Project> findAll() {
        return null;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public Optional<Project> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public Project create(Project project) {
        return null;
    }

    @Override
    public Project update(Long aLong, Project project) {
        return null;
    }

    @Override
    public List<String> getProjectsWithDate() {
        return null;
    }
}
