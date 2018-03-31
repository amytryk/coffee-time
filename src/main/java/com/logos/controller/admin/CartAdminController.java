package com.logos.controller.admin;

import com.logos.editor.CustomerEditor;
import com.logos.editor.LocalDateEditor;
import com.logos.editor.ShippingEditor;
import com.logos.entity.*;
import com.logos.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping(value = "/admin/cart")
public class CartAdminController {

    @Autowired
    private CartService cartService;

    @Autowired
    private ProductService productService;

    @Autowired
    private CartEntryService cartEntryService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ShippingService shippingService;

    @Autowired
    private Validator cartValidator;

    @InitBinder("cart")
    public void initCartBinder(WebDataBinder binder) {
        binder.registerCustomEditor(LocalDate.class, new LocalDateEditor());
        binder.registerCustomEditor(Customer.class, new CustomerEditor(customerService));
        binder.registerCustomEditor(Shipping.class, new ShippingEditor(shippingService));
        binder.setValidator(cartValidator);
    }

    @RequestMapping(method = RequestMethod.GET)
    public String showCartPage(Model model) {
        model.addAttribute("carts", cartService.findCartWithCartEntries());

        return "admin/cart/allCarts";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showAddCartPage(Model model){
        Cart cart = new Cart();
        cart.setDate(LocalDate.now());

        model.addAttribute("cart", cart);

        return "admin/cart/addCart";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String addCart(@Validated Cart cart, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "admin/cart/addCart";
        }

        cartService.save(cart);

        return "redirect:/admin/cart";
    }



    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public String deleteCart(@PathVariable int id) {
        cartService.delete(id);

        return "redirect:/admin/cart";
    }

    @RequestMapping(value = "/{id}/cartEntry/new", method = RequestMethod.GET)
    public String addCartEntryToCart(@PathVariable int id, Model model) {
        CartEntry cartEntry = new CartEntry();
        Cart cart = new Cart();

        cart.setId(id);
        cartEntry.setCart(cart);

        model.addAttribute("cartEntry", cartEntry);
        model.addAttribute("products", productService.findAll());

        return "admin/cart/addCartEntry";
    }

    @RequestMapping(value = "/cartEntry/save", method = RequestMethod.POST)
    public String addCartEntryToCart(@ModelAttribute CartEntry cartEntry) {
        cartEntryService.save(cartEntry);

        return "redirect:/admin/cart/" + cartEntry.getCart().getId() + "/details";
    }

    @RequestMapping(value = "/{cartId}/cartEntry/{id}/delete", method = RequestMethod.GET)
    public String deleteCartEntry(@PathVariable int cartId, @PathVariable int id) {
        cartEntryService.delete(id);

        return "redirect:/admin/cart/" + cartId + "/details";
    }

    @RequestMapping(value = "/{id}/details", method = RequestMethod.GET)
    public String showDetailsPage(@PathVariable int id, Model model){
        Cart cart = cartService.findOne(id);

        model.addAttribute("cart", cart);
        return "admin/cart/cartDetails";
    }

    @RequestMapping(value = "/{id}/shipping/change", method = RequestMethod.GET)
    public String shippingChange(@PathVariable int id, Model model) {
        List<Shipping> shippingsToSelect = shippingService.findAll();
        Cart cart = new Cart();
        cart.setId(id);

        model.addAttribute("shippingsToSelect", shippingsToSelect);
        model.addAttribute("cart", cart);

        return "admin/cart/changeShipping";
    }

    @RequestMapping(value = "/{id}/shipping/change", method = RequestMethod.POST)
    public String saveSupplier(@ModelAttribute Cart cart, @PathVariable int id) {
        Cart cartToSave = cartService.findOne(id);

        cartToSave.setShipping(cart.getShipping());
        cartService.save(cartToSave);

        return "redirect:/admin/cart/" + id + "/details";
    }

    @RequestMapping(value = "/{id}/shipping/delete", method = RequestMethod.GET)
    public String deleteSupplier(@PathVariable int id) {
        Cart cart = cartService.findOne(id);
        cart.setShipping(null);

        cartService.save(cart);

        return "redirect:/admin/cart/" + id + "/details";
    }
}
