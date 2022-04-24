package com.test.webapp.servlets.trainers;

import com.test.webapp.dao.TrainersDAOImpl;
import com.test.webapp.entity.Trainer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "deleteTrainer", value = "/managers/deleteTrainer")
public class DeleteTrainer extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TrainersDAOImpl trainersDAO = new TrainersDAOImpl();
        Trainer trainer = trainersDAO.getById(Long.valueOf(request.getParameter("trainer_id")));
        trainersDAO.delete(trainer);

        response.sendRedirect("/managers/trainersList");
    }

}