package com.logos.controller.admin;

import com.logos.editor.CategoryCollectionEditor;
import com.logos.editor.PriceCollectionEditor;
import com.logos.editor.SupplierEditor;
import com.logos.entity.*;
import com.logos.service.CategoryService;
import com.logos.service.PriceService;
import com.logos.service.ProductService;
import com.logos.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping(value = "/admin/product")
public class ProductAdminController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private SupplierService supplierService;
    @Autowired
    private PriceService priceService;

    @Autowired
    private Validator productValidator;

    @InitBinder("product")
    public void initCustomerBinder(WebDataBinder binder) {
        binder.registerCustomEditor(List.class, "categories", new CategoryCollectionEditor(categoryService));
        binder.registerCustomEditor(List.class, "prices", new PriceCollectionEditor(priceService));
        binder.registerCustomEditor(Supplier.class, new SupplierEditor(supplierService));
        binder.setValidator(productValidator);
    }

    @RequestMapping(method = RequestMethod.GET)
    public String showProductPage(Model model) {
        model.addAttribute("products", productService.findProductsWithCategory());

        return "admin/product/allProduct";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showAddProductPage(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("categories", categoryService.findAll());
        return "admin/product/addProduct";
    }


    @RequestMapping(value = "/{id}/price/new", method = RequestMethod.GET)
    public String addPriceToProduct(@PathVariable int id, Model model) {
        Price price = new Price();
        Product product = new Product();

        product.setId(id);
        price.setProduct(product);

        model.addAttribute("price", price);
        model.addAttribute("currencies", Currency.values());

        return "admin/product/productNewPrice";
    }

    @RequestMapping(value = "/price/save", method = RequestMethod.POST)
    public String addPriceToProduct(@ModelAttribute Price price) {
        priceService.save(price);

        return "redirect:/admin/product/" + price.getProduct().getId() + "/details";
    }

    @RequestMapping(value = "{id}/price/{deleteId}/delete", method = RequestMethod.GET)
    public String deletePrice(@PathVariable int id, @PathVariable int deleteId) {
        priceService.delete(deleteId);

        return "redirect:/admin/product/" + id + "/details";
    }


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String addProduct(@Validated Product product, BindingResult bindingResult, @RequestParam MultipartFile image, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("categories", categoryService.findAll());

            return "admin/product/addProduct";
        }

        productService.save(product, image);

        return "redirect:/admin/product";
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public String deleteProduct(@PathVariable int id) {
        productService.delete(id);

        return "redirect:/admin/product";
    }

    @RequestMapping(value = "/{id}/details", method = RequestMethod.GET)
    public String showDetailsPage(@PathVariable int id, Model model) {
        Product product = productService.findOne(id);
        model.addAttribute("product", product);

        return "admin/product/productDetails";
    }

    @RequestMapping(value = "/{id}/categories/add", method = RequestMethod.GET)
    public String addSubCategories(@PathVariable int id, Model model) {
        List<Category> categoriesToSelect = categoryService.findAll();
        Product product = new Product();

        product.setId(id);

        model.addAttribute("categoriesToSelect", categoriesToSelect);
        model.addAttribute("product", product);

        return "admin/product/addCategories";
    }

    @RequestMapping(value = "/{id}/categories/add", method = RequestMethod.POST)
    public String saveSubCategories(@ModelAttribute Product product, @PathVariable int id) {
        Product productToSave = productService.findOne(id);

        productToSave.getCategories().addAll(product.getCategories());
        productService.save(productToSave);

        return "redirect:/admin/product/" + id + "/details";
    }


    @RequestMapping(value = "/{id}/categories/{deleteId}/delete", method = RequestMethod.GET)
    public String deleteSubCategory(@PathVariable int id, @PathVariable int deleteId) {
        Product product = productService.findOne(id);
        Category categoryToDelete = categoryService.findOne(deleteId);

        product.getCategories().remove(categoryToDelete);

        productService.save(product);

        return "redirect:/admin/product/" + id + "/details";
    }

    @RequestMapping(value = "/{id}/supplier/change", method = RequestMethod.GET)
    public String supplierChange(@PathVariable int id, Model model) {
        List<Supplier> suppliersToSelect = supplierService.findAll();
        Product product = new Product();

        product.setId(id);

        model.addAttribute("suppliersToSelect", suppliersToSelect);
        model.addAttribute("product", product);

        return "admin/product/changeSupplier";
    }

    @RequestMapping(value = "/{id}/supplier/change", method = RequestMethod.POST)
    public String saveSupplier(@ModelAttribute Product product, @PathVariable int id) {
        Product productToSave = productService.findOne(id);

        productToSave.setSupplier(product.getSupplier());
        productService.save(productToSave);

        return "redirect:/admin/product/" + id + "/details";
    }


    @RequestMapping(value = "/{id}/supplier/delete", method = RequestMethod.GET)
    public String deleteSupplier(@PathVariable int id) {
        Product product = productService.findOne(id);
        product.setSupplier(null);

        productService.save(product);

        return "redirect:/admin/product/" + id + "/details";
    }

}
