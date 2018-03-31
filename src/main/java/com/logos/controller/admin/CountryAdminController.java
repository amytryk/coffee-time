package com.logos.controller.admin;

import com.logos.entity.Country;
import com.logos.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/admin/country")
public class CountryAdminController {

    @Autowired
    private CountryService countryService;

    @Autowired
    private Validator countryValidator;

    @InitBinder("country")
    public void initCountryBinder(final WebDataBinder binder) {
        binder.setValidator(countryValidator);
    }


    @RequestMapping(method = RequestMethod.GET)
    public String showCountryPage(Model model) {
        model.addAttribute("countries", countryService.findAll());

        return "admin/country/allCountry";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addCountry(Model model) {
        model.addAttribute("country", new Country());

        return "admin/country/addCountry";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String addCountry(@Validated Country country, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "admin/country/addCountry";
        }

        countryService.save(country);

        return "redirect:/admin/country";
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public String deleteCountry(@PathVariable int id) {
        countryService.delete(id);

        return "redirect:/admin/country";
    }

}
