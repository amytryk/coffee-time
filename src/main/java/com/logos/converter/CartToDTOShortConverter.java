package com.logos.converter;

import com.logos.dto.CartDTO;
import com.logos.entity.Cart;
import com.logos.entity.CartEntry;
import com.logos.entity.Price;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Anzhelika on 12/22/2016.
 */
@Component
public class CartToDTOShortConverter implements Converter<Cart, CartDTO>{

    @Override
    public CartDTO convert(Cart cart) {

        CartDTO cartDTO = new CartDTO();

        cartDTO.setId(cart.getId());
        cartDTO.setDate(cart.getDate());
        cartDTO.setFormattedTotal("$ " + calculateTotal(cart).setScale(2, BigDecimal.ROUND_HALF_DOWN));

        return cartDTO;
    }

    public BigDecimal calculateTotal(Cart cart) {
        BigDecimal total = BigDecimal.ZERO;

        for (CartEntry cartEntry : cart.getCartEntries()) {
            List<Price> prices = cartEntry.getProduct().getPrices();
            BigDecimal subtotal = BigDecimal.ZERO;

            if (prices != null && !prices.isEmpty()) {
                subtotal = BigDecimal.valueOf(prices.get(0).getValue() * cartEntry.getQuantity());
            }

            total = total.add(subtotal);
        }

        return total;
    }
}
