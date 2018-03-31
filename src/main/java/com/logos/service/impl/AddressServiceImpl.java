package com.logos.service.impl;

import com.logos.dao.AddressDao;
import com.logos.dao.CountryDao;
import com.logos.entity.Address;
import com.logos.entity.Country;
import com.logos.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService{

    @Autowired
    private AddressDao addressDao;
    @Autowired
    private CountryDao countryDao;

    @Override
    public void save(Address address) {
        addressDao.save(address);

    }

    @Override
    public List<Address> findAll() {
        return addressDao.findAll();
    }

    @Override
    public Address findOne(int id) {
        return addressDao.findOne(id);
    }

    @Override
    public void delete(int id) {
        addressDao.delete(id);

    }

    @Transactional
    @Override
    public void saveCountryToAddress(Address address, int countryId) {
        addressDao.saveAndFlush(address);
        Country country = countryDao.findOne(countryId);
        address.setCountry(country);
        addressDao.save(address);
    }

    @Override
    public Address clone(Address address) {
        Address clone = new Address();

        clone.setCity(address.getCity());
        clone.setCountry(address.getCountry());
        clone.setPostalCode(address.getPostalCode());
        clone.setStreet(address.getStreet());

        return clone;
    }
}
