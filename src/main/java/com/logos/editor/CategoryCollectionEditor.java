package com.logos.editor;

import com.logos.entity.Category;
import com.logos.service.CategoryService;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;

import java.util.List;

/**
 * Created by Anzhelika on 12/11/2016.
 */
public class CategoryCollectionEditor extends CustomCollectionEditor {

    private final CategoryService categoryService;

    public CategoryCollectionEditor(CategoryService categoryService) {
        super(List.class);
        this.categoryService = categoryService;
    }

    @Override
    protected Object convertElement(Object element) {
        Category category = categoryService.findOne(Integer.parseInt(element.toString()));
        return category;
    }
}
