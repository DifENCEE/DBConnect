package com.example.DAO;

import com.example.databases.JDBCPostgreSQLConnector;
import com.example.essence.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO{
    JDBCPostgreSQLConnector jdbcConnector = new JDBCPostgreSQLConnector();

    @Override
    public void createUser(User user) {
        String INSERT = "INSERT into users (name, surname, age) values (?, ?, ?)";
        try (PreparedStatement statement = jdbcConnector.getConnection().prepareStatement(INSERT)) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getSurname());
            statement.setInt(3, user.getAge());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getUser(int id) {
        String SELECT_BY_ID = "SELECT * FROM users WHERE id = ?";
        User user = new User();
        try (PreparedStatement statement = jdbcConnector.getConnection().prepareStatement(SELECT_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                user.setId(resultSet.getInt(1));
                user.setName(resultSet.getString(2));
                user.setSurname(resultSet.getString(3));
                user.setAge(resultSet.getInt(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void updateUser(User user) {
        String UPDATE = "UPDATE users set (name, surname, age) = (?, ?, ?) WHERE id = ?";
        try (PreparedStatement statement = jdbcConnector.getConnection().prepareStatement(UPDATE);
        ) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getSurname());
            statement.setInt(3, user.getAge());
            statement.setInt(4, user.getId());

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser(int userId) {
        String DELETE = "DELETE FROM users WHERE id = ?";
        try (PreparedStatement statement = jdbcConnector.getConnection().prepareStatement(DELETE)) {
            statement.setInt(1, userId);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> usersList = new ArrayList<>();
        String query = "select * from users";
        try {
            PreparedStatement statement = jdbcConnector.getConnection().prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
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
