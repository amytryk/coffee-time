package com.logos.service;

import com.logos.entity.Product;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {

    void save(Product product);
    void save(Product product, MultipartFile multipartFile);

    List<Product> findAll();
    Product findOne(int id);
    void delete(int id);

    List<Product> findProductsWithCategory();








}
