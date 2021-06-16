package com.example.DAO;

import com.example.essence.User;

import java.util.List;

public interface UserDAO {
    void createUser(User user);
    User getUser(int id);
    void updateUser(User user);
    void deleteUser(User user);
    List<User> getAllUsers();
}
