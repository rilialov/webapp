package com.test.webapp.servlets.forms;

import com.test.webapp.entity.User;
import com.test.webapp.util.UsersSessions;

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
//        User user = UsersSessions.getUser(request.getSession());
//        DBController db = UsersSessions.getDbController(user);
//
//        int form_id = Integer.parseInt(request.getParameter("form_id"));
//        FormsDAOImpl formsDAOImpl = db.getFormsDAO();
//        formsDAOImpl.delete(db.getDbConnector(), form_id);

        response.sendRedirect("/managers/formsList");
    }

}