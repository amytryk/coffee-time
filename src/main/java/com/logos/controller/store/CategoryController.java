package com.logos.controller.store;

import com.logos.dto.CategoryDTO;
import com.logos.dto.ProductDTO;
import com.logos.entity.Category;
import com.logos.entity.Product;
import com.logos.service.CategoryService;
import com.logos.util.ConverterUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping(value = "/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private Converter<Product, ProductDTO> productToDTOConverter;

    @Autowired
    private Converter<Category, CategoryDTO> categoryToDTOConverter;


    @RequestMapping(value = "/{id}/products", method = RequestMethod.GET)
    public String showCategoryProducts(@PathVariable int id, Model model) {
        Category category = categoryService.findOne(id);
        Set<Product> products = new HashSet();

        categoryService.fillAllProducts(category, products);

        model.addAttribute("products", ConverterUtil.convertAll(new ArrayList<>(products), productToDTOConverter));

        return "store/home";
    }

    @RequestMapping(value = "/root", method = RequestMethod.GET)
    public
    @ResponseBody
    CategoryDTO getRootCategory() {
        Category root = categoryService.findOne(1);
        CategoryDTO categoryDTO = categoryToDTOConverter.convert(root);

        categoryDTO.setSubcategories(ConverterUtil.convertAll(root.getSubcategories(), categoryToDTOConverter));

        return categoryDTO;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public
    @ResponseBody
    CategoryDTO getCategory(@PathVariable int id) {
        Category category = categoryService.findOne(id);
        CategoryDTO categoryDTO = categoryToDTOConverter.convert(category);

        categoryDTO.setSubcategories(ConverterUtil.convertAll(category.getSubcategories(), categoryToDTOConverter));

        return categoryDTO;
    }
}
