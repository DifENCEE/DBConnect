package com.example.DAO;

import com.example.databases.JDBCPostgreSQLConnector;
import com.example.essence.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO{
    JDBCPostgreSQLConnector jdbcConnector = new JDBCPostgreSQLConnector();

    @Override
    public void createUser(User user) {

    }

    @Override
    public User getUser(int id) {
        return null;
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void deleteUser(User user) {

    }

    @Override
    public List<User> getAllUsers() {
        List<User> usersList = new ArrayList<>();
        String query = "select * from users";
        try {
            Statement statement = jdbcConnector.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt(1));
                user.setName(resultSet.getString(2));
                user.setSurname(resultSet.getString(3));
                user.setAge(resultSet.getInt(4));
                usersList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usersList;
    }
}
