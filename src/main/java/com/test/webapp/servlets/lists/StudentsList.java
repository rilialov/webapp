package com.test.webapp.servlets.lists;

import com.test.webapp.data.DBController;
import com.test.webapp.model.Student;
import com.test.webapp.sessions.UserAccount;
import com.test.webapp.sessions.UsersSessions;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet(name = "studentsList", value = "/studentsList")
public class StudentsList extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserAccount userAccount = UsersSessions.getUser(request.getSession());
        DBController db = UsersSessions.getDbController(userAccount);

        Map<Integer, Student> students = db.getStudentsData();
        List<Student> list = new ArrayList(students.values());
        request.setAttribute("studentsList", list);
        getServletContext().getRequestDispatcher("/view/lists/studentsList.jsp").forward(request, response);
    }

}
