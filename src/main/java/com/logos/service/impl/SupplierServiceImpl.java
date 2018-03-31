package com.logos.service.impl;

import com.logos.dao.ProductDao;
import com.logos.dao.SupplierDao;
import com.logos.entity.Product;
import com.logos.entity.Supplier;
import com.logos.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.OneToOne;
import java.util.Collections;
import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierDao supplierDao;
    @Autowired
    private ProductDao productDao;

    @Override
    public void save(Supplier supplier) {
        supplierDao.save(supplier);
    }

    @Override
    public List<Supplier> findAll() {
        return supplierDao.findAll();
    }

    @Override
    public Supplier findOne(int id) {
        return supplierDao.findOne(id);
    }

    @Override
    public void delete(int id) {
        Supplier supplier = supplierDao.findSupplierWithProducts(id);

        for(Product product: supplier.getProductses()) {
            product.setSupplier(null);
            productDao.save(product);
        }

        supplierDao.delete(id);
    }

    @Override
    public List<Supplier> findSuppliersWithAddress() {
        return supplierDao.findSuppliersWithAddress();
    }

    @Override
    public List<Supplier> findSuppliersWithProducts() {
        return supplierDao.findSuppliersWithProducts();
    }

}
