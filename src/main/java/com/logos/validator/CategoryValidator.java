package com.logos.validator;

import com.logos.entity.Category;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class CategoryValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return Category.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Category category = (Category) target;

        if (category.getName().isEmpty()) {
            errors.rejectValue("name", "field.required");
        } else if (!validateLettersWithDigits(category.getName())) {
            errors.rejectValue("name", "field.invalid.characters");
        }
    }

    private boolean validateLettersWithDigits(String string) {
        return string.matches("^[\\p{L} \\p{Digit} .'-]+$");
    }
}
