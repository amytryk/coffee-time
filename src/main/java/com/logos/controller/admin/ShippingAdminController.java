package com.logos.controller.admin;

import com.logos.entity.Shipping;
import com.logos.service.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/admin/shipping")
public class ShippingAdminController {

    @Autowired
    private ShippingService shippingService;

    @Autowired
    private Validator shippingValidator;

    @InitBinder("shipping")
    public void initShippingBinder(WebDataBinder binder) {
        binder.setValidator(shippingValidator);
    }

    @RequestMapping(method = RequestMethod.GET)
    public String showShippingPage(Model model){
        model.addAttribute("shipping", shippingService.findAll());

        return "admin/shipping/allShipping";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addShipping(Model model){
        model.addAttribute("shipping", new Shipping());

        return "admin/shipping/addShipping";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String addShipping(@Validated Shipping shipping, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "admin/shipping/addShipping";
        }

        shippingService.save(shipping);

        return "redirect:/admin/shipping";
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public String deleteShipping(@PathVariable int id){
        shippingService.delete(id);

        return "redirect:/admin/shipping";
    }
}
