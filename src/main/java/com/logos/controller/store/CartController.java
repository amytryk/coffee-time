package com.logos.controller.store;

import com.logos.dto.CartDTO;
import com.logos.dto.CartInfo;
import com.logos.dto.ProductDTO;
import com.logos.entity.Product;
import com.logos.form.CartForm;
import com.logos.service.CartService;
import com.logos.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @Autowired
    private ProductService productService;

    @Autowired
    private Converter<Product, ProductDTO> productToDTOConverter;

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    @ResponseBody

    public CartInfo getCartInfo(HttpServletRequest request) {
        CartInfo cartInfo = cartService.getCartInfo(request);

        return cartInfo;
    }

    @RequestMapping(value = "/product/add", method = RequestMethod.POST)
    public
    @ResponseBody
    CartInfo addToCart(@ModelAttribute CartForm cartForm, HttpServletRequest request) {
        Product product = productService.findOne(cartForm.getProductId());
        cartService.addProduct(productToDTOConverter.convert(product), cartForm.getQuantity(), request);

        CartInfo cartInfo = cartService.getCartInfo(request);

        return cartInfo;
    }

    @RequestMapping(value = "/product/update", method = RequestMethod.POST)
    public
    @ResponseBody
    String updateProductInCart(@ModelAttribute CartForm cartForm, HttpServletRequest request) {
        boolean isUpdated = cartService.updateProduct(cartForm.getProductId(), cartForm.getQuantity(), request);

        return Boolean.valueOf(isUpdated).toString();
    }

    @RequestMapping(value = "/product/{id}/delete", method = RequestMethod.GET)
    public String deleteProductInCart(@PathVariable int id, HttpServletRequest request) {
        cartService.deleteProduct(id, request);

        return "redirect:/cart";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String showCartPage(Model model, HttpServletRequest request) {
        CartDTO cart = cartService.getSessionCart(request);

        cartService.calculateTotal(cart);
        model.addAttribute("cart", cart);

        return "store/cart";
    }
}
