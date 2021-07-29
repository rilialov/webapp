package com.test.webapp.servlets.creation;

import com.test.webapp.data.DBController;
import com.test.webapp.model.Course;
import com.test.webapp.model.Student;
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

@WebServlet(name = "createCourse", value = "/createCourse")
public class CreateCourse extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/views/creation/createCourse.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");

        UserAccount userAccount = UsersSessions.getUser(request.getSession());

        String[] array = new String[4];
        array[0] = request.getParameter("vendor_id");
        array[1] = request.getParameter("course_code");
        array[2] = request.getParameter("course_name");
        DBController db = UsersSessions.getDbController(userAccount);

        db.createCourse(array);

        Map<Integer, Course> courses = db.getCoursesData();
        List<Student> list = new ArrayList(courses.values());
        request.setAttribute("coursesList", list);
        getServletContext().getRequestDispatcher("/views/lists/coursesList.jsp").forward(request, response);
    }
}