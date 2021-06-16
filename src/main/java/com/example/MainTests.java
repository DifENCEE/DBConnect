package com.example;

import com.example.databases.JDBCPostgreSQLConnector;
import com.example.essence.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainTests {
    public static void main(String[] args) throws SQLException {
        String query = "select * from users";
        JDBCPostgreSQLConnector jj = new JDBCPostgreSQLConnector();
        Statement statement = jj.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            User user = new User();
            user.setId(resultSet.getInt(1));
            user.setName(resultSet.getString(2));
            user.setSurname(resultSet.getString(3));
            user.setAge(resultSet.getInt(4));
            System.out.println(user);
        }
    }
}
