package com.test.webapp.servlets.users;

import com.test.webapp.entity.User;
import com.test.webapp.util.UsersSessions;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "createUser", value = "/managers/createUser")
public class CreateUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("title", "Create");
        request.setAttribute("create", "create");
        getServletContext().getRequestDispatcher("/WEB-INF/views/create-update/User.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");

//        String[] array = new String[3];
//        array[0] = request.getParameter("login");
//        String manager = request.getParameter("manager");
//        if (manager == null) {
//            array[2] = "STUDENT";
//            array[1] = request.getParameter("form");
//        } else {
//            array[2] = "MANAGER";
//            array[1] = "null";
//        }

        User user = UsersSessions.getUser(request.getSession());
//        DBController db = UsersSessions.getDbController(user);
//        UsersDAOImpl usersDAOImpl = db.getUsersDAO();
//
//        char[] password = request.getParameter("password").toCharArray();
//        byte[] salt = SecureUtils.getSalt(password);
//        byte[] hash = SecureUtils.getHash(password,salt);
//        usersDAOImpl.createWithSaltHash(db.getDbConnector(), array, salt, hash);

        response.sendRedirect("/managers/usersList");
    }

}