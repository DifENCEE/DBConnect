package com.example;

import com.example.DAO.UserDAOImpl;
import com.example.databases.JDBCPostgreSQLConnector;
import com.example.essence.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainTests {
    public static void main(String[] args) throws SQLException {
        UserDAOImpl userDAO = new UserDAOImpl();
        User user = new User("vlad", "xxx", 25);
//        userDAO.createUser(user);
        System.out.println(userDAO.getUser(2));
    }
}
