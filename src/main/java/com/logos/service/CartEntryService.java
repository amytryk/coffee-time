package com.logos.service;

import com.logos.entity.CartEntry;

import java.util.List;


public interface CartEntryService {

    void save(CartEntry cartEntry);
    List<CartEntry> findAll();
    CartEntry findOne(int id);
    void delete(int id);
}
