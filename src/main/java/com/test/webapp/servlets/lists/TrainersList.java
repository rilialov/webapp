package com.test.webapp.servlets.lists;

import com.test.webapp.data.DBController;
import com.test.webapp.model.Student;
import com.test.webapp.model.Trainer;
import com.test.webapp.sessions.UserAccount;
import com.test.webapp.sessions.UsersSessions;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet(name = "trainersList", value = "/trainersList")
public class TrainersList extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserAccount userAccount = UsersSessions.getUser(request.getSession());
        DBController db = UsersSessions.getDbController(userAccount);

        Map<Integer, Trainer> trainers = db.getTrainersData();
        List<Student> list = new ArrayList(trainers.values());
        request.setAttribute("trainersList", list);
        getServletContext().getRequestDispatcher("/views/lists/trainersList.jsp").forward(request, response);
    }

}
