package com.test.webapp.servlets.create;

import com.test.webapp.data.DBController;
import com.test.webapp.data.UsersDAO;
import com.test.webapp.sessions.SecureUtils;
import com.test.webapp.sessions.UserAccount;
import com.test.webapp.sessions.UsersSessions;

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
        request.setAttribute("create", "create");
        getServletContext().getRequestDispatcher("/WEB-INF/views/create-update/User.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");

        String[] array = new String[4];
        array[0] = request.getParameter("login");
        array[1] = request.getParameter("form");
        array[2] = request.getParameter("manager");

        UserAccount userAccount = UsersSessions.getUser(request.getSession());
        DBController db = UsersSessions.getDbController(userAccount);
        UsersDAO usersDAO = db.getUsersDAO();

        char[] password = request.getParameter("password").toCharArray();
        byte[] salt = SecureUtils.getSalt(password);
        byte[] hash = SecureUtils.getHash(password,salt);
        usersDAO.createWithSaltHash(db.getDbConnector(), array, salt, hash);

        response.sendRedirect("/managers/usersList");
    }

}