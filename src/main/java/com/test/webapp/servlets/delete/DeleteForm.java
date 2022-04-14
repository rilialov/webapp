package com.test.webapp.servlets.delete;

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

@WebServlet(name = "deleteForm", value = "/managers/deleteForm")
public class DeleteForm extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserAccount userAccount = UsersSessions.getUser(request.getSession());
        DBController db = UsersSessions.getDbController(userAccount);

        int form_id = Integer.parseInt(request.getParameter("form_id"));
        FormsDAOImpl formsDAOImpl = db.getFormsDAO();
        formsDAOImpl.delete(db.getDbConnector(), form_id);

        response.sendRedirect("/managers/formsList");
    }

}