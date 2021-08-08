package com.test.webapp.servlets.update;

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

@WebServlet(name = "updateForm", value = "/managers/updateForm")
public class UpdateForm extends HttpServlet {
    private int form_id;
    private FormDAO formDAO;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserAccount userAccount = UsersSessions.getUser(request.getSession());
        DBController db = UsersSessions.getDbController(userAccount);
        formDAO = db.getFormDAO();

        form_id = Integer.parseInt(request.getParameter("form_id"));
        Form form= formDAO.get(db.getDbConnector(), form_id);

        request.setAttribute("form", form);
        request.setAttribute("create", "update");
        getServletContext().getRequestDispatcher("/WEB-INF/views/create-update/Form.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");

        String[] array = new String[5];
        array[0] = String.valueOf(form_id);
        array[1] = request.getParameter("course_id");
        array[2] = request.getParameter("trainer_id");
        array[3] = request.getParameter("student_id");
        array[4] = request.getParameter("date");

        UserAccount userAccount = UsersSessions.getUser(request.getSession());
        DBController db = UsersSessions.getDbController(userAccount);
        formDAO.update(db.getDbConnector(), array);

        response.sendRedirect("/managers/formsList");
    }

}