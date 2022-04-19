package com.test.webapp.servlets.courses;

import com.test.webapp.data.CoursesDAOImpl;
import com.test.webapp.data.DBController;
import com.test.webapp.util.UserAccount;
import com.test.webapp.util.UsersSessions;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "createCourse", value = "/managers/createCourse")
public class CreateCourse extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserAccount userAccount = UsersSessions.getUser(request.getSession());
        DBController db = UsersSessions.getDbController(userAccount);
//        VendorsDAOImpl vendorsDAOImpl = db.getVendorsDAO();
//        List<Vendor> list = vendorsDAOImpl.getAll(db.getDbConnector());
        request.setAttribute("title", "Create");
//        request.setAttribute("vendorsList", list);
        request.setAttribute("create", "create");
        getServletContext().getRequestDispatcher("/WEB-INF/views/create-update/Course.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");

        String[] array = new String[3];
        array[0] = request.getParameter("vendor_id");
        array[1] = request.getParameter("course_code");
        array[2] = request.getParameter("course_name");

        UserAccount userAccount = UsersSessions.getUser(request.getSession());
        DBController db = UsersSessions.getDbController(userAccount);

        CoursesDAOImpl coursesDAOImpl = db.getCoursesDAO();
        coursesDAOImpl.create(db.getDbConnector(), array);

        response.sendRedirect("/managers/coursesList");
    }

}