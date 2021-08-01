package com.test.webapp.servlets.delete;

import com.test.webapp.data.DBController;
import com.test.webapp.data.StudentsDAO;
import com.test.webapp.model.Student;
import com.test.webapp.sessions.UserAccount;
import com.test.webapp.sessions.UsersSessions;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "deleteStudent", value = "/deleteStudent")
public class DeleteStudent extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserAccount userAccount = UsersSessions.getUser(request.getSession());
        DBController db = UsersSessions.getDbController(userAccount);

        int student_id = Integer.parseInt(request.getParameter("student_id"));
        StudentsDAO studentsDAO = new StudentsDAO();
        studentsDAO.delete(db.getDbConnector(), student_id);

        List<Student> list = studentsDAO.getAll(db.getDbConnector());
        request.setAttribute("studentsList", list);
        getServletContext().getRequestDispatcher("/views/lists/studentsList.jsp").forward(request, response);
    }

}