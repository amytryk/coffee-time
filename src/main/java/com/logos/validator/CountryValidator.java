package com.logos.validator;

import com.logos.dao.CountryDao;
import com.logos.entity.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class CountryValidator implements Validator {

    @Autowired
    private CountryDao countryDao;

    @Override
    public boolean supports(Class<?> aClass) {
        return Country.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Country country = (Country) target;

        if (country.getName().isEmpty()) {
            errors.rejectValue("name", "field.required");
        } else if (!validateLetters(country.getName())) {
            errors.rejectValue("name", "field.invalid.characters");
        }

        if (country.getIsoCode().isEmpty()) {
            errors.rejectValue("isoCode", "field.required");
        } else if (!validateLetters(country.getIsoCode())) {
            errors.rejectValue("isoCode", "field.invalid.characters");
        } else if (countryDao.findByIsoCode(country.getIsoCode()) != null) {
            errors.rejectValue("isoCode", "country.isocode.exists");
        }
    }

    private boolean validateLetters(String string) {
        return string.matches("^[\\p{L} .'-]+$");
    }
}
