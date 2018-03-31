package com.logos.controller.admin;

/**
 * Created by Anzhelika on 11/15/2016.
 */

import com.logos.entity.Address;
import com.logos.entity.Customer;
import com.logos.service.AddressService;
import com.logos.service.CountryService;
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
@RequestMapping(value = "/admin/customer")
public class CustomerAdminController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private AddressService addressService;
    @Autowired
    private CountryService countryService;
    @Autowired
    private MailSenderService mailSenderService;

    @Autowired
    private Validator customerValidator;

    @InitBinder("customer")
    public void initCustomerBinder(final WebDataBinder binder) {
        binder.setValidator(customerValidator);
    }

    @RequestMapping(method = RequestMethod.GET)
    public String showCustomerPage(Model model) {
        model.addAttribute("customers", customerService.findCustomersWithAddress());

        return "admin/customer/allCustomers";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showAddCustomerPage(Model model) {
        model.addAttribute("customer", new Customer());

        return "admin/customer/addCustomer";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String addCustomer(@Validated Customer customer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "admin/customer/addCustomer";
        }

//        String uuid = UUID.randomUUID().toString();
//        customer.setUuid(uuid);
        customer.setEnabled(true); // TODO remove
        customerService.save(customer);

//        String theme = "thanks for registration";
//        String mailBody = "http://localhost:8080/admin/customer/confirm/" + uuid;
//        mailSenderService.sendMail(theme, mailBody, customer.getEmail());

        return "redirect:/admin/customer";
    }

    @RequestMapping(value = "/confirm/{uuid}", method = RequestMethod.GET)
    public String confirm(@PathVariable String uuid) {
        Customer customer = customerService.findByUUID(uuid);
        customer.setEnabled(true);

        customerService.update(customer);

        return "redirect:/admin/customer";
    }

    @RequestMapping(value = "/{id}/address/new", method = RequestMethod.GET)
    public String addAddressToCustomer(@PathVariable int id, Model model) {
        Address address = new Address();
        Customer customer = new Customer();

        customer.setId(id);
        address.setCustomer(customer);

        model.addAttribute("address", address);
        model.addAttribute("countries", countryService.findAll());

        return "admin/customer/customerNewAddress";
    }


    @RequestMapping(value = "/address/save", method = RequestMethod.POST)
    public String addAddressToCustomer(@ModelAttribute Address address) {
        addressService.save(address);

        return "redirect:/admin/customer";
    }

    @RequestMapping(value = "/address/{id}/delete", method = RequestMethod.GET)
    public String deleteAddress(@PathVariable int id) {
        addressService.delete(id);

        return "redirect:/admin/customer";
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public String deleteCustomer(@PathVariable int id) {
        customerService.delete(id);

        return "redirect:/admin/customer";
    }

    @RequestMapping(value = "/{id}/details", method = RequestMethod.GET)
    public String showDetailsPage(@PathVariable int id, Model model) {
        Customer customer = customerService.findOne(id);
        model.addAttribute("customer", customer);

        return "admin/customer/customerDetails";
    }
}
