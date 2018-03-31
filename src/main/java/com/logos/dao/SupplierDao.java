package com.logos.dao;

import com.logos.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface SupplierDao extends JpaRepository<Supplier, Integer> {
    @Query("select distinct s from Supplier s left join fetch s.addresses")
    List<Supplier> findSuppliersWithAddress();

    @Query("select distinct s from Supplier  s left  join fetch s.productses where s.id=:id")
    Supplier findSupplierWithProducts(@Param("id") int id);

    @Query("select distinct s from Supplier s left join fetch s.productses p")
    List<Supplier> findSuppliersWithProducts();

    Supplier findByNameIs(String name);
}
