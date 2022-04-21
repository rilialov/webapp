package com.test.webapp.servlets.courses;

import com.test.webapp.dao.CoursesDAOImpl;
import com.test.webapp.entity.Course;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "deleteCourse", value = "/managers/deleteCourse")
public class DeleteCourse extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CoursesDAOImpl coursesDAOImpl = new CoursesDAOImpl();
        Course course = coursesDAOImpl.getById(Long.valueOf(request.getParameter("course_id")));
        coursesDAOImpl.delete(course);

        response.sendRedirect("/managers/coursesList");
    }

}