package com.test.webapp.servlets.update;

import com.test.webapp.data.CoursesDAO;
import com.test.webapp.data.DBController;
import com.test.webapp.data.VendorDAO;
import com.test.webapp.model.Course;
import com.test.webapp.model.Vendor;
import com.test.webapp.sessions.UserAccount;
import com.test.webapp.sessions.UsersSessions;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "updateCourse", value = "/updateCourse")
public class UpdateCourse extends HttpServlet {
    private int course_id;
    private CoursesDAO coursesDAO;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserAccount userAccount = UsersSessions.getUser(request.getSession());
        DBController db = UsersSessions.getDbController(userAccount);
        coursesDAO = db.getCoursesDAO();

        course_id = Integer.parseInt(request.getParameter("course_id"));
        Course course = coursesDAO.get(db.getDbConnector(), course_id);

        VendorDAO vendorDAO = db.getVendorDAO();
        List<Vendor> list = vendorDAO.getAll(db.getDbConnector());

        request.setAttribute("vendorsList", list);
        request.setAttribute("course", course);
        request.setAttribute("create", "update");
        getServletContext().getRequestDispatcher("/WEB-INF/views/create-update/Course.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");

        String[] array = new String[4];
        array[0] = String.valueOf(course_id);
        array[1] = request.getParameter("vendor_id");
        array[2] = request.getParameter("course_code");
        array[3] = request.getParameter("course_name");

        UserAccount userAccount = UsersSessions.getUser(request.getSession());
        DBController db = UsersSessions.getDbController(userAccount);
        coursesDAO.update(db.getDbConnector(), array);

        List<Course> list = coursesDAO.getAll(db.getDbConnector());
        request.setAttribute("coursesList", list);
        getServletContext().getRequestDispatcher("/WEB-INF/views/lists/coursesList.jsp").forward(request, response);
    }
}