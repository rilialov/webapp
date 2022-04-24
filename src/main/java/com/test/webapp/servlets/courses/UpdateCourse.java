package com.test.webapp.servlets.courses;

import com.test.webapp.dao.CoursesDAOImpl;
import com.test.webapp.dao.VendorsDAOImpl;
import com.test.webapp.entity.Course;
import com.test.webapp.entity.Vendor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "updateCourse", value = "/managers/updateCourse")
public class UpdateCourse extends HttpServlet {
    private Course course;
    private final CoursesDAOImpl coursesDAO = new CoursesDAOImpl();
    private final VendorsDAOImpl vendorsDAO = new VendorsDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        course = coursesDAO.getById(Long.valueOf(request.getParameter("course_id")));
        List<Vendor> list = vendorsDAO.getAll();

        request.setAttribute("title", "Update");
        request.setAttribute("vendorsList", list);
        request.setAttribute("course", course);
        request.setAttribute("create", "update");
        getServletContext().getRequestDispatcher("/WEB-INF/views/create-update/Course.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");

        course.setCourseCode(request.getParameter("course_code"));
        course.setCourseName(request.getParameter("course_name"));
        course.setVendor(vendorsDAO.getById(Long.valueOf(request.getParameter("vendor_id"))));

        coursesDAO.update(course);

        response.sendRedirect("/managers/coursesList");
    }

}