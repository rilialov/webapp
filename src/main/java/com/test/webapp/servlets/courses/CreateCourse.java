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

@WebServlet(name = "createCourse", value = "/managers/createCourse")
public class CreateCourse extends HttpServlet {
    private VendorsDAOImpl vendorsDAOImpl = new VendorsDAOImpl();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Vendor> list = vendorsDAOImpl.getAll();
        request.setAttribute("title", "Create");
        request.setAttribute("vendorsList", list);
        request.setAttribute("create", "create");
        getServletContext().getRequestDispatcher("/WEB-INF/views/create-update/Course.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");

        Course course = new Course(request.getParameter("course_code"), request.getParameter("course_name"),
                vendorsDAOImpl.getById(Long.valueOf(request.getParameter("vendor_id"))));

        CoursesDAOImpl coursesDAOImpl = new CoursesDAOImpl();
        coursesDAOImpl.create(course);

        response.sendRedirect("/managers/coursesList");
    }

}