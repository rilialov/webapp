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
public class MainForm extends HttpServlet {
    private FormBuilder fb;
    private DBController db;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/form.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("name");

        db = new DBController();
        int id = db.getFormID(login);

        if (id != 0) {
            UsersSessions.setDbControllerMap(login,db);
            fb = new FormBuilder(id, db);
            UsersSessions.setFormBuilder(login, fb);
            String[] array = fb.getData();
            req.setAttribute("course", array[0]);
            req.setAttribute("trainer", array[1]);
            req.setAttribute("firstname", array[2]);
            req.setAttribute("lastname", array[3]);
            req.setAttribute("date", array[4]);
            req.setAttribute("login", login);
            getServletContext().getRequestDispatcher("/view/form.jsp").forward(req, resp);
        } else {
            PrintWriter printWriter = resp.getWriter();
            printWriter.write("login not found");
            printWriter.close();
        }
    }
}

