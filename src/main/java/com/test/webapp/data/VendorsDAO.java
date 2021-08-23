package com.test.webapp.data;

import com.test.webapp.model.Vendor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VendorsDAO implements DAO<Vendor> {

    @Override
    public Vendor get(DBConnector dbConnector, int id) {
        Vendor vendor = null;
        ResultSet resultSet = dbConnector.getQuery("SELECT * FROM vendors WHERE vendor_id = " + id + ";");

        if (resultSet != null) {
            try {
                resultSet.next();
                vendor = new Vendor(resultSet.getString(2));
                vendor.setId(resultSet.getInt(1));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return vendor;
    }

    @Override
    public List<Vendor> getAll(DBConnector dbConnector) {
        ArrayList<Vendor> vendorsList = new ArrayList<>();
        ResultSet resultSet = dbConnector.getQuery("SELECT * FROM vendors;");

        if (resultSet != null) {
            try {
                resultSet.next();
                while (!resultSet.isAfterLast()) {
                    Vendor vendor = new Vendor(resultSet.getString(2));
                    vendor.setId(resultSet.getInt(1));
                    vendorsList.add(vendor);
                    resultSet.next();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return vendorsList;
    }

    @Override
    public void create(DBConnector dbConnector, String[] array) {
        PreparedStatement ps = dbConnector.getPreparedStatement("INSERT INTO " +
                "vendors(vendor_name) VALUES (?)");
        try {
            ps.setString(1, array[0]);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(DBConnector dbConnector, String[] array) {
        PreparedStatement ps = dbConnector.getPreparedStatement("UPDATE vendors " +
                "SET vendor_name = ? WHERE vendor_id = ?");
        try {
            ps.setString(1, array[1]);
            ps.setInt(2, Integer.parseInt(array[0]));
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(DBConnector dbConnector, int id) {
        dbConnector.execute("DELETE FROM vendors WHERE vendor_id = " + id + ";");
    }
}
