package ua.goit;

import ua.goit.service.SqlExecutor;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        SqlExecutor exec = new SqlExecutor();
        exec.extractAllDevelopers();
    }
}

