package com.logos.validator;

import com.logos.entity.Product;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ProductValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return Product.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Product product = (Product) target;

        if (product.getName().isEmpty()) {
            errors.rejectValue("name", "field.required");
        } else if (!validateLettersWithDigits(product.getName())) {
            errors.rejectValue("name", "field.invalid.characters");
        }
    }

    private boolean validateLettersWithDigits(String string) {
        return string.matches("^[\\p{L} \\p{Digit} .'-]+$");
    }
}
