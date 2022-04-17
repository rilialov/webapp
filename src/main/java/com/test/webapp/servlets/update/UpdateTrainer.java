package com.test.webapp.servlets.update;

import com.test.webapp.dao.TrainersDAOImpl;
import com.test.webapp.entity.Trainer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "updateTrainer", value = "/managers/updateTrainer")
public class UpdateTrainer extends HttpServlet {
    private Trainer trainer;
    private final TrainersDAOImpl trainersDAOImpl = new TrainersDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        trainer = trainersDAOImpl.getById(Long.valueOf(request.getParameter("trainer_id")));

        request.setAttribute("title", "Update");
        request.setAttribute("trainer", trainer);
        request.setAttribute("create", "update");
        getServletContext().getRequestDispatcher("/WEB-INF/views/create-update/Trainer.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");

        trainer.setFirstName(request.getParameter("firstname"));
        trainer.setLastName(request.getParameter("lastname"));

        trainersDAOImpl.update(trainer);

        response.sendRedirect("/managers/trainersList");
    }

}