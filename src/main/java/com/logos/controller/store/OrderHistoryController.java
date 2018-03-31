package com.logos.controller.store;

import com.logos.dto.AddressDTO;
import com.logos.dto.CartDTO;
import com.logos.dto.ShipingDTO;
import com.logos.entity.Address;
import com.logos.entity.Cart;
import com.logos.entity.Customer;
import com.logos.entity.Shipping;
import com.logos.service.CartService;
import com.logos.service.CustomerService;
import com.logos.util.ConverterUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.List;

/**
 * Created by Anzhelika on 12/26/2016.
 */
@Controller
@RequestMapping(value = "/order/history")
public class OrderHistoryController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CartService cartService;

    @Autowired
    private Converter<Cart, CartDTO> cartToDTOShortConverter;

    @Autowired
    private Converter<Cart, CartDTO> cartToDTOFullConverter;

    @Autowired
    private Converter<Address, AddressDTO> addressToDTOConverter;

    @Autowired
    private  Converter<Shipping, ShipingDTO> shipingToDTOConverter;

    @RequestMapping(method = RequestMethod.GET)
    public String showOrderPage(Model model, Principal principal) {
        Customer customer = customerService.searchByEmail(principal.getName());
        List<Cart> carts = customer.getCarts();

        model.addAttribute("carts", ConverterUtil.convertAll(carts, cartToDTOShortConverter));

        return "store/orderHistory";
    }

    @RequestMapping(value = "/{id}/details", method = RequestMethod.GET)
    public String showDetailsPage(@PathVariable int id, Model model, Principal principal) {
        Customer customer = customerService.searchByEmail(principal.getName());
        List<Cart> carts = customer.getCarts();
        Cart selectedCart = null;

        for (Cart cart : carts) {
            if (cart.getId() == id) {
                selectedCart = cart;
                break;
            }
        }

        CartDTO cartDTO = cartToDTOFullConverter.convert(selectedCart);
        cartService.calculateTotal(cartDTO);

        model.addAttribute("cart", cartDTO);
        model.addAttribute("shippingMethod", shipingToDTOConverter.convert(selectedCart.getShipping()));
        model.addAttribute("shippingAddress", addressToDTOConverter.convert(selectedCart.getShippingAddress()));

        return "store/orderHistoryDetails";
    }

}
