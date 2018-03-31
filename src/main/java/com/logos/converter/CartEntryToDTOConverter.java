package com.logos.converter;

import com.logos.dto.CartEntryDTO;
import com.logos.dto.ProductDTO;
import com.logos.entity.CartEntry;
import com.logos.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * Created by Anzhelika on 12/22/2016.
 */
@Component
public class CartEntryToDTOConverter implements Converter<CartEntry, CartEntryDTO> {
    @Autowired
    private Converter<Product, ProductDTO> productToDTOConverter;

    @Override
    public CartEntryDTO convert(CartEntry cartEntry) {

        CartEntryDTO cartEntryDTO = new CartEntryDTO();
        ProductDTO productDTO = productToDTOConverter.convert(cartEntry.getProduct());
        BigDecimal subtotal = BigDecimal.valueOf(productDTO.getPrice() * cartEntry.getQuantity()).setScale(2, BigDecimal.ROUND_HALF_DOWN);

        cartEntryDTO.setId(cartEntry.getId());
        cartEntryDTO.setQuantity(cartEntry.getQuantity());
        cartEntryDTO.setProduct(productDTO);
        cartEntryDTO.setFormattedSubtotal("$ " + subtotal);
        return cartEntryDTO;
    }
}
