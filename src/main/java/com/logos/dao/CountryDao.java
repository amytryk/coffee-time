package com.logos.dao;


import com.logos.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryDao extends JpaRepository<Country, Integer>{
    Country findByIsoCode(String isoCode);
}
