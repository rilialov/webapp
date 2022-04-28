package com.test.webapp.dao;

import com.test.webapp.entity.Vendor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class VendorsDAOImplTest {

    private VendorsDAOImpl vendorsDAO;

    @BeforeEach
    void init() {
        vendorsDAO = new VendorsDAOImpl();
    }

    @Test
    void getById() {
        Vendor vendor = vendorsDAO.getById(1L);

        Assertions.assertNotNull(vendor);
    }

    @Test
    void getAll() {
        List<Vendor> vendors = vendorsDAO.getAll();

        Assertions.assertNotNull(vendors);
        Assertions.assertTrue(vendors.size() > 0);
    }

    @Test
    void create() {
        Vendor vendor = new Vendor("TestVendor");
        Vendor created = vendorsDAO.create(vendor);

        vendorsDAO.delete(created);
        Assertions.assertNotNull(created);
    }

    @Test
    void update() {
        Vendor vendor = new Vendor("TestVendor");
        Vendor created = vendorsDAO.create(vendor);

        created.setVendorName("ChangedVendor");
        vendorsDAO.update(created);

        Vendor updated = vendorsDAO.getById(created.getId());

        vendorsDAO.delete(created);
        Assertions.assertEquals("ChangedVendor", updated.getVendorName());
    }

    @Test
    void delete() {
        Vendor vendor = new Vendor("TestVendor");
        Vendor created = vendorsDAO.create(vendor);

        vendorsDAO.delete(created);

        Vendor deleted = vendorsDAO.getById(created.getId());
        Assertions.assertNull(deleted);
    }
}