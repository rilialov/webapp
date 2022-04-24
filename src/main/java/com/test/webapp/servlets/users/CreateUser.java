package com.test.webapp.servlets.users;

import com.test.webapp.dao.FormsDAOImpl;
import com.test.webapp.dao.UsersDAOImpl;
import com.test.webapp.entity.Form;
import com.test.webapp.entity.User;
import com.test.webapp.util.Role;
import com.test.webapp.util.SecureUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "createUser", value = "/managers/createUser")
public class CreateUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("title", "Create");
        request.setAttribute("create", "create");
        getServletContext().getRequestDispatcher("/WEB-INF/views/create-update/User.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        FormsDAOImpl formsDAO = new FormsDAOImpl();
        UsersDAOImpl usersDAO = new UsersDAOImpl();

        char[] password = request.getParameter("password").toCharArray();
        byte[] salt = SecureUtils.getSalt(password);
        byte[] hash = SecureUtils.getHash(password, salt);

        Role role;
        Form form;
        String manager = request.getParameter("manager");
        if (manager == null) {
            role = Role.STUDENT;
            form = formsDAO.getById(Long.valueOf(request.getParameter("form")));
        } else {
            role = Role.MANAGER;
            form = null;
        }
        User user = new User(request.getParameter("login"), hash, salt, role);
        if (form != null) {
            user.setForm(form);
        }

        usersDAO.create(user);

        response.sendRedirect("/managers/usersList");
    }

}