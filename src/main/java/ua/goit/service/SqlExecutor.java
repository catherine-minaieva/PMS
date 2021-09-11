package ua.goit.service;

import ua.goit.model.Developer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SqlExecutor {

        public void extractAllDevelopers() throws SQLException {
        try(DbConnection databaseConnection = DbConnection.getInstance()){
            Connection connection = databaseConnection.getConnection();
 //          PreparedStatement preparedStatement = connection
 //                   .prepareStatement("INSERT INTO test.developers (name, age,gender)" +
 //                           "VALUES (?, ?, ?)");
 //
 //               preparedStatement.setString(1, "Kate");
 //               preparedStatement.setInt(2, 30);
 //               preparedStatement.setString(3, "woman");
 //
 //               preparedStatement.executeUpdate();
 //               preparedStatement.close();

                Statement statement = connection.createStatement();

            String sql = "SELECT * FROM test.developers";

            ResultSet resultSet = statement.executeQuery(sql);
            List<Developer> developers = new ArrayList<>();


            while (resultSet.next()){
                Developer developer = Developer.builder()
                        .id(resultSet.getLong("id"))
                        .name( resultSet.getString("name"))
                        .age(resultSet.getInt("age"))
                        .gender(resultSet.getString("gender"))
                        .salary(resultSet.getDouble("salary"))
                        .build();
                developers.add(developer);
            }

            statement.close();
            System.out.println(developers);
        }
    }
}
