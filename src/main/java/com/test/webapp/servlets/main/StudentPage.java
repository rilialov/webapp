package com.test.webapp.servlets.main;

import com.test.webapp.entity.User;
import com.test.webapp.util.UsersSessions;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "studentsPage", value = "/students/form")
public class StudentPage extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        User user = UsersSessions.getUser(request.getSession());
//        DBController db = UsersSessions.getDbController(user);
//
//        FormBuilder fb = new FormBuilder(user.getForm_id(), db);
//        UsersSessions.setFormBuilder(user, fb);
//        String[] array = fb.getData();
//        request.setAttribute("course", array[0]);
//        request.setAttribute("trainer", array[1]);
//        request.setAttribute("firstname", array[2]);
//        request.setAttribute("lastname", array[3]);
//        request.setAttribute("date", LocalDate.parse(array[4]));
        getServletContext().getRequestDispatcher("/WEB-INF/views/form.jsp").forward(request, response);
    }

}
