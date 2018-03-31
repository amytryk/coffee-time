package com.logos.validator;

import com.logos.dao.CustomerDao;
import com.logos.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class CustomerValidator implements Validator {

    @Autowired
    private CustomerDao customerDao;


    @Override
    public boolean supports(Class<?> aClass) {
        return Customer.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Customer customer = (Customer) target;

        if (customer.getFirstName().isEmpty()) {
            errors.rejectValue("firstName", "field.required");
        } else if (!validateLetters(customer.getFirstName())) {
            errors.rejectValue("firstName", "field.invalid.characters");
        }

        if (customer.getLastName().isEmpty()) {
            errors.rejectValue("lastName", "field.required");
        } else if (!validateLetters(customer.getLastName())) {
            errors.rejectValue("lastName", "field.invalid.characters");
        }

        if (customer.getEmail().isEmpty()) {
            errors.rejectValue("email", "field.required");
        } else if (customerDao.findByEmail(customer.getEmail()) != null) {
            errors.rejectValue("email", "field.email.exists");
        }

        if (customer.getConfirmPassword().isEmpty()) {
            errors.rejectValue("confirmPassword", "field.required");
        }

        if (customer.getPassword().isEmpty()) {
            errors.rejectValue("password", "field.required");
        } else if (!(customer.getPassword().equals(customer.getConfirmPassword()))) {
            errors.rejectValue("confirmPassword", "field.password.mismatch");
        }
    }

    private boolean validateLetters(String string) {
        return string.matches("^[\\p{L} .'-]+$");
    }
}
