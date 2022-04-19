package com.test.webapp.servlets.students;

import com.test.webapp.dao.StudentsDAOImpl;
import com.test.webapp.entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "createStudent", value = "/managers/createStudent")
public class CreateStudent extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("title", "Create");
        request.setAttribute("create", "create");
        getServletContext().getRequestDispatcher("/WEB-INF/views/create-update/Student.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");

        Student student = new Student(request.getParameter("firstname"), request.getParameter("lastname"));
        student.setPhone(request.getParameter("phone"));
        student.setEmail(request.getParameter("email"));

        StudentsDAOImpl studentsDAOImpl = new StudentsDAOImpl();
        studentsDAOImpl.create(student);

        response.sendRedirect("/managers/studentsList");
    }

}