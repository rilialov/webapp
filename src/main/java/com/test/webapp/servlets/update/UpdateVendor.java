package com.test.webapp.servlets.update;

import com.test.webapp.data.DBController;
import com.test.webapp.data.VendorsDAO;
import com.test.webapp.model.Vendor;
import com.test.webapp.sessions.UserAccount;
import com.test.webapp.sessions.UsersSessions;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "updateVendor", value = "/managers/updateVendor")
public class UpdateVendor extends HttpServlet {
    private int vendor_id;
    private VendorsDAO vendorsDAO;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserAccount userAccount = UsersSessions.getUser(request.getSession());
        DBController db = UsersSessions.getDbController(userAccount);
        vendorsDAO = db.getVendorsDAO();

        vendor_id = Integer.parseInt(request.getParameter("vendor_id"));
        Vendor vendor = vendorsDAO.get(db.getDbConnector(), vendor_id);

        request.setAttribute("title", "Update");
        request.setAttribute("vendor", vendor);
        request.setAttribute("create", "update");
        getServletContext().getRequestDispatcher("/WEB-INF/views/create-update/Vendor.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");

        String[] array = new String[2];
        array[0] = String.valueOf(vendor_id);
        array[1] = request.getParameter("vendorName");

        UserAccount userAccount = UsersSessions.getUser(request.getSession());
        DBController db = UsersSessions.getDbController(userAccount);
        vendorsDAO.update(db.getDbConnector(), array);

        response.sendRedirect("/managers/vendorsList");
    }

}