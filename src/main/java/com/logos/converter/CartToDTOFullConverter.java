package com.logos.converter;

import com.logos.dto.CartDTO;
import com.logos.dto.CartEntryDTO;
import com.logos.entity.Cart;
import com.logos.entity.CartEntry;
import com.logos.util.ConverterUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Created by Anzhelika on 12/22/2016.
 */
@Component
public class CartToDTOFullConverter implements Converter<Cart, CartDTO> {

    @Autowired
    private Converter<CartEntry, CartEntryDTO> cartEntryToDTOConverter;

    @Override
    public CartDTO convert(Cart cart) {

        CartDTO cartDTO = new CartDTO();

        cartDTO.setId(cart.getId());
        cartDTO.setDate(cart.getDate());
        cartDTO.setCartEntries(ConverterUtil.convertAll(cart.getCartEntries(), cartEntryToDTOConverter));

        return cartDTO;
    }
}
