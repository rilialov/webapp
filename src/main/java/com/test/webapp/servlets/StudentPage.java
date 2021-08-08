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

@WebServlet(name = "studentsPage", value = "/students/form")
public class StudentPage extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        UserAccount userAccount = UsersSessions.getUser(request.getSession());
        DBController db = UsersSessions.getDbController(userAccount);

        FormBuilder fb = new FormBuilder(userAccount.getForm_id(), db);
        UsersSessions.setFormBuilder(userAccount, fb);
        String[] array = fb.getData();
        request.setAttribute("course", array[0]);
        request.setAttribute("trainer", array[1]);
        request.setAttribute("firstname", array[2]);
        request.setAttribute("lastname", array[3]);
        request.setAttribute("date", array[4]);
        getServletContext().getRequestDispatcher("/WEB-INF/views/form.jsp").forward(request, response);
    }

}
