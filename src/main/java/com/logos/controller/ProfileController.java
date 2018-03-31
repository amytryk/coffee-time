package com.logos.controller;

import com.logos.dto.CustomerDTO;
import com.logos.dto.DtoUtilMapper;
import com.logos.entity.Address;
import com.logos.entity.Customer;
import com.logos.service.AddressService;
import com.logos.service.CountryService;
import com.logos.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;

@Controller
@RequestMapping(value = "/profile")
public class ProfileController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private CountryService countryService;
    @Autowired
    private AddressService addressService;

    @RequestMapping(method = RequestMethod.GET)
    public String showProfilePage(Principal principal, Model model) {
        Customer customer = customerService.searchByEmail(principal.getName());

        model.addAttribute("customer", DtoUtilMapper.customerToCustomerDTO(customer));
        model.addAttribute("countries", countryService.findAll());
        model.addAttribute("newAddress", new Address());

        return "profile";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveProfile(@ModelAttribute CustomerDTO customerDto, Principal principal) {
        Customer customer = customerService.searchByEmail(principal.getName());

        customerService.update(DtoUtilMapper.customerDTOToCustomer(customerDto, customer));

        return "redirect:/profile";
    }

    @RequestMapping(value = "/image/save", method = RequestMethod.POST)
    public String saveImage(Principal principal, @RequestParam MultipartFile image) {

        customerService.saveImage(principal, image);

        return "redirect:/profile";
    }


    @RequestMapping(value = "/address/save", method = RequestMethod.POST)
    public String saveAddress(@ModelAttribute Address address, Principal principal) {
        Customer customer = customerService.searchByEmail(principal.getName());

        address.setCustomer(customer);
        addressService.save(address);

        return "redirect:/profile";
    }

    @RequestMapping(value = "/address/{id}/delete", method = RequestMethod.GET)
    public String deleteAddress(@PathVariable int id) {
        addressService.delete(id);

        return "redirect:/profile";
    }
}
