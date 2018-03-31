package com.logos.editor;


import com.logos.entity.Price;
import com.logos.service.PriceService;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;

import java.util.List;

public class PriceCollectionEditor extends CustomCollectionEditor {

    private final PriceService priceService;

    public PriceCollectionEditor(PriceService priceService) {
        super(List.class);
        this.priceService = priceService;
    }

    @Override
    protected Object convertElement(Object element) {
        Price price= priceService.findOne(Integer.parseInt(element.toString()));

        return price;
    }
}