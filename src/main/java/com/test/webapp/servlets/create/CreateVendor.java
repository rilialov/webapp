package com.test.webapp.servlets.create;

import com.test.webapp.dao.VendorsDAOImpl;
import com.test.webapp.entity.Vendor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "createVendor", value = "/managers/createVendor")
public class CreateVendor extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("title", "Create");
        request.setAttribute("create", "create");
        getServletContext().getRequestDispatcher("/WEB-INF/views/create-update/Vendor.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        Vendor vendor = new Vendor(request.getParameter("vendorName"));

        VendorsDAOImpl vendorsDAOImpl = new VendorsDAOImpl();
        vendorsDAOImpl.create(vendor);

        response.sendRedirect("/managers/vendorsList");
    }

}