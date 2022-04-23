package com.test.webapp.servlets.forms;

import com.test.webapp.entity.User;
import com.test.webapp.util.UsersSessions;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "formsList", value = "/managers/formsList")
public class FormsList extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        User user = UsersSessions.getUser(request.getSession());
//        DBController db = UsersSessions.getDbController(user);
//
//        FormsDAOImpl formsDAOImpl = db.getFormsDAO();
//        List<Form> list = formsDAOImpl.getAll(db.getDbConnector());
//        request.setAttribute("formsList", list);
        getServletContext().getRequestDispatcher("/WEB-INF/views/lists/formsList.jsp").forward(request, response);
    }

}
