package com.test.webapp.servlets.users;

import com.test.webapp.entity.User;
import com.test.webapp.util.UsersSessions;

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
//        User user = UsersSessions.getUser(request.getSession());
//        DBController db = UsersSessions.getDbController(user);
//
//        int user_id = Integer.parseInt(request.getParameter("user_id"));
//        UsersDAOImpl usersDAOImpl = db.getUsersDAO();
//        usersDAOImpl.delete(db.getDbConnector(), user_id);

        response.sendRedirect("/managers/usersList");
    }

}