package com.test.webapp.servlets.forms;

import com.test.webapp.entity.User;
import com.test.webapp.util.UsersSessions;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "formUpdate", value = "/students/formUpdate")
public class UpdateFormFromStudents extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");

//        User user = UsersSessions.getUser(request.getSession());
//        FormBuilder fb = UsersSessions.getFormBuilder(user);
//
//        String[] array = new String[5];
////        array[0] = String.valueOf(fb.getForm().getId());
//        array[1] = request.getParameter("firstname");
//        array[2] = request.getParameter("lastname");
//        array[3] = request.getParameter("phone");
//        array[4] = request.getParameter("email");
//
//        DBController db = UsersSessions.getDbController(user);
//        StudentsDAOImpl studentsDAOImpl = db.getStudentsDAO();
//        studentsDAOImpl.updateEdited(db.getDbConnector(), array);
        response.sendRedirect("/");
    }

}