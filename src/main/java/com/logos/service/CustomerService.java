package com.logos.service;

import com.logos.entity.Customer;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;
import java.util.List;


public interface CustomerService {

    void save(Customer customer);
    List<Customer> findAll();
    Customer searchByEmail(String email);
    Customer findOne(int id);
    void delete(int id);

    void saveAddressToCustomer(Customer customer, int idAddress);

    List<Customer> findCustomersWithAddress();

    public void saveImage(Principal principal, MultipartFile multipartFile);

    Customer findByUUID(String uuid);

    void update(Customer customer);
}
