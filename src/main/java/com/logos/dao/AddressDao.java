package com.logos.dao;

import com.logos.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressDao extends JpaRepository<Address, Integer> {

}
