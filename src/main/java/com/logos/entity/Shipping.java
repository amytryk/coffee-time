package com.logos.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Shipping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 30)
    private String name;

    @Column(length = 20)
    private String phone;

    @OneToMany(mappedBy = "shipping")
    private List<Cart> carts;

    public Shipping() {
    }

    public Shipping(String name, String phone) {
        this.name = name;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Cart> getCarts() {
        return carts;
    }

    public void setCarts(List<Cart> orders) {
        this.carts = orders;
    }
}
