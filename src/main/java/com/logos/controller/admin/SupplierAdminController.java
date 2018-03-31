package com.logos.controller.admin;

import com.logos.editor.CategoryCollectionEditor;
import com.logos.editor.ProductCollectionEditor;
import com.logos.entity.Address;
import com.logos.entity.Product;
import com.logos.entity.Supplier;
import com.logos.service.*;
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
@RequestMapping(value = "/admin/supplier")
public class SupplierAdminController {

    @Autowired
    private SupplierService supplierService;
    @Autowired
    private AddressService addressService;
    @Autowired
    private CountryService countryService;
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private Validator supplierValidator;

    @InitBinder("supplier")
    public void initSupplierBinder(WebDataBinder binder) {
        binder.registerCustomEditor(List.class, "product", new ProductCollectionEditor(productService));
        binder.registerCustomEditor(List.class, "categories", new CategoryCollectionEditor(categoryService));
        binder.setValidator(supplierValidator);
    }

    @RequestMapping(method = RequestMethod.GET)
    public String showSupplierPage(Model model) {
        model.addAttribute("suppliers", supplierService.findAll());

        return "admin/supplier/allSuppliers";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showAddSupplierPage(Model model) {
        model.addAttribute("supplier", new Supplier());

        return "admin/supplier/addSupplier";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveSupplier(@Validated Supplier supplier, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "admin/supplier/addSupplier";
        }

        supplierService.save(supplier);

        return "redirect:/admin/supplier";
    }

    @RequestMapping(value = "/{id}/address/new", method = RequestMethod.GET)
    public String addAddressToSupplier(@PathVariable int id, Model model) {
        Address address = new Address();
        Supplier supplier = new Supplier();

        supplier.setId(id);
        address.setSupplier(supplier);

        model.addAttribute("address", address);
        model.addAttribute("countries", countryService.findAll());

        return "admin/supplier/supplierNewAddress";
    }

    @RequestMapping(value = "/address/save", method = RequestMethod.POST)
    public String addAddressToSupplier(@ModelAttribute Address address) {
        addressService.save(address);

        return "redirect:/admin/supplier/" + address.getSupplier().getId() + "/details";
    }

    @RequestMapping(value = "/{id}/address/{deleteId}/delete", method = RequestMethod.GET)
    public String deleteAddress(@PathVariable int id, @PathVariable int deleteId) {
        addressService.delete(deleteId);

        return "redirect:/admin/supplier/" + id + "/details";
    }

    @RequestMapping(value = "/{id}/product/new", method = RequestMethod.GET)
    public String addProductToSupplier(@PathVariable int id, Model model) {
        Product product = new Product();
        Supplier supplier = new Supplier();

        supplier.setId(id);
        product.setSupplier(supplier);

        model.addAttribute("product", product);
        model.addAttribute("categories", categoryService.findAll());

        return "admin/supplier/supplierNewProduct";
    }

    @RequestMapping(value = "/product/save", method = RequestMethod.POST)
    public String addProductToSupplier(@ModelAttribute Product product) {
        productService.save(product);

        return "redirect:/admin/supplier";
    }

    @RequestMapping(value = "/{id}/product/{deleteId}/delete", method = RequestMethod.GET)
    public String deleteProduct(@PathVariable int id, @PathVariable int deleteId) {
        Product product = productService.findOne(deleteId);
        product.setSupplier(null);
        productService.save(product);

        return "redirect:/admin/supplier/" + id + "/details";
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public String deleteSupplier(@PathVariable int id) {
        supplierService.delete(id);
        return "redirect:/admin/supplier";
    }

    @RequestMapping(value = "/{id}/details", method = RequestMethod.GET)
    public String showDetailsPage(@PathVariable int id, Model model){
        Supplier supplier = supplierService.findOne(id);

        model.addAttribute("supplier", supplier);
        return "admin/supplier/supplierDetails";
    }
}
