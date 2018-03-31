package com.logos.validator;

import com.logos.dao.ShippingDao;
import com.logos.entity.Shipping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ShippingValidator implements Validator {

    @Autowired
    private ShippingDao shippingDao;

    @Override
    public boolean supports(Class<?> aClass) {
        return Shipping.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Shipping shipping = (Shipping) target;

        if (shipping.getName().isEmpty()) {
            errors.rejectValue("name", "field.required");
        } else if (!validateLettersWithDigits(shipping.getName())) {
            errors.rejectValue("name", "field.invalid.characters");
        } else if (shippingDao.findByName(shipping.getName()) != null) {
            errors.rejectValue("name", "supplier.name.exists");
        }
    }

    private boolean validateLettersWithDigits(String string) {
        return string.matches("^[\\p{L} \\p{Digit} .'-]+$");
    }
}
