package com.logos.entity;

import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.List;

@Entity
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String contactName;
    private String phone;

    @OneToMany(mappedBy = "supplier")
    @Cascade(CascadeType.DELETE)
    private List<Address> addresses;

    @OneToMany(mappedBy = "supplier")
    private List<Product> productses;

    public Supplier() {
    }

    public Supplier(String name, String contactName, String phone) {
        this.name = name;
        this.contactName = contactName;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public List<Product> getProductses() {
        return productses;
    }

    public void setProductses(List<Product> productses) {
        this.productses = productses;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "name='" + name + '\'' +
                '}';
    }
}
