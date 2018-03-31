package com.logos.validator;

import com.logos.dao.SupplierDao;
import com.logos.entity.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class SupplierValidator implements Validator {

    @Autowired
    private SupplierDao supplierDao;

    @Override
    public boolean supports(Class<?> aClass) {
        return Supplier.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Supplier supplier = (Supplier) target;

        if (supplier.getName().isEmpty()) {
            errors.rejectValue("name", "field.required");
        } else if (!validateLettersWithDigits(supplier.getName())) {
            errors.rejectValue("name", "field.invalid.characters");
        } else if (supplierDao.findByNameIs(supplier.getName()) != null) {
            errors.rejectValue("name", "supplier.name.exists");
        }

        if (supplier.getContactName().isEmpty()) {
            errors.rejectValue("contactName", "field.required");
        } else if (!validateLetters(supplier.getContactName())) {
            errors.rejectValue("contactName", "field.invalid.characters");
        }
    }

    private boolean validateLetters(String string) {
        return string.matches("^[\\p{L} .'-]+$");
    }

    private boolean validateLettersWithDigits(String string) {
        return string.matches("^[\\p{L} \\p{Digit} .'-]+$");
    }
}
