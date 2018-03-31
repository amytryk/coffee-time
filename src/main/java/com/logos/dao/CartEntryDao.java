package com.logos.dao;


import com.logos.entity.CartEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartEntryDao extends JpaRepository<CartEntry, Integer>{
}
