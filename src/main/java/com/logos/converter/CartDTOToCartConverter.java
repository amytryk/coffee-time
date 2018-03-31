package com.logos.converter;

import com.logos.dto.CartDTO;
import com.logos.dto.CartEntryDTO;
import com.logos.entity.Cart;
import com.logos.entity.CartEntry;
import com.logos.util.ConverterUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * Created by Anzhelika on 12/25/2016.
 */
@Component
public class CartDTOToCartConverter implements Converter<CartDTO, Cart> {

    @Autowired
    private Converter<CartEntryDTO, CartEntry> cartEntryDTOToCartEntryConverter;

    @Override
    public Cart convert(CartDTO cartDTO) {
        Cart cart = new Cart();

        cart.setId(cartDTO.getId());
        cart.setDate(LocalDate.now());

        if (cartDTO.getCartEntries() != null) {
            cart.setCartEntries(ConverterUtil.convertAll(cartDTO.getCartEntries(), cartEntryDTOToCartEntryConverter));
        }

        return cart;
    }
}
