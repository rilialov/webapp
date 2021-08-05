package com.test.webapp.model;

public class Vendor {
    private int id;
    private final String vendorName;

    public Vendor(String vendorName) {
        this.vendorName = vendorName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVendorName() {
        return vendorName;
    }
}
