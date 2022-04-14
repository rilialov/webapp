package com.test.webapp.servlets.lists;

import com.test.webapp.data.DBController;
import com.test.webapp.data.UsersDAOImpl;
import com.test.webapp.sessions.UserAccount;
import com.test.webapp.sessions.UsersSessions;

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
        UserAccount userAccount = UsersSessions.getUser(request.getSession());
        DBController db = UsersSessions.getDbController(userAccount);

        UsersDAOImpl usersDAOImpl = db.getUsersDAO();
        List<UserAccount> list = usersDAOImpl.getAll(db.getDbConnector());
        request.setAttribute("usersList", list);
        getServletContext().getRequestDispatcher("/WEB-INF/views/lists/usersList.jsp").forward(request, response);
    }

}
