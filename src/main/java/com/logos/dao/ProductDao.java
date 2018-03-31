package com.logos.dao;

import com.logos.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductDao extends JpaRepository<Product, Integer> {

    @Query("select distinct p from Product p left join fetch p.categories")
    List<Product> findProductsWithCategory();

}
