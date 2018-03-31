package com.logos.service.impl;

import com.logos.dao.CartDao;
import com.logos.dao.CartEntryDao;
import com.logos.dto.CartDTO;
import com.logos.dto.CartEntryDTO;
import com.logos.dto.CartInfo;
import com.logos.dto.ProductDTO;
import com.logos.entity.Cart;
import com.logos.entity.CartEntry;
import com.logos.service.AddressService;
import com.logos.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    private final static String SHOPPING_CART_SESSION_ATTR = "shoppingCart";

    @Autowired
    private CartDao cartDao;

    @Autowired
    private CartEntryDao cartEntryDao;

    @Autowired
    private AddressService addressService;


    @Override
    public void save(Cart cart) {
        cartDao.save(cart);
    }

    @Override
    public void saveFully(Cart cart) {
        addressService.save(cart.getShippingAddress());
        Cart savedCart = cartDao.save(cart);

        for (CartEntry cartEntry: savedCart.getCartEntries()) {
            cartEntry.setCart(savedCart);
        }

        cartEntryDao.save(savedCart.getCartEntries());
    }

    @Override
    public List<Cart> findAll() {
        return cartDao.findAll();
    }

    @Override
    public Cart findOne(int id) {
        return cartDao.findOne(id);
    }

    @Override
    public void delete(int id) {
        cartDao.delete(id);
    }

    @Override
    public List<Cart> findCartWithCartEntries() {
        return cartDao.findCartWithCartEntries();
    }

    @Override
    public CartDTO getSessionCart(HttpServletRequest request) {
        CartDTO cartDTO = (CartDTO) request.getSession().getAttribute(SHOPPING_CART_SESSION_ATTR);

        if (cartDTO == null) {
            cartDTO = new CartDTO();
        }

        return cartDTO;
    }

    @Override
    public void removeSessionCart(HttpServletRequest request) {
        request.getSession().setAttribute(SHOPPING_CART_SESSION_ATTR, null);
    }

    @Override
    public CartInfo getCartInfo(HttpServletRequest request) {
        CartDTO cart = getSessionCart(request);
        CartInfo cartInfo = new CartInfo();

        if (cart.getCartEntries() != null) {
            cartInfo.setCount(cart.getCartEntries().size());
        }

        return cartInfo;
    }

    @Override
    public void addProduct(ProductDTO product, int quantity, HttpServletRequest request) {
        CartDTO cart = getSessionCart(request);
        CartEntryDTO cartEntry = searchCartEntry(cart, product.getId());

        if (cartEntry == null) {
            cartEntry = new CartEntryDTO();

            cartEntry.setProduct(product);
            cartEntry.setQuantity(0);
            cart.getCartEntries().add(cartEntry);
        }
        int newQuantity = cartEntry.getQuantity() + quantity;
        cartEntry.setQuantity(newQuantity);

        request.getSession().setAttribute(SHOPPING_CART_SESSION_ATTR, cart);
    }

    public boolean updateProduct(int productId, int quantity, HttpServletRequest request) {
        CartDTO cart = getSessionCart(request);
        CartEntryDTO cartEntry = searchCartEntry(cart, productId);
        boolean result = false;

        if (cartEntry != null && cartEntry.getQuantity() != quantity) {
            cartEntry.setQuantity(quantity);
            request.getSession().setAttribute(SHOPPING_CART_SESSION_ATTR, cart);
            result = true;
        }

        return result;
    }

    public boolean deleteProduct(int productId, HttpServletRequest request) {
        CartDTO cart = getSessionCart(request);
        CartEntryDTO cartEntry = searchCartEntry(cart, productId);
        boolean result = false;

        if (cartEntry != null) {
            cart.getCartEntries().remove(cartEntry);
            request.getSession().setAttribute(SHOPPING_CART_SESSION_ATTR, cart);
            result = true;
        }

        return result;
    }

    @Override
    public void calculateTotal(CartDTO cart) {
        BigDecimal total = BigDecimal.ZERO;

        for (CartEntryDTO cartEntry : cart.getCartEntries()) {
            BigDecimal subtotal = BigDecimal.valueOf(cartEntry.getProduct().getPrice() * cartEntry.getQuantity());

            cartEntry.setFormattedSubtotal("$ " + subtotal.setScale(2, BigDecimal.ROUND_HALF_DOWN));
            total = total.add(subtotal);
        }

        cart.setFormattedTotal("$ " + total.setScale(2, BigDecimal.ROUND_HALF_DOWN));
    }

    private CartEntryDTO searchCartEntry(CartDTO cart, int productId) {
        CartEntryDTO cartEntry = null;

        for (CartEntryDTO item : cart.getCartEntries()) {
            if (item.getProduct().getId() == productId) {
                cartEntry = item;
                break;
            }
        }

        return cartEntry;
    }
}
