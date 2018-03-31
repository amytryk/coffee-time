package com.logos.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "category_category",
            joinColumns =  @JoinColumn(name = "source_id"),
            inverseJoinColumns = @JoinColumn(name = "target_id"))
    private List<Category> subcategories;


    @ManyToMany
    @JoinTable(name = "category_category",
            joinColumns =  @JoinColumn(name = "target_id"),
            inverseJoinColumns = @JoinColumn(name = "source_id"))
    private List<Category> supercategories;


    @ManyToMany
    @JoinTable(name = "category_product",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products;


    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Category> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(List<Category> subcategories) {
        this.subcategories = subcategories;
    }

    public List<Category> getSupercategories() {
        return supercategories;
    }

    public void setSupercategories(List<Category> supercategories) {
        this.supercategories = supercategories;
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;

        if (obj instanceof Category) {
            result = ((Category) obj).id == this.id;
        }

        return result;
    }
}
