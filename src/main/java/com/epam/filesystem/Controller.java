package com.epam.filesystem;

import java.sql.*;

public class Controller {
    public static void operate() {
        Driver driver = new org.h2.Driver();
        String URL = "jdbc:h2:mem:test;";
        String USER = "sa";
        String PASSWORD = "pwd";
        try {
            DriverManager.registerDriver(driver);
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            connection.setAutoCommit(true);

            Statement statement = connection.createStatement();
            String sql = "CREATE TABLE Persons (\n" +
                    "    PersonID int,\n" +
                    "    LastName varchar(255),\n" +
                    "    FirstName varchar(255),\n" +
                    "    Address varchar(255),\n" +
                    "    City varchar(255)\n" +
                    ");";
            statement.execute(sql);

            statement = connection.createStatement();
            String SQL2 = "INSERT INTO PERSONS VALUES (10, 'test', 'test2', 'test3', 'test4');";
            statement.execute(SQL2);

            statement = connection.createStatement();
            String sql3 = "SELECT * FROM PERSONS";
            ResultSet resultSet = statement.executeQuery(sql3);

            while(resultSet.next()) {
                System.out.println(resultSet.getInt("PersonID"));
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
