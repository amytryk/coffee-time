package com.logos.controller.admin;

import com.logos.editor.CategoryCollectionEditor;
import com.logos.entity.Category;
import com.logos.entity.Product;
import com.logos.service.CategoryService;
import com.logos.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/admin/category")
public class CategoryAdminController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @Autowired
    private Validator categoryValidator;


    @InitBinder("category")
    public void initCategoryBinder(WebDataBinder binder) {
        binder.registerCustomEditor(List.class, "supercategories", new CategoryCollectionEditor(categoryService));
        binder.registerCustomEditor(List.class, "subcategories", new CategoryCollectionEditor(categoryService));
        binder.setValidator(categoryValidator);
    }

    @RequestMapping(method = RequestMethod.GET)
    public String showCategoryPage(Model model) {
        model.addAttribute("categories", categoryService.findAll());

        return "admin/category/allCategory";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addCategory(Model model) {
        model.addAttribute("category", new Category());

        return "admin/category/addCategory";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveCategory(@Validated Category category, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "admin/category/addCategory";
        }

        categoryService.save(category);

        return "redirect:/admin/category";
    }


    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public String delete(@PathVariable int id) {
        categoryService.delete(id);

        return "redirect:/admin/category";
    }

    @RequestMapping(value = "/{id}/details", method = RequestMethod.GET)
    public String showDetailsPage(@PathVariable int id, Model model){
        Category category = categoryService.findOne(id);
        model.addAttribute("category", category);

        return "admin/category/categoryDetails";
    }

    @RequestMapping(value = "/{id}/supercategories/add", method = RequestMethod.GET)
    public String addSuperCategories(@PathVariable int id, Model model){
        List<Category> categoriesToSelect = categoryService.findAll();
        Category category = new Category();

        category.setId(id);

        model.addAttribute("categoriesToSelect", categoriesToSelect);
        model.addAttribute("category", category);

        return "admin/category/addSuperCategories";
    }

    @RequestMapping(value = "/{id}/supercategories/add", method = RequestMethod.POST)
    public String saveSuperCategories(@ModelAttribute Category category, @PathVariable int id){
        Category categoryToSave = categoryService.findOne(id);

        categoryToSave.getSupercategories().addAll(category.getSupercategories());
        categoryService.save(categoryToSave);

        return "redirect:/admin/category/" + id + "/details";
    }

    @RequestMapping(value = "/{id}/supercategories/{deleteId}/delete", method = RequestMethod.GET)
    public String deleteSuperCategory(@PathVariable int id, @PathVariable int deleteId){
        Category category = categoryService.findOne(id);
        Category categoryToDelete = categoryService.findOne(deleteId);

        category.getSupercategories().remove(categoryToDelete);

        categoryService.save(category);

        return "redirect:/admin/category/" + id + "/details";
    }

    @RequestMapping(value = "/{id}/subcategories/add", method = RequestMethod.GET)
    public String addSubCategories(@PathVariable int id, Model model){
        List<Category> categoriesToSelect = categoryService.findAll();
        Category category = new Category();

        category.setId(id);

        model.addAttribute("categoriesToSelect", categoriesToSelect);
        model.addAttribute("category", category);

        return "admin/category/addSubCategories";
    }

    @RequestMapping(value = "/{id}/subcategories/add", method = RequestMethod.POST)
    public String saveSubCategories(@ModelAttribute Category category, @PathVariable int id){
        Category categoryToSave = categoryService.findOne(id);

        categoryToSave.getSubcategories().addAll(category.getSubcategories());
        categoryService.save(categoryToSave);

        return "redirect:/admin/category/" + id + "/details";
    }


    @RequestMapping(value = "/{id}/subcategories/{deleteId}/delete", method = RequestMethod.GET)
    public String deleteSubCategory(@PathVariable int id, @PathVariable int deleteId){
        Category category = categoryService.findOne(id);
        Category categoryToDelete = categoryService.findOne(deleteId);

        category.getSubcategories().remove(categoryToDelete);

        categoryService.save(category);

        return "redirect:/admin/category/" + id + "/details";
    }

    @RequestMapping(value = "/{id}/products/{deleteId}/delete", method = RequestMethod.GET)
    public String deleteProduct(@PathVariable int id, @PathVariable int deleteId){
        Category category = categoryService.findOne(id);
        Product productToDelete = productService.findOne(deleteId);

        category.getProducts().remove(productToDelete);

        categoryService.save(category);

        return "redirect:/admin/category/" + id + "/details";
    }
}
