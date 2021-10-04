package ua.goit.repositoty;

import lombok.SneakyThrows;
import ua.goit.model.Developer;
import ua.goit.model.Project;
import ua.goit.service.DbConnection;
import ua.goit.util.PropertiesLoader;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QueryRepositotyImpl implements QueryRepository{

    private final Connection CONNECTION = DbConnection.getInstance().getConnection();
    private final String SCHEMA_NAME = PropertiesLoader.getProperty("db.schemaName");

    @SneakyThrows
    @Override
    public Double getSumOfSalariesForProject(Long projectId) {
        ResultSet resultSet = CONNECTION.createStatement().executeQuery( "SELECT projects.name, sum(salary) as salary " +
                " FROM "+SCHEMA_NAME+".developers " +
                        " INNER JOIN "+SCHEMA_NAME+".developers_projects " +
                        " ON developers_projects.developer_id = developers.id " +
                        " INNER JOIN "+SCHEMA_NAME+".projects " +
                        " ON developers_projects.project_id = projects.id " +
                        " WHERE projects.id=?" +
                        " GROUP BY projects.name"
        );
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
        PreparedStatement preparedStatement = CONNECTION.prepareStatement("SELECT" +
                " developers.name" +
                " FROM "+SCHEMA_NAME+".developers" +
                " INNER JOIN "+SCHEMA_NAME+".developers_skills" +
                " ON developers_skills.developer_id = developers.id" +
                " INNER JOIN "+SCHEMA_NAME+".skills" +
                " ON developers_skills.skill_id = skills.id" +
                " WHERE skills.language=?");
        preparedStatement.setString(1, language);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Developer developer = buildDeveloper(resultSet);
            developersList.add(developer);
        }
        return developersList;
           }

    @SneakyThrows
    @Override
    public List<Developer> getDevelopersByLevel(String level) {
        final List<Developer> developersList = new ArrayList<>();
        PreparedStatement preparedStatement = CONNECTION.prepareStatement("SELECT" +
                " developers.name" +
                " FROM "+SCHEMA_NAME+".developers" +
                " INNER JOIN "+SCHEMA_NAME+".developers_skills" +
                " ON developers_skills.developer_id = developers.id" +
                " INNER JOIN "+SCHEMA_NAME+".skills" +
                " ON developers_skills.skill_id = skills.id" +
                " WHERE skills.skill_level=?");
        preparedStatement.setString(1, level);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            final Developer developer = Developer.builder()
                    .id(resultSet.getLong("id"))
                    .name(resultSet.getString("name"))
                    .age(resultSet.getInt("age"))
                    .gender(resultSet.getString("gender"))
                    .salary(resultSet.getDouble("salary"))
                    .build();
            developersList.add(developer);
        }
        return developersList;
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
    public List<Project> getProjectsWithDate() {
        final List<Project> projectList = new ArrayList<>();
        PreparedStatement preparedStatement = CONNECTION.prepareStatement(
                "SELECT" +
                        " creation_date," +
                        " projects.name," +
                        " COUNT(developers.name) AS count_of_devs" +
                        " FROM "+SCHEMA_NAME+".projects" +
                        " INNER JOIN "+SCHEMA_NAME+".developers_projects" +
                        " ON developers_projects.project_id = projects.id" +
                        " INNER JOIN "+SCHEMA_NAME+".developers" +
                        " ON developers_projects.developer_id = developers.id" +
                        " GROUP BY projects.name,creation_date"
        );
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            final Project project = Project.builder()
                    .id(resultSet.getLong("id"))
                    .name(resultSet.getString("name"))
                    .baseTechnology(resultSet.getString("base_technology"))
                    .creationDate(resultSet.getString("creation_date"))
                    .cost(resultSet.getLong("cost"))
                    .build();
            projectList.add(project);
        }
        return projectList;
    }
}
