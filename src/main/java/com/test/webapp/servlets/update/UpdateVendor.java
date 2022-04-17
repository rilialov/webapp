package com.test.webapp.servlets.update;

import com.test.webapp.dao.VendorsDAOImpl;
import com.test.webapp.entity.Vendor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "updateVendor", value = "/managers/updateVendor")
public class UpdateVendor extends HttpServlet {
    private Vendor vendor;
    private final VendorsDAOImpl vendorsDAOImpl = new VendorsDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        vendor = vendorsDAOImpl.getById(Long.valueOf(request.getParameter("vendor_id")));

        request.setAttribute("title", "Update");
        request.setAttribute("vendor", vendor);
        request.setAttribute("create", "update");
        getServletContext().getRequestDispatcher("/WEB-INF/views/create-update/Vendor.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");

        vendor.setVendorName(request.getParameter("vendorName"));
        vendorsDAOImpl.update(vendor);

        response.sendRedirect("/managers/vendorsList");
    }

}