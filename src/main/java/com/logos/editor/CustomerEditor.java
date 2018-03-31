package com.logos.editor;

import com.logos.service.CustomerService;
import org.apache.commons.lang3.StringUtils;

import java.beans.PropertyEditorSupport;

/**
 * Created by Anzhelika on 12/11/2016.
 */
public class CustomerEditor extends PropertyEditorSupport {

    private final CustomerService customerService;

    public CustomerEditor(CustomerService customerService) {
        super();
        this.customerService = customerService;
    }

    @Override
    public void setAsText(String customerEmail) throws IllegalArgumentException {
        if (StringUtils.isNotBlank(customerEmail)) {
            setValue(customerService.searchByEmail(customerEmail));
        }
    }
}
