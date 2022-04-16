package com.test.webapp.entity;

import javax.persistence.*;

@Entity
@Table(name = "vendors")
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "vendor_name", nullable = false)
    private String vendorName;

    public Vendor() {
    }

    public Vendor(String vendorName) {
        this.vendorName = vendorName;
    }

    public long getId() {
        return id;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }
}