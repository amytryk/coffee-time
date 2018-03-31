package com.logos.service;


import com.logos.entity.Shipping;

import java.util.List;

public interface ShippingService {

    void save(Shipping shipping);
    List<Shipping> findAll();
    Shipping findOne(int id);
    void delete(int id);
}
