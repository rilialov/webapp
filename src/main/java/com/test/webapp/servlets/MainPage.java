package com.test.webapp.servlets;

import com.test.webapp.data.DBController;
import com.test.webapp.data.FormBuilder;
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

        boolean isManager = db.isManager(login);
        if (!isManager) {
            int id = db.getFormID(login);
            if (id != 0) {
                UsersSessions.setDbControllerMap(login,db);
                fb = new FormBuilder(id, db);
                UsersSessions.setFormBuilder(login, fb);
                String[] array = fb.getData();
                request.setAttribute("course", array[0]);
                request.setAttribute("trainer", array[1]);
                request.setAttribute("firstname", array[2]);
                request.setAttribute("lastname", array[3]);
                request.setAttribute("date", array[4]);
                request.setAttribute("login", login);
                getServletContext().getRequestDispatcher("/view/form.jsp").forward(request, response);
            } else {
                PrintWriter printWriter = response.getWriter();
                printWriter.write("form not found");
                printWriter.close();
            }
        } else getServletContext().getRequestDispatcher("/view/manager.jsp").forward(request, response);
    }
}
