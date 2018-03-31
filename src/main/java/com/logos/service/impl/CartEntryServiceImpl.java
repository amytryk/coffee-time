package com.logos.service.impl;

import com.logos.dao.CartEntryDao;
import com.logos.entity.CartEntry;
import com.logos.service.CartEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartEntryServiceImpl implements CartEntryService {

    @Autowired
    private CartEntryDao cartEntryDao;

    @Override
    public void save(CartEntry cartEntry) {
        cartEntryDao.save(cartEntry);
    }

    @Override
    public List<CartEntry> findAll() {
        return cartEntryDao.findAll();
    }

    @Override
    public CartEntry findOne(int id) {
        return cartEntryDao.findOne(id);
    }

    @Override
    public void delete(int id) {
        cartEntryDao.delete(id);

    }
}
