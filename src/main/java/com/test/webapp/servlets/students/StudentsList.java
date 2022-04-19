package com.test.webapp.servlets.students;

import com.test.webapp.dao.StudentsDAOImpl;
import com.test.webapp.entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "studentsList", value = "/managers/studentsList")
public class StudentsList extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentsDAOImpl studentsDAOImpl = new StudentsDAOImpl();
        List<Student> list = studentsDAOImpl.getAll();

        request.setAttribute("studentsList", list);
        getServletContext().getRequestDispatcher("/WEB-INF/views/lists/studentsList.jsp").forward(request, response);
    }

}
