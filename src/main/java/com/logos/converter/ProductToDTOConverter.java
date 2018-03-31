package com.logos.converter;

import com.logos.dto.ProductDTO;
import com.logos.entity.Currency;
import com.logos.entity.Price;
import com.logos.entity.Product;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductToDTOConverter implements Converter<Product, ProductDTO> {

    @Override
    public ProductDTO convert(Product product) {

        ProductDTO productDTO = new ProductDTO();

        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setDescription(product.getDescription());

        List<Price> prices = product.getPrices();

        if (prices != null && !prices.isEmpty()) {
            productDTO.setPrice(prices.get(0).getValue());
            productDTO.setCurrency(prices.get(0).getCurrency());
        } else {
            productDTO.setCurrency(Currency.USD);
        }

        productDTO.setImageUrl(product.getImageUrl());

        return  productDTO;
    }
}
