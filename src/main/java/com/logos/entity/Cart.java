package com.logos.entity;

import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate date;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Shipping shipping;

    @OneToOne
    @Cascade(CascadeType.DELETE)
    private Address shippingAddress;

    @OneToMany(mappedBy = "cart")
    @Cascade(CascadeType.DELETE)
    private List<CartEntry> cartEntries;

    public Cart() {
    }

    public Cart(LocalDate date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Shipping getShipping() {
        return shipping;
    }

    public void setShipping(Shipping shipping) {
        this.shipping = shipping;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public List<CartEntry> getCartEntries() {
        if (this.cartEntries == null) {
            this.cartEntries = new ArrayList<>();
        }

        return cartEntries;
    }

    public void setCartEntries(List<CartEntry> cartEntries) {
        this.cartEntries = cartEntries;
    }

    public void addCartEntry(CartEntry cartEntry) {
        getCartEntries().add(cartEntry);
    }
}
