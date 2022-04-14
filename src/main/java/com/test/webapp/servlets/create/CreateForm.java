package com.test.webapp.servlets.create;

import com.test.webapp.data.DBController;
import com.test.webapp.data.FormsDAOImpl;
import com.test.webapp.sessions.UserAccount;
import com.test.webapp.sessions.UsersSessions;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "createForm", value = "/managers/createForm")
public class CreateForm extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("title", "Create");
        request.setAttribute("create", "create");
        getServletContext().getRequestDispatcher("/WEB-INF/views/create-update/Form.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");

        String[] array = new String[4];
        array[0] = request.getParameter("course_id");
        array[1] = request.getParameter("trainer_id");
        array[2] = request.getParameter("student_id");
        array[3] = request.getParameter("date");

        UserAccount userAccount = UsersSessions.getUser(request.getSession());
        DBController db = UsersSessions.getDbController(userAccount);

        FormsDAOImpl formsDAOImpl = db.getFormsDAO();
        formsDAOImpl.create(db.getDbConnector(), array);

        response.sendRedirect("/managers/formsList");
    }

}