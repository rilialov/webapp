package com.test.webapp.servlets.users;

import com.test.webapp.util.SecureUtils;
import com.test.webapp.entity.User;
import com.test.webapp.util.UsersSessions;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "updateUser", value = "/managers/updateUser")
public class UpdateUser extends HttpServlet {
    private int user_id;
//    private UsersDAOImpl usersDAOImpl;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = UsersSessions.getUser(request.getSession());
//        DBController db = UsersSessions.getDbController(user);
//
//        usersDAOImpl = db.getUsersDAO();
//
//        user_id = Integer.parseInt(request.getParameter("user_id"));
//        User userNew = usersDAOImpl.get(db.getDbConnector(), user_id);

        request.setAttribute("title", "Update");
//        request.setAttribute("user", userNew);
        request.setAttribute("create", "update");
        getServletContext().getRequestDispatcher("/WEB-INF/views/create-update/User.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");

//        String[] array = new String[4];
//        array[0] = String.valueOf(user_id);
//        array[1] = request.getParameter("login");
//        String manager = request.getParameter("manager");
//        if (manager == null) {
//            array[3] = "false";
//            array[2] = request.getParameter("form");
//        } else {
//            array[3] = "true";
//            array[2] = "0";
//        }

//        User user = UsersSessions.getUser(request.getSession());
//        DBController db = UsersSessions.getDbController(user);
//        usersDAOImpl.update(db.getDbConnector(), array);
//
//        char[] password = request.getParameter("password").toCharArray();
//        if (password.length != 0) {
//            byte[] salt = SecureUtils.getSalt(password);
//            byte[] hash = SecureUtils.getHash(password,salt);
//            usersDAOImpl.setHashSalt(db.getDbConnector(), user_id, salt, hash);
//        }

        response.sendRedirect("/managers/usersList");
    }

}