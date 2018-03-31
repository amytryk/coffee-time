package com.logos.dto;

/**
 * Created by Anzhelika on 12/25/2016.
 */
public class ShipingDTO {
    private int id;
    private String name;
    private String phone;

    public ShipingDTO() {
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
}
