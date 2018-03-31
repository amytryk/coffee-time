package com.logos.service;


import com.logos.entity.Supplier;

import java.util.List;

public interface SupplierService {

    void save(Supplier supplier);

    List<Supplier> findAll();

    Supplier findOne(int id);

    void delete(int id);

    List<Supplier> findSuppliersWithAddress();

    List<Supplier> findSuppliersWithProducts();
}
