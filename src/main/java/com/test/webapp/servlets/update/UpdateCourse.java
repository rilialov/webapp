package com.test.webapp.servlets.update;

import com.test.webapp.data.CoursesDAO;
import com.test.webapp.data.DBController;
import com.test.webapp.model.Course;
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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserAccount userAccount = UsersSessions.getUser(request.getSession());
        DBController db = UsersSessions.getDbController(userAccount);

        course_id = Integer.parseInt(request.getParameter("course_id"));
        CoursesDAO coursesDAO = new CoursesDAO();
        Course course = coursesDAO.get(db.getDbConnector(), course_id);
        request.setAttribute("course", course);
        getServletContext().getRequestDispatcher("/views/update/updateCourse.jsp").forward(request, response);
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

        CoursesDAO coursesDAO = new CoursesDAO();
        coursesDAO.update(db.getDbConnector(), array);

        List<Course> list = coursesDAO.getAll(db.getDbConnector());
        request.setAttribute("coursesList", list);
        getServletContext().getRequestDispatcher("/views/lists/coursesList.jsp").forward(request, response);
    }
}