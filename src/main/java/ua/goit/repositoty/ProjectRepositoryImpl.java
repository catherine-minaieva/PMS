package ua.goit.repositoty;

import lombok.SneakyThrows;
import ua.goit.model.Project;
import ua.goit.service.DbConnection;
import ua.goit.util.PropertiesLoader;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class ProjectRepositoryImpl implements ProjectRepository {

    private final Connection CONNECTION = DbConnection.getInstance().getConnection();
    private final String SCHEMA_NAME = PropertiesLoader.getProperty("db.schemaName");

    @SneakyThrows
    @Override
    public Collection<Project> findAll() {
        final List<Project> projectList = new ArrayList<>();
        ResultSet resultSet = CONNECTION.createStatement().executeQuery("SELECT * FROM projects");
        while (resultSet.next()) {
            final Project project = buildProject(resultSet);
            projectList.add(project);
        }
        return projectList;
    }

    @SneakyThrows
    @Override
    public Optional<Project> findById(Long id) {

        Project project = new Project();
        ResultSet resultSet = CONNECTION.createStatement().executeQuery("SELECT * FROM projects WHERE id=" + id + ";");
        while (resultSet.next()) {
            project = buildProject(resultSet);
        }
        return Optional.ofNullable(project);
    }

    private Project buildProject(ResultSet resultSet) throws SQLException {
        final Project project = Project.builder()
                .id(resultSet.getLong("id"))
                .name(resultSet.getString("name"))
                .baseTechnology(resultSet.getString("base_technology"))
                .creationDate(resultSet.getString("creation_date"))
                .cost(resultSet.getLong("cost"))
                .build();
        return project;
    }

    @SneakyThrows
    @Override
    public Project create(Project project) {
        PreparedStatement preparedStatement = CONNECTION.prepareStatement("INSERT INTO " + SCHEMA_NAME + ".projects (name,cost,company_id,customer_id,first_date)" + " VALUES (?,?,?,?,?)");
        return getProject(project, preparedStatement);
    }

    @SneakyThrows
    @Override
    public Project update(Long id, Project project) {
        PreparedStatement preparedStatement = CONNECTION.prepareStatement("UPDATE " + SCHEMA_NAME + ".projects set name=?,cost=?,company_id=?,customer_id=?,first_date=?  WHERE id=" + id + ";");
        return getProject(project, preparedStatement);
    }

    private Project getProject(Project project, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, project.getName());
        preparedStatement.setString(2, project.getBaseTechnology());
        preparedStatement.setString(3, project.getCreationDate());
        preparedStatement.setLong(4, project.getCost());
        preparedStatement.executeUpdate();
        return project;
    }

    @SneakyThrows
    @Override
    public void deleteById(Long id) {
        CONNECTION.createStatement().execute("DELETE FROM " + SCHEMA_NAME + ".projects WHERE id=" + id);
    }

    @Override
    public List<String> getProjectsWithDate() {
//        Collection<Project> all = new ProjectRepository().findAll();
//        final List<String> projectsWithDate = new ArrayList<>();
//        for (int i = 1; i <= all.size(); i++) {
//            final String name = all.get(i - 1).getName();
//            final String date = all.get(i - 1).getCreationDate();
//            final long size = new DeveloperRepository().getDevelopersOfProject((long) i).size();
//            projectsWithDate.add(name + ", " + size + ", " + date);
//        }
       return null;
   }
}