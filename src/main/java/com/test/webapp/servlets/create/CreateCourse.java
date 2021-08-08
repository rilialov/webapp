package com.test.webapp.servlets.create;

import com.test.webapp.data.CoursesDAO;
import com.test.webapp.data.DBController;
import com.test.webapp.data.VendorDAO;
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

@WebServlet(name = "createCourse", value = "/managers/createCourse")
public class CreateCourse extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserAccount userAccount = UsersSessions.getUser(request.getSession());
        DBController db = UsersSessions.getDbController(userAccount);
        VendorDAO vendorDAO = db.getVendorDAO();
        List<Vendor> list = vendorDAO.getAll(db.getDbConnector());
        request.setAttribute("vendorsList", list);
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

        CoursesDAO coursesDAO = db.getCoursesDAO();
        coursesDAO.create(db.getDbConnector(), array);

        response.sendRedirect("/managers/coursesList");
    }

}