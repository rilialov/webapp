package com.test.webapp.servlets.trainers;

import com.test.webapp.dao.TrainersDAOImpl;
import com.test.webapp.entity.Trainer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "trainersList", value = "/managers/trainersList")
public class TrainersList extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TrainersDAOImpl trainersDAO = new TrainersDAOImpl();
        List<Trainer> trainers = trainersDAO.getAll();

        request.setAttribute("trainersList", trainers);
        getServletContext().getRequestDispatcher("/WEB-INF/views/lists/trainersList.jsp").forward(request, response);
    }

}