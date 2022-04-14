package com.test.webapp.model;

public class Vendor {
    private long id;
    private final String vendorName;

    public Vendor(String vendorName) {
        this.vendorName = vendorName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getVendorName() {
        return vendorName;
    }
}
