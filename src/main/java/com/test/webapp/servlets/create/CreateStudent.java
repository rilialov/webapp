package com.test.webapp.servlets.create;

import com.test.webapp.data.DBController;
import com.test.webapp.data.StudentsDAO;
import com.test.webapp.sessions.UserAccount;
import com.test.webapp.sessions.UsersSessions;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "createStudent", value = "/managers/createStudent")
public class CreateStudent extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("title", "Create");
        request.setAttribute("create", "create");
        getServletContext().getRequestDispatcher("/WEB-INF/views/create-update/Student.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");

        String[] array = new String[4];
        array[0] = request.getParameter("firstname");
        array[1] = request.getParameter("lastname");
        array[2] = request.getParameter("phone");
        array[3] = request.getParameter("email");

        UserAccount userAccount = UsersSessions.getUser(request.getSession());
        DBController db = UsersSessions.getDbController(userAccount);

        StudentsDAO studentsDAO = db.getStudentsDAO();
        studentsDAO.create(db.getDbConnector(),array);

        response.sendRedirect("/managers/studentsList");
    }

}