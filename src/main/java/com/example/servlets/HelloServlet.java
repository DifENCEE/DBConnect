package com.example.servlets;

import com.example.DAO.UserDAOImpl;
import com.example.essence.User;

import javax.jws.soap.SOAPBinding;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/")
public class HelloServlet extends HttpServlet {
    UserDAOImpl userDAO = new UserDAOImpl();

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        List<User> userList = userDAO.getAllUsers();

        req.setAttribute("users", userList);

        req.getRequestDispatcher("main.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        switch (action) {
            case "add":
                addUserAction(req);
                break;
            case "delete":
                deleteUserAction(req);
                break;
            case "update":
                updateUserAction(req);
                break;
        }
        doGet(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    private void addUserAction(HttpServletRequest req) {
        User user = null;

        int id = Integer.parseInt(req.getParameter("id"));
        int age = Integer.parseInt(req.getParameter("age"));
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");

        if (id < 0) {
            user = new User(name, surname, age);
            userDAO.createUser(user);
        } else {
            user = new User(id, name, surname, age);
            userDAO.updateUser(user);
        }
    }

    private void updateUserAction(HttpServletRequest req) {
        int id = Integer.parseInt(req.getParameter("userId"));

        User updateUser = userDAO.getUser(id);

        req.setAttribute("updateUser", updateUser);
    }

    private void deleteUserAction(HttpServletRequest req) {
        int userId = Integer.parseInt(req.getParameter("userId"));

        userDAO.deleteUser(userId);
    }
}