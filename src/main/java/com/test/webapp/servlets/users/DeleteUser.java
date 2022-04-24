package com.test.webapp.servlets.users;

import com.test.webapp.dao.UsersDAOImpl;
import com.test.webapp.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "deleteUser", value = "/managers/deleteUser")
public class DeleteUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UsersDAOImpl usersDAO = new UsersDAOImpl();
        User user = usersDAO.getById(Long.valueOf(request.getParameter("user_id")));
        usersDAO.delete(user);

        response.sendRedirect("/managers/usersList");
    }

}