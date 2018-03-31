package com.logos.editor;

import com.logos.service.SupplierService;

import java.beans.PropertyEditorSupport;

/**
 * Created by Anzhelika on 12/23/2016.
 */
public class SupplierEditor extends PropertyEditorSupport {
    private final SupplierService supplierService;

    public SupplierEditor(SupplierService supplierService) {
        super();
        this.supplierService = supplierService;
    }

    @Override
    public void setAsText(String id) throws IllegalArgumentException {
        setValue(supplierService.findOne(Integer.parseInt(id)));
    }

}
