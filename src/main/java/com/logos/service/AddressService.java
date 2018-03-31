package com.logos.service;


import com.logos.entity.Address;
import java.util.List;

public interface AddressService {

    void save(Address address);
    List<Address> findAll();
    Address findOne(int id);
    void delete(int id);

    void saveCountryToAddress(Address address, int countryId);

    Address clone(Address address);
}
