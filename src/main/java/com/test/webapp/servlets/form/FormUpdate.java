package com.test.webapp.servlets.form;

import com.test.webapp.data.DBController;
import com.test.webapp.data.FormBuilder;
import com.test.webapp.data.StudentsDAOImpl;
import com.test.webapp.sessions.UserAccount;
import com.test.webapp.sessions.UsersSessions;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "formUpdate", value = "/students/formUpdate")
public class FormUpdate extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");

        UserAccount userAccount = UsersSessions.getUser(request.getSession());
        FormBuilder fb = UsersSessions.getFormBuilder(userAccount);

        String[] array = new String[5];
        array[0] = String.valueOf(fb.getForm().getId());
        array[1] = request.getParameter("firstname");
        array[2] = request.getParameter("lastname");
        array[3] = request.getParameter("phone");
        array[4] = request.getParameter("email");

        DBController db = UsersSessions.getDbController(userAccount);
        StudentsDAOImpl studentsDAOImpl = db.getStudentsDAO();
        studentsDAOImpl.updateEdited(db.getDbConnector(), array);
        response.sendRedirect("/");
    }

}