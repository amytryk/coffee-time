package com.logos.dao;

import com.logos.entity.Shipping;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Anzhelika on 11/22/2016.
 */
public interface ShippingDao extends JpaRepository<Shipping, Integer> {
    Shipping findByName(String name);
}
