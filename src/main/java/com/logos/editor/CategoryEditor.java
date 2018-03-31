package com.logos.editor;


import com.logos.service.CategoryService;

import java.beans.PropertyEditorSupport;

public class CategoryEditor extends PropertyEditorSupport {

    private final CategoryService categoryService;

    public CategoryEditor(CategoryService categoryService) {
        super();
        this.categoryService = categoryService;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        setValue(categoryService.findOne(Integer.parseInt(text)));
    }
}
