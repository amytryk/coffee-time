package com.logos.service.impl;

import com.logos.dao.AddressDao;
import com.logos.dao.CustomerDao;
import com.logos.entity.Address;
import com.logos.entity.Customer;
import com.logos.entity.Role;
import com.logos.service.CustomerService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.NoResultException;
import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.List;

@Service("userDetailsService")
public class CustomerServiceImpl implements CustomerService, UserDetailsService {

    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private AddressDao addressDao;
    @Autowired
    private BCryptPasswordEncoder encoder;


    @Override
    public void save(Customer customer) {
        customer.setRole(Role.ROLE_CUSTOMER);
        customer.setPassword(encoder.encode(customer.getPassword()));
        customer.setConfirmPassword(encoder.encode(customer.getConfirmPassword()));
        customerDao.save(customer);
    }

    @Override
    public List<Customer> findAll() {
        return customerDao.findAll();
    }

    @Override
    public Customer searchByEmail(String email) {
        Customer customer = null;
        try {
            customer = customerDao.findByEmail(email);
        } catch (NoResultException e) {
            // expected exception
        }
        return customer;
    }

    @Override
    public Customer findOne(int id) {
        return customerDao.findOne(id);
    }

    @Override
    public void delete(int id) {
        customerDao.delete(id);
    }

    @Transactional
    @Override
    public void saveAddressToCustomer(Customer customer, int idAddress) {
        customerDao.saveAndFlush(customer);
        Address address = addressDao.findOne(idAddress);
        address.setCustomer(customer);
        addressDao.save(address);
    }

    @Override
    public List<Customer> findCustomersWithAddress() {
        return customerDao.findCustomersWithAddress();
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return customerDao.findByEmail(email);
    }


    @Transactional
    public void saveImage(Principal principal, MultipartFile multipartFile) {

        Customer customer = customerDao.findByEmail(principal.getName());

        String path = System.getProperty("catalina.home") + "/resources/"
                + customer.getEmail() + "/" + multipartFile.getOriginalFilename();

        customer.setPathImage("/resources/" + customer.getEmail() + "/" + multipartFile.getOriginalFilename());

        File file = new File(path);

        try {
            file.mkdirs();
            try {
                FileUtils.cleanDirectory
                        (new File(System.getProperty("catalina.home") + "/resources/" + customer.getEmail() + "/"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            multipartFile.transferTo(file);
        } catch (IOException e) {
            System.out.println("error with file");
        }

        customerDao.save(customer);
    }

    @Override
    public Customer findByUUID(String uuid) {
        return customerDao.findByUUID(uuid);
    }

    @Override
    public void update(Customer customer) {
        customerDao.save(customer);
    }

}
