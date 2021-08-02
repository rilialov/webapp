package com.test.webapp.servlets;

import com.test.webapp.data.DBController;
import com.test.webapp.data.FormBuilder;
import com.test.webapp.sessions.UserAccount;
import com.test.webapp.sessions.UsersSessions;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "mainPage", value = "/mainPage")
public class MainPage extends HttpServlet {
    private final DBController db = new DBController();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        if (login.length() != 0) {

            UserAccount userAccount = db.loadUser(login);

            if (userAccount != null & password.equals(userAccount.getPassword())) {
                UsersSessions.setUser(request.getSession(),userAccount);
                UsersSessions.setDbControllerMap(userAccount,db);

                if (!userAccount.isManager()) {
                    FormBuilder fb = new FormBuilder(userAccount.getForm_id(), db);
                    UsersSessions.setFormBuilder(userAccount, fb);
                    String[] array = fb.getData();
                    request.setAttribute("course", array[0]);
                    request.setAttribute("trainer", array[1]);
                    request.setAttribute("firstname", array[2]);
                    request.setAttribute("lastname", array[3]);
                    request.setAttribute("date", array[4]);
                    getServletContext().getRequestDispatcher("/WEB-INF/views/form.jsp").forward(request, response);
                } else getServletContext().getRequestDispatcher("/WEB-INF/views/manager.jsp").forward(request, response);
            } else {
                request.setAttribute("login", login);
                request.setAttribute("error", "Login or Password is invalid!");
                getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("error", "Required Login and Password!");
            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }

}
