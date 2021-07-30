package com.test.webapp.servlets.update;

import com.test.webapp.data.DBController;
import com.test.webapp.data.TrainersData;
import com.test.webapp.model.Trainer;
import com.test.webapp.sessions.UserAccount;
import com.test.webapp.sessions.UsersSessions;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "updateTrainer", value = "/updateTrainer")
public class UpdateTrainer extends HttpServlet {
    private int trainer_id;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserAccount userAccount = UsersSessions.getUser(request.getSession());
        DBController db = UsersSessions.getDbController(userAccount);

        trainer_id = Integer.parseInt(request.getParameter("trainer_id"));
        Trainer trainer = TrainersData.getTrainerData(db.getDbConnector(), trainer_id);
        request.setAttribute("trainer", trainer);
        getServletContext().getRequestDispatcher("/views/update/updateTrainer.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");

        String[] array = new String[3];
        array[0] = String.valueOf(trainer_id);
        array[1] = request.getParameter("firstname");
        array[2] = request.getParameter("lastname");

        UserAccount userAccount = UsersSessions.getUser(request.getSession());
        DBController db = UsersSessions.getDbController(userAccount);
        TrainersData.updateTrainer(db.getDbConnector(), array);

        List<Trainer> list = TrainersData.getTrainersData(db.getDbConnector());
        request.setAttribute("trainersList", list);
        getServletContext().getRequestDispatcher("/views/lists/trainersList.jsp").forward(request, response);
    }
}