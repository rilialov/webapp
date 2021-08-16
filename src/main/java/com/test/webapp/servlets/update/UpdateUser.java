package com.test.webapp.servlets.update;

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

@WebServlet(name = "updateUser", value = "/managers/updateUser")
public class UpdateUser extends HttpServlet {
    private int user_id;
    private UsersDAO usersDAO;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserAccount userAccount = UsersSessions.getUser(request.getSession());
        DBController db = UsersSessions.getDbController(userAccount);

        usersDAO = db.getUsersDAO();

        user_id = Integer.parseInt(request.getParameter("user_id"));
        UserAccount userAccountNew = usersDAO.get(db.getDbConnector(), user_id);

        request.setAttribute("user", userAccountNew);
        request.setAttribute("create", "update");
        getServletContext().getRequestDispatcher("/WEB-INF/views/create-update/User.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");

        String[] array = new String[5];
        array[0] = String.valueOf(user_id);
        array[1] = request.getParameter("login");
        array[2] = request.getParameter("password");
        array[3] = request.getParameter("form");
        array[4] = request.getParameter("manager");

        byte[] salt = SecureUtils.getSalt(array[2]);
        byte[] hash = SecureUtils.getHash(array[2],salt);

        UserAccount userAccount = UsersSessions.getUser(request.getSession());
        DBController db = UsersSessions.getDbController(userAccount);
        usersDAO.update(db.getDbConnector(), array);
        usersDAO.setHashSalt(db.getDbConnector(), user_id, salt, hash);

        response.sendRedirect("/managers/usersList");
    }

}