package com.test.webapp.servlets;

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
import java.util.Arrays;

@WebServlet(name = "LoginPage", value = "/login")
public class LoginPage extends HttpServlet {
    private final DBController db = new DBController();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        char[] password = request.getParameter("password").toCharArray();

        if (login.length() != 0) {
            UsersDAO usersDAO = db.getUsersDAO();
            UserAccount userAccount = usersDAO.getByLogin(db.getDbConnector(),login);

//            if (userAccount != null) {
//                byte[] passwordHash = SecureUtils.getHash(request.getParameter("password"), userAccount.getSalt());
//
//                if (Arrays.equals(passwordHash, userAccount.getHash())) {
//                    UsersSessions.setUser(request.getSession(),userAccount);
//                    UsersSessions.setDbControllerMap(userAccount,db);

//                    if (userAccount.isManager()) {
//                        response.sendRedirect("/managers");
//                    } else response.sendRedirect("/students/form");
//                }
//            }

            if (userAccount != null && Arrays.equals(password, userAccount.getPassword())) {
                UsersSessions.setUser(request.getSession(),userAccount);
                UsersSessions.setDbControllerMap(userAccount,db);

                if (userAccount.isManager()) {
                    response.sendRedirect("/managers");
                } else response.sendRedirect("/students/form");

            } else {
                request.setAttribute("login", login);
                request.setAttribute("error", "Login or Password is invalid!");
                getServletContext().getRequestDispatcher("/").forward(request, response);
            }
        } else {
            request.setAttribute("error", "Required Login and Password!");
            getServletContext().getRequestDispatcher("/").forward(request, response);
        }
    }

}
