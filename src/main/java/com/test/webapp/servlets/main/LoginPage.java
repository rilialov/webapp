package com.test.webapp.servlets.main;

import com.test.webapp.dao.UsersDAOImpl;
import com.test.webapp.util.Role;
import com.test.webapp.util.SecureUtils;
import com.test.webapp.entity.User;
import com.test.webapp.util.UsersSessions;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebServlet(name = "LoginPage", value = "/login")
public class LoginPage extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        char[] password = request.getParameter("password").toCharArray();

        if (login.length() != 0) {
            UsersDAOImpl usersDAOImpl = new UsersDAOImpl();
            User user = usersDAOImpl.getByLogin(login);

            if (user != null && Arrays.equals(SecureUtils.getHash(password, user.getSalt()),
                            user.getHash())) {
                UsersSessions.setUser(request.getSession(), user);

                if (user.getRole().equals(Role.MANAGER)) {
                    response.sendRedirect("/managers");
                } else response.sendRedirect("/students/form");

            } else {
                request.setAttribute("login", login);
                request.setAttribute("valid", "is-invalid");
                request.setAttribute("error", "Login or Password is invalid!");
                getServletContext().getRequestDispatcher("/").forward(request, response);
            }
        } else {
            request.setAttribute("valid", "is-invalid");
            request.setAttribute("error", "Required Login and Password!");
            getServletContext().getRequestDispatcher("/").forward(request, response);
        }
    }

}
