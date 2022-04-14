package com.test.webapp.servlets.lists;

import com.test.webapp.data.DBController;
import com.test.webapp.data.FormsDAOImpl;
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

@WebServlet(name = "formsList", value = "/managers/formsList")
public class FormsList extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserAccount userAccount = UsersSessions.getUser(request.getSession());
        DBController db = UsersSessions.getDbController(userAccount);

        FormsDAOImpl formsDAOImpl = db.getFormsDAO();
        List<Form> list = formsDAOImpl.getAll(db.getDbConnector());
        request.setAttribute("formsList", list);
        getServletContext().getRequestDispatcher("/WEB-INF/views/lists/formsList.jsp").forward(request, response);
    }

}
