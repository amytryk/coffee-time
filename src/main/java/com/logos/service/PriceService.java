package com.logos.service;

import com.logos.entity.Price;

import java.util.List;

public interface PriceService {
    void save(Price price);
    List<Price> findAll();
    Price findOne(int id);
    void delete(int id);
}
