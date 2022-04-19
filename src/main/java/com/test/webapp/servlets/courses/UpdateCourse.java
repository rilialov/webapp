package com.test.webapp.servlets.courses;

import com.test.webapp.data.CoursesDAOImpl;
import com.test.webapp.data.DBController;
import com.test.webapp.model.Course;
import com.test.webapp.util.UserAccount;
import com.test.webapp.util.UsersSessions;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "updateCourse", value = "/managers/updateCourse")
public class UpdateCourse extends HttpServlet {
    private int course_id;
    private CoursesDAOImpl coursesDAOImpl;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserAccount userAccount = UsersSessions.getUser(request.getSession());
        DBController db = UsersSessions.getDbController(userAccount);
        coursesDAOImpl = db.getCoursesDAO();

        course_id = Integer.parseInt(request.getParameter("course_id"));
        Course course = coursesDAOImpl.get(db.getDbConnector(), course_id);

//        VendorsDAOImpl vendorsDAOImpl = db.getVendorsDAO();
//        List<Vendor> list = vendorsDAOImpl.getAll(db.getDbConnector());

        request.setAttribute("title", "Update");
//        request.setAttribute("vendorsList", list);
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
        coursesDAOImpl.update(db.getDbConnector(), array);

        response.sendRedirect("/managers/coursesList");
    }

}