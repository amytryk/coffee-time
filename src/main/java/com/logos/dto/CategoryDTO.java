package com.logos.dto;

import java.util.List;

public class CategoryDTO {

    private int id;
    private String name;
    private List<CategoryDTO> subcategories;

    public CategoryDTO() {
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

    public List<CategoryDTO> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(List<CategoryDTO> subcategories) {
        this.subcategories = subcategories;
    }
}
