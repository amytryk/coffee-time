package com.logos.controller.store;

import com.logos.dto.AddressDTO;
import com.logos.dto.CartDTO;
import com.logos.dto.ShipingDTO;
import com.logos.entity.Address;
import com.logos.entity.Cart;
import com.logos.entity.Customer;
import com.logos.entity.Shipping;
import com.logos.form.CheckoutForm;
import com.logos.service.AddressService;
import com.logos.service.CartService;
import com.logos.service.CustomerService;
import com.logos.service.ShippingService;
import com.logos.util.ConverterUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;

/**
 * Created by Anzhelika on 12/25/2016.
 */
@Controller
@RequestMapping(value = "/checkout")
public class CheckoutController {

    @Autowired
    private CartService cartService;

    @Autowired
    private ShippingService shippingService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private Converter<CartDTO, Cart> cartDTOToCartConverter;

    @Autowired
    private Converter<Shipping, ShipingDTO> shippingToDTOConverter;

    @Autowired
    private Converter<Address, AddressDTO> addressToDTOConverter;


    @RequestMapping(method = RequestMethod.GET)
    public String showCheckoutPage(Model model, Principal principal) {
        List<Shipping> shippingList = shippingService.findAll();
        Customer customer = customerService.searchByEmail(principal.getName());

        model.addAttribute("shippingList", ConverterUtil.convertAll(shippingList, shippingToDTOConverter));
        model.addAttribute("addressList", ConverterUtil.convertAll(customer.getAddress(), addressToDTOConverter));
        model.addAttribute("checkoutForm", new CheckoutForm());

        return "store/checkout";
    }

    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public String saveCart(@ModelAttribute CheckoutForm checkoutForm, Principal principal, HttpServletRequest request) {
        CartDTO cartDTO = cartService.getSessionCart(request);
        Cart cart = cartDTOToCartConverter.convert(cartDTO);
        Customer customer = customerService.searchByEmail(principal.getName());
        Shipping shipping = shippingService.findOne(checkoutForm.getShippingId());
        Address address = addressService.findOne(checkoutForm.getShippingAddressId());

        cart.setCustomer(customer);
        cart.setShipping(shipping);
        cart.setShippingAddress(addressService.clone(address));

        cartService.saveFully(cart);
        cartService.removeSessionCart(request);

        return "redirect:/checkout/summary";
    }

    @RequestMapping(value="/summary", method = RequestMethod.GET)
    public String showSummaryPage() {

        return "store/summary";
    }
}
