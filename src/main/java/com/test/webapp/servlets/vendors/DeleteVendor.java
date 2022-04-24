package com.test.webapp.servlets.vendors;

import com.test.webapp.dao.VendorsDAOImpl;
import com.test.webapp.entity.Vendor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "deleteVendor", value = "/managers/deleteVendor")
public class DeleteVendor extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        VendorsDAOImpl vendorsDAO = new VendorsDAOImpl();
        Vendor vendor = vendorsDAO.getById(Long.valueOf(request.getParameter("vendor_id")));
        vendorsDAO.delete(vendor);

        response.sendRedirect("/managers/vendorsList");
    }

}