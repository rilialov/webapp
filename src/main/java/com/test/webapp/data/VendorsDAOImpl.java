package com.test.webapp.data;

import com.test.webapp.model.Vendor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VendorsDAOImpl implements DAO<Vendor> {

    @Override
    public Vendor get(DBConnector dbConnector, long id) {
        Vendor vendor = null;
        ResultSet resultSet = dbConnector.getQuery("SELECT * FROM vendors WHERE id = " + id + ";");

        if (resultSet != null) {
            try {
                resultSet.next();
                vendor = new Vendor(resultSet.getString(2));
                vendor.setId(resultSet.getLong(1));
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
                    vendor.setId(resultSet.getLong(1));
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
                "SET vendor_name = ? WHERE id = ?");
        try {
            ps.setString(1, array[1]);
            ps.setLong(2, Integer.parseInt(array[0]));
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(DBConnector dbConnector, long id) {
        dbConnector.execute("DELETE FROM vendors WHERE id = " + id + ";");
    }
}
