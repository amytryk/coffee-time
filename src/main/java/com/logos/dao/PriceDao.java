package com.logos.dao;

import com.logos.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Anzhelika on 11/22/2016.
 */
public interface PriceDao extends JpaRepository<Price, Integer> {
}
