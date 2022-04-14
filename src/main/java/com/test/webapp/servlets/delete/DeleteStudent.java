package com.test.webapp.servlets.delete;

import com.test.webapp.data.DBController;
import com.test.webapp.data.StudentsDAOImpl;
import com.test.webapp.sessions.UserAccount;
import com.test.webapp.sessions.UsersSessions;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "deleteStudent", value = "/managers/deleteStudent")
public class DeleteStudent extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserAccount userAccount = UsersSessions.getUser(request.getSession());
        DBController db = UsersSessions.getDbController(userAccount);

        int student_id = Integer.parseInt(request.getParameter("student_id"));
        StudentsDAOImpl studentsDAOImpl = db.getStudentsDAO();
        studentsDAOImpl.delete(db.getDbConnector(), student_id);

        response.sendRedirect("/managers/studentsList");
    }

}