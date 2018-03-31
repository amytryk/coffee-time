package com.logos.service.impl;


import com.logos.dao.ProductDao;
import com.logos.entity.Product;
import com.logos.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }

    @Override
    public Product findOne(int id) {
        return productDao.findOne(id);
    }

    @Override
    public void delete(int id) {
        productDao.delete(id);
    }

    @Override
    public List<Product> findProductsWithCategory() {
        return productDao.findProductsWithCategory();
    }

    @Override
    public void save(Product product) {
        productDao.save(product);
    }

    @Transactional
    @Override
    public void save(Product product, MultipartFile multipartFile) {
        String uuid = UUID.randomUUID().toString();
        String path = "/resources/productImages/" + uuid + "." + multipartFile.getContentType();
        File file = new File(System.getProperty("catalina.home") + path);

        try {
            file.mkdirs();
            multipartFile.transferTo(file);
            product.setImageUrl(path);
        } catch (IOException e) {
            System.out.println("error with file");
        }

        productDao.save(product);
    }

}


