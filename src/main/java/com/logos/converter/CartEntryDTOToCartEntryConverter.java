package com.logos.converter;

import com.logos.dto.CartEntryDTO;
import com.logos.entity.CartEntry;
import com.logos.entity.Product;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Created by Anzhelika on 12/25/2016.
 */
@Component
public class CartEntryDTOToCartEntryConverter implements Converter<CartEntryDTO, CartEntry> {

    @Override
    public CartEntry convert(CartEntryDTO cartEntryDTO) {
        CartEntry cartEntry = new CartEntry();
        Product product = new Product();

        product.setId(cartEntryDTO.getProduct().getId());
        cartEntry.setId(cartEntryDTO.getId());
        cartEntry.setQuantity(cartEntryDTO.getQuantity());
        cartEntry.setProduct(product);

        return cartEntry;
    }
}
