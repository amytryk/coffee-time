package com.logos.service;

import com.logos.entity.Category;
import com.logos.entity.Product;

import java.util.List;
import java.util.Set;

public interface CategoryService {

    void save(Category category);
    List<Category> findAll();
    Category findOne(int id);
    void delete(int id);

    void fillAllProducts(Category category, Set<Product> products);
}
