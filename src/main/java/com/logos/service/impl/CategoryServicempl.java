package com.logos.service.impl;

import com.logos.dao.CategoryDao;
import com.logos.entity.Category;
import com.logos.entity.Product;
import com.logos.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class CategoryServicempl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;


    @Override
    public void save(Category category) {
        categoryDao.save(category);
    }

    @Override
    public List<Category> findAll() {
        return categoryDao.findAll();
    }

    @Override
    public Category findOne(int id) {
        return categoryDao.findOne(id);
    }

    @Override
    public void delete(int id) {
        categoryDao.delete(id);
    }

    @Override
    public void fillAllProducts(Category category, Set<Product> products) {
        products.addAll(category.getProducts());

        for (Category cat: category.getSubcategories()) {
            fillAllProducts(cat, products);
        }
    }
}

