package com.logos.controller.store;

import com.logos.dto.ProductDTO;
import com.logos.entity.Product;
import com.logos.service.ProductService;
import com.logos.util.ConverterUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ProductService productService;

    @Autowired
    private Converter<Product, ProductDTO> productToDTOConverter;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showHomePage(Model model) {
        List<Product> products = productService.findAll();

        model.addAttribute("products", ConverterUtil.convertAll(products, productToDTOConverter));

        return "store/home";
    }
}
