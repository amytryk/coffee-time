package com.logos.service;

import com.logos.dto.CartDTO;
import com.logos.dto.CartInfo;
import com.logos.dto.ProductDTO;
import com.logos.entity.Cart;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface CartService {

    void save(Cart cart);

    void saveFully(Cart cart);

    List<Cart> findAll();

    Cart findOne(int id);

    void delete(int id);

    List<Cart> findCartWithCartEntries();

    CartDTO getSessionCart(HttpServletRequest request);

    void removeSessionCart(HttpServletRequest request);

    CartInfo getCartInfo(HttpServletRequest request);

    void addProduct(ProductDTO productDTO, int quantity, HttpServletRequest request);

    boolean updateProduct(int productId, int quantity, HttpServletRequest request);

    boolean deleteProduct(int productId, HttpServletRequest request);

    void calculateTotal(CartDTO cart);

}
