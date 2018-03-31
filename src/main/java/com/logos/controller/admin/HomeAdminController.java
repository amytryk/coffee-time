package com.logos.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/admin")
public class HomeAdminController {

    @RequestMapping(method = RequestMethod.GET)
    public String showHomePage(){
        return "admin/home";
    }
}
