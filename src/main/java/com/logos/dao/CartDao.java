package com.logos.dao;


import com.logos.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CartDao extends JpaRepository<Cart, Integer> {

    @Query("select distinct c from Cart c left join fetch c.cartEntries")
    List<Cart> findCartWithCartEntries();
}
