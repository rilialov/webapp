package com.test.webapp.servlets.students;

import com.test.webapp.dao.StudentsDAOImpl;
import com.test.webapp.entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "updateStudent", value = "/managers/updateStudent")
public class UpdateStudent extends HttpServlet {
    private Student student;
    private StudentsDAOImpl studentsDAOImpl = new StudentsDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        student = studentsDAOImpl.getById(Long.valueOf(request.getParameter("student_id")));

        request.setAttribute("title", "Update");
        request.setAttribute("student", student);
        request.setAttribute("create", "update");
        getServletContext().getRequestDispatcher("/WEB-INF/views/create-update/Student.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");

        student.setFirstName(request.getParameter("firstname"));
        student.setLastName(request.getParameter("lastname"));
        student.setPhone(request.getParameter("phone"));
        student.setEmail(request.getParameter("email"));

        studentsDAOImpl.update(student);

        response.sendRedirect("/managers/studentsList");
    }

}