package com.test.webapp.servlets.lists;

import com.test.webapp.data.DBController;
import com.test.webapp.model.Course;
import com.test.webapp.model.Student;
import com.test.webapp.model.Trainer;
import com.test.webapp.sessions.UserAccount;
import com.test.webapp.sessions.UsersSessions;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet(name = "coursesList", value = "/coursesList")
public class CoursesList extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserAccount userAccount = UsersSessions.getUser(request.getSession());
        DBController db = UsersSessions.getDbController(userAccount);

        Map<Integer, Course> courses = db.getCoursesData();
        List<Student> list = new ArrayList(courses.values());
        request.setAttribute("coursesList", list);
        getServletContext().getRequestDispatcher("/view/lists/coursesList.jsp").forward(request, response);
    }

}
