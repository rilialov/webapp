package com.test.webapp.servlets.create;

import com.test.webapp.data.DBController;
import com.test.webapp.data.FormDAO;
import com.test.webapp.model.Form;
import com.test.webapp.sessions.UserAccount;
import com.test.webapp.sessions.UsersSessions;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "createForm", value = "/createForm")
public class CreateForm extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

        FormDAO formDAO = db.getFormDAO();
        formDAO.create(db.getDbConnector(), array);

        List<Form> list = formDAO.getAll(db.getDbConnector());
        request.setAttribute("formsList", list);
        getServletContext().getRequestDispatcher("/WEB-INF/views/lists/formsList.jsp").forward(request, response);
    }
}