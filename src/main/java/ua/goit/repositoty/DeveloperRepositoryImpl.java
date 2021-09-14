package ua.goit.repositoty;

import lombok.SneakyThrows;
import ua.goit.model.Developer;
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

public class DeveloperRepositoryImpl implements DeveloperRepositoty {

    private final Connection CONNECTION = DbConnection.getInstance().getConnection();
    private final String SCHEMA_NAME = PropertiesLoader.getProperty("db.schemaName");

    @SneakyThrows
    @Override
    public Collection<Developer> findAll() {
        final List<Developer> developersList = new ArrayList<>();
        ResultSet resultSet = CONNECTION.createStatement().executeQuery("SELECT * FROM developers");
        while (resultSet.next()) {
            Developer developer = buildDeveloper(resultSet);
            developersList.add(developer);
        }
        return developersList;
    }

    @SneakyThrows
    @Override
    public Optional<Developer> findById(Long id) {
        Developer developer = new Developer();
        PreparedStatement preparedStatement = CONNECTION.prepareStatement("SELECT * FROM " + SCHEMA_NAME + ".developers WHERE id=" + id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            developer = buildDeveloper(resultSet);
        }
        return Optional.ofNullable(developer);
    }

    private Developer buildDeveloper(ResultSet resultSet) throws SQLException {
        Developer developer;
        developer = Developer.builder()
                .id(resultSet.getLong("id"))
                .name(resultSet.getString("name"))
                .age(resultSet.getInt("age"))
                .gender(resultSet.getString("gender"))
                .salary(resultSet.getDouble("salary"))
                .build();
        return developer;
    }

    @SneakyThrows
    @Override
    public Developer create(Developer developer) {
        PreparedStatement preparedStatement = CONNECTION.prepareStatement("INSERT INTO " + SCHEMA_NAME + ".developers (name,age,gender,company_id,salary)" + " VALUES (?,?,?,?,?)");
        return updateDeveloper(developer, preparedStatement);
    }

        @SneakyThrows
    @Override
    public Developer update(Long id, Developer developer) {
        PreparedStatement preparedStatement = CONNECTION.prepareStatement("UPDATE " + SCHEMA_NAME + ".developers set name=?, age=?, gender=?,company_id=?, salary=? WHERE id=" + id + ";");
        return updateDeveloper(developer, preparedStatement);
    }

    private Developer updateDeveloper(Developer developer, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, developer.getName());
        preparedStatement.setInt(2, developer.getAge());
        preparedStatement.setString(3, developer.getGender());
        preparedStatement.setDouble(4, developer.getSalary());
        preparedStatement.executeUpdate();
        return developer;
    }

    @SneakyThrows
    @Override
    public void deleteById(Long id) {
        CONNECTION.prepareStatement("DELETE FROM " + SCHEMA_NAME + ".developers WHERE id=" + id).executeUpdate();
    }

    @SneakyThrows
    @Override
    public Double getSumOfSalariesForProject(Long projectId) {
        ResultSet resultSet = CONNECTION.createStatement().executeQuery("SELECT projects.id AS projectID, projects.name AS projectName, "
                + "SUM(developers.salary) AS sumSalary "
                + "FROM developers_projects "
                + "inner join developers on developers_projects.developer_id = developers.id "
                + "inner join projects on developers_projects.project_id = projects.id "
                + "GROUP BY projects.id");
        List<String> totalSalaries = new ArrayList<>();
        while (resultSet.next()) {
            totalSalaries.add((int) resultSet.getLong("projectID") - 1, (resultSet.getString("projectName") + " = " + resultSet.getDouble("sumSalaries")));
        }
        return Double.valueOf(totalSalaries.get(Math.toIntExact(projectId) - 1));
    }

    @SneakyThrows
    @Override
    public List<Developer> getDevelopersOfProject(Long projectId) {
        List<Developer> developersList = new ArrayList<>();
        PreparedStatement preparedStatement = CONNECTION.prepareStatement("SELECT * FROM " + SCHEMA_NAME + ".developers_projects "
                + "inner join " + SCHEMA_NAME + ".developers on " + SCHEMA_NAME + ".developers_projects.developer_id = " + SCHEMA_NAME + ".developers.id "
                + "inner join " + SCHEMA_NAME + ".projects on " + SCHEMA_NAME + ".developers_projects.project_id = " + SCHEMA_NAME + ".projects.id "
                + "WHERE " + SCHEMA_NAME + ".projects.id=?");
        preparedStatement.setLong(1, projectId);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Developer developer = buildDeveloper(resultSet);
            developersList.add(developer);
        }
        return developersList;
    }

    @SneakyThrows
    @Override
    public List<Developer> getDevelopersByLanguage(String language) {
        final List<Developer> developersList = new ArrayList<>();
        PreparedStatement preparedStatement = CONNECTION.prepareStatement("SELECT * FROM " + SCHEMA_NAME + ".developers_skills "
                + "inner join " + SCHEMA_NAME + ".developers on " + SCHEMA_NAME + ".developers_skills.developer_id = " + SCHEMA_NAME + ".developers.id "
                + "inner join " + SCHEMA_NAME + ".skills on " + SCHEMA_NAME + ".developers_skills.skills_id = " + SCHEMA_NAME + ".skills.id "
                + "WHERE " + SCHEMA_NAME + ".skills.language=?");
        preparedStatement.setString(1, language);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            final Developer developer = buildDeveloper(resultSet);
            developersList.add(developer);
        }
        return developersList;
    }

    @SneakyThrows
    @Override
    public List<Developer> getDevelopersByLevel(String level) {
        final List<Developer> developersList = new ArrayList<>();
        PreparedStatement preparedStatement = CONNECTION.prepareStatement("SELECT * FROM " + SCHEMA_NAME + ".developers_skills "
                + "inner join " + SCHEMA_NAME + ".developers on " + SCHEMA_NAME + ".developers_skills.developer_id = " + SCHEMA_NAME + ".developers.id "
                + "inner join " + SCHEMA_NAME + ".skills on " + SCHEMA_NAME + ".developers_skills.skills_id = " + SCHEMA_NAME + ".skills.id "
                + "WHERE " + SCHEMA_NAME + ".skills.level=?");
        preparedStatement.setString(1,level);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            final Developer developer = buildDeveloper(resultSet);
            developersList.add(developer);
        }
        return developersList;
    }
}
