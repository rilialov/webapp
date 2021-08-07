package com.test.webapp.servlets.update;

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

@WebServlet(name = "updateStudent", value = "/updateStudent")
public class UpdateStudent extends HttpServlet {
    private int student_id;
    private StudentsDAO studentsDAO;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserAccount userAccount = UsersSessions.getUser(request.getSession());
        DBController db = UsersSessions.getDbController(userAccount);
        studentsDAO = db.getStudentsDAO();

        student_id = Integer.parseInt(request.getParameter("student_id"));
        Student student = studentsDAO.get(db.getDbConnector(), student_id);

        request.setAttribute("student", student);
        request.setAttribute("create", "update");
        getServletContext().getRequestDispatcher("/WEB-INF/views/create-update/Student.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");

        String[] array = new String[5];
        array[0] = String.valueOf(student_id);
        array[1] = request.getParameter("firstname");
        array[2] = request.getParameter("lastname");
        array[3] = request.getParameter("phone");
        array[4] = request.getParameter("email");

        UserAccount userAccount = UsersSessions.getUser(request.getSession());
        DBController db = UsersSessions.getDbController(userAccount);
        studentsDAO.update(db.getDbConnector(), array);

        List<Student> list = studentsDAO.getAll(db.getDbConnector());
        request.setAttribute("studentsList", list);
        getServletContext().getRequestDispatcher("/WEB-INF/views/lists/studentsList.jsp").forward(request, response);
    }
}