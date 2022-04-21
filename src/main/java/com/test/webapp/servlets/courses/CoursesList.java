package com.test.webapp.servlets.courses;

import com.test.webapp.dao.CoursesDAOImpl;
import com.test.webapp.entity.Course;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "coursesList", value = "/managers/coursesList")
public class CoursesList extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CoursesDAOImpl coursesDAOImpl = new CoursesDAOImpl();
        List<Course> list = coursesDAOImpl.getAll();

        request.setAttribute("coursesList", list);
        getServletContext().getRequestDispatcher("/WEB-INF/views/lists/coursesList.jsp").forward(request, response);
    }

}
