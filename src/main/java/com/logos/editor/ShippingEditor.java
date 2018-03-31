package com.logos.editor;

import com.logos.service.ShippingService;

import java.beans.PropertyEditorSupport;

/**
 * Created by Anzhelika on 12/23/2016.
 */
public class ShippingEditor extends PropertyEditorSupport {
    private final ShippingService shippingService;

    public ShippingEditor(ShippingService shippingService) {
        super();
        this.shippingService = shippingService;
    }

    @Override
    public void setAsText(String id) throws IllegalArgumentException {
        setValue(shippingService.findOne(Integer.parseInt(id)));
    }

}
