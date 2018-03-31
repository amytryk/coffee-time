package com.logos.controller;

import com.logos.entity.Customer;
import com.logos.service.CustomerService;
import com.logos.service.MailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegistrationController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private MailSenderService mailSenderService;

    @Autowired
    private Validator customerValidator;

    @InitBinder("customer")
    public void initBinder(final WebDataBinder binder) {
        binder.setValidator(customerValidator);
    }


    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegisterPage(Model model) {
        model.addAttribute("customer", new Customer());

        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@Validated Customer customer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "register";
        }

//        String uuid = UUID.randomUUID().toString();
//        customer.setUuid(uuid);
        customer.setEnabled(true); //TODO remove when email validation enabled
        customerService.save(customer);

//        String theme = "thanks for registration";
//        String mailBody = "http://localhost:8080/confirmation" + uuid;
//        mailSenderService.sendMail(theme, mailBody, customer.getEmail());
        return "redirect:/login";

    }

    @RequestMapping(value = "/confirmation/{uuid}", method = RequestMethod.GET)
    public String confirm(@PathVariable String uuid) {
        Customer customer = customerService.findByUUID(uuid);
        customer.setEnabled(true);

        customerService.update(customer);

        return "redirect:/profile";
    }


}
