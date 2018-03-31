package com.logos.service.impl;

import com.logos.dao.ShippingDao;
import com.logos.entity.Shipping;
import com.logos.service.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShippingServiceImpl implements ShippingService {

    @Autowired
    private ShippingDao shippingDao;

    @Override
    public void save(Shipping shipping) {
        shippingDao.save(shipping);
    }

    @Override
    public List<Shipping> findAll() {
        return shippingDao.findAll();
    }

    @Override
    public Shipping findOne(int id) {
        return shippingDao.findOne(id);
    }

    @Override
    public void delete(int id) {
        shippingDao.delete(id);
    }
}
