package com.test.webapp.servlets.students;

import com.test.webapp.dao.StudentsDAOImpl;
import com.test.webapp.entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "deleteStudent", value = "/managers/deleteStudent")
public class DeleteStudent extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentsDAOImpl studentsDAO = new StudentsDAOImpl();
        Student student = studentsDAO.getById(Long.valueOf(request.getParameter("student_id")));
        studentsDAO.delete(student);

        response.sendRedirect("/managers/studentsList");
    }

}