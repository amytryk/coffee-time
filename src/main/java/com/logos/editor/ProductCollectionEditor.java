package com.logos.editor;

import com.logos.entity.Product;
import com.logos.service.ProductService;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;

import java.util.Collection;
import java.util.List;

/**
 * Created by Anzhelika on 12/12/2016.
 */
public class ProductCollectionEditor extends CustomCollectionEditor {

    private final ProductService productService;

    public ProductCollectionEditor( ProductService productService) {
        super(List.class);
        this.productService = productService;
    }

    @Override
    protected Object convertElement(Object element) {
        Product product = productService.findOne(Integer.parseInt(element.toString()));
        return product;
    }
}
