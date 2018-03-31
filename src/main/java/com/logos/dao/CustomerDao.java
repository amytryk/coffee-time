package com.logos.dao;

import com.logos.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerDao extends JpaRepository<Customer, Integer>{

    Customer findByEmail(String email);

    @Query("select distinct c from Customer c left join fetch c.address")
    List<Customer> findCustomersWithAddress();

    @Query("select c from Customer c where c.uuid =:uuid")
    Customer findByUUID(@Param("uuid") String uuid);
}


