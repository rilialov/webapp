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
import java.io.PrintWriter;

@WebServlet(name = "mainPage", value = "/mainPage")
public class MainPage extends HttpServlet {
    private FormBuilder fb;
    private DBController db;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("name");

        db = new DBController();
        UserAccount userAccount = db.loadUser(login);

        if (userAccount != null) {
            UsersSessions.setUser(request.getSession(),userAccount);
            if (!userAccount.isManager()) {
                UsersSessions.setDbControllerMap(userAccount,db);
                fb = new FormBuilder(userAccount.getForm_id(), db);
                UsersSessions.setFormBuilder(userAccount, fb);
                String[] array = fb.getData();
                request.setAttribute("course", array[0]);
                request.setAttribute("trainer", array[1]);
                request.setAttribute("firstname", array[2]);
                request.setAttribute("lastname", array[3]);
                request.setAttribute("date", array[4]);
                getServletContext().getRequestDispatcher("/view/form.jsp").forward(request, response);
            } else getServletContext().getRequestDispatcher("/view/manager.jsp").forward(request, response);
        } else {
            PrintWriter printWriter = response.getWriter();
            printWriter.write("user not found");
            printWriter.close();
        }
    }
}
