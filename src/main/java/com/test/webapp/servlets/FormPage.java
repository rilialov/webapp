package com.test.webapp.servlets;

import com.test.webapp.data.DBController;
import com.test.webapp.data.FormBuilder;
import com.test.webapp.sessions.UsersSessions;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "form", value = "/form")
public class FormPage extends HttpServlet {
    private FormBuilder fb;
    private DBController db;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/form.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("name");

        db = new DBController();
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
            printWriter.write("login not found");
            printWriter.close();
        }
    }
}

