package com.logos.service.impl;

import com.logos.dao.PriceDao;
import com.logos.entity.Price;
import com.logos.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceServiceImpl implements PriceService {

    @Autowired
    private PriceDao priceDao;

    @Override
    public void save(Price price) {
        priceDao.save(price);
    }

    @Override
    public List<Price> findAll() {
        return priceDao.findAll();
    }

    @Override
    public Price findOne(int id) {
        return priceDao.findOne(id);
    }

    @Override
    public void delete(int id) {
        priceDao.delete(id);
    }
}
