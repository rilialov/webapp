package com.test.webapp.servlets.delete;

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

@WebServlet(name = "deleteCourse", value = "/deleteCourse")
public class DeleteCourse extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserAccount userAccount = UsersSessions.getUser(request.getSession());
        DBController db = UsersSessions.getDbController(userAccount);

        int course_id = Integer.parseInt(request.getParameter("course_id"));
        CoursesDAO coursesDAO = db.getCoursesDAO();
        coursesDAO.delete(db.getDbConnector(), course_id);

        List<Course> list = coursesDAO.getAll(db.getDbConnector());
        request.setAttribute("coursesList", list);
        getServletContext().getRequestDispatcher("/WEB-INF/views/lists/coursesList.jsp").forward(request, response);
    }

}