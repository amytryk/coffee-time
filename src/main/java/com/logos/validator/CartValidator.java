package com.logos.validator;

import com.logos.dao.CustomerDao;
import com.logos.entity.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class CartValidator implements Validator {

    @Autowired
    private CustomerDao customerDao;

    @Override
    public boolean supports(Class<?> aClass) {
        return Cart.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Cart cart = (Cart) target;

        if (cart.getCustomer() == null) {
            errors.rejectValue("customer", "cart.customer.notexists");
        }

        if (cart.getDate() == null) {
            errors.rejectValue("date", "field.required");
        }
    }

}
