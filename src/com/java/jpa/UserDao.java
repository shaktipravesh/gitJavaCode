package com.java.jpa;

import java.sql.*;
import java.util.logging.Logger;

public class UserDao {

    Logger log = Logger.getLogger("UserDao");
    public void createUserTable() {
        Connection connection;
        try {
            connection = new DatabaseConnection().getConnection();
            Statement statementQuery = connection.createStatement();
            String sql = "CREATE TABLE users(user_id INT AUTO_INCREMENT PRIMARY KEY, use_name VARCHAR(100), age INT)";
            statementQuery.executeUpdate(sql);
        } catch (SQLException e) {
            log.info(e.getMessage());
        }
    }

    public void createUser() {
        try {
            Connection connection = new DatabaseConnection().getConnection();
            String sql = "INSERT INTO users(use_name, age) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "admin");
            preparedStatement.setInt(2, 20);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            log.info(e.getMessage());
        }
    }

    public void readUser() {
        try {
            Connection connection = new DatabaseConnection().getConnection();
            String sql = "SELECT * FROM users";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int userId = resultSet.getInt("user_id");
                String useName = resultSet.getString("use_name");
                int age = resultSet.getInt("age");
                log.info(new StringBuilder().append(userId).append(" : ").append(useName).append(" : ").append(age).toString());
            }
        } catch (SQLException e) {
            log.info(e.getMessage());
        }
    }
}
