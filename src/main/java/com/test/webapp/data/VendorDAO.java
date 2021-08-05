package com.test.webapp.data;

import com.test.webapp.model.Vendor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VendorDAO implements DAO<Vendor> {

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

    }

    @Override
    public void update(DBConnector dbConnector, String[] array) {

    }

    @Override
    public void delete(DBConnector dbConnector, int id) {

    }
}
