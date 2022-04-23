package com.test.webapp.servlets.users;


import com.test.webapp.entity.User;
import com.test.webapp.util.UsersSessions;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "usersList", value = "/managers/usersList")
public class UsersList extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        User user = UsersSessions.getUser(request.getSession());
//        DBController db = UsersSessions.getDbController(user);
//
//        UsersDAOImpl usersDAOImpl = db.getUsersDAO();
//        List<User> list = usersDAOImpl.getAll(db.getDbConnector());
//        request.setAttribute("usersList", list);
        getServletContext().getRequestDispatcher("/WEB-INF/views/lists/usersList.jsp").forward(request, response);
    }

}
