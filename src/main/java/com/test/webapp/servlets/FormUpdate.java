package com.test.webapp.servlets;

import com.test.webapp.data.DBController;
import com.test.webapp.data.FormBuilder;
import com.test.webapp.model.Form;
import com.test.webapp.model.Student;
import com.test.webapp.sessions.UsersSessions;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet(name = "update", value = "/update")
public class FormUpdate extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String login = req.getParameter("login");
        FormBuilder fb = UsersSessions.getFormBuilder(login);
        Form form = fb.getForm();
        String[] array = new String[4];
        array[0] = req.getParameter("firstname");
        array[1] = req.getParameter("lastname");
        array[2] = req.getParameter("phone");
        array[3] = req.getParameter("email");
        DBController db = UsersSessions.getDbController(login);
        db.updateForm(array, form);

        Map<Integer, Student> students = db.getStudentsData();

        List<Student> list = new ArrayList(students.values());
        req.setAttribute("studentsList", list);
        getServletContext().getRequestDispatcher("/view/lists/studentsList.jsp").forward(req, resp);
    }
}
