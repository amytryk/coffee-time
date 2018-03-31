package com.logos.dto;

import com.logos.entity.Customer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anzhelika on 11/25/2016.
 */
public class DtoUtilMapper {

    public static List<CustomerDTO> customersToCustomersDTO(List<Customer> customers) {
        List<CustomerDTO> customerDTOs = new ArrayList<CustomerDTO>();

        for (Customer customer : customers) {
            CustomerDTO customerDTO = customerToCustomerDTO(customer);

            customerDTOs.add(customerDTO);
        }
        return customerDTOs;
    }

    public static CustomerDTO customerToCustomerDTO(Customer source) {
        CustomerDTO customerDTO = new CustomerDTO();

        customerDTO.setId(source.getId());
        customerDTO.setFirstName(source.getFirstName());
        customerDTO.setLastName(source.getLastName());
        customerDTO.setEmail(source.getEmail());
        customerDTO.setAddress(source.getAddress());
        customerDTO.setPhone(source.getPhone());
        customerDTO.setPathImage(source.getPathImage());

        return customerDTO;
    }

    public static Customer customerDTOToCustomer(CustomerDTO source, Customer target) {
        target.setFirstName(source.getFirstName());
        target.setLastName(source.getLastName());
        if (source.getEmail() != null) {
            target.setEmail(source.getEmail());
        }
        target.setPhone(source.getPhone());

        return target;
    }
}
