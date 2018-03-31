package com.logos.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anzhelika on 12/22/2016.
 */
public class CartDTO {

    private int id;
    private LocalDate date;
    private CustomerDTO customer;
    private List<CartEntryDTO> cartEntries;
    private String formattedTotal;

    public CartDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }

    public List<CartEntryDTO> getCartEntries() {
        if(cartEntries == null){
            cartEntries = new ArrayList<>();
        }
        return cartEntries;
    }

    public void setCartEntries(List<CartEntryDTO> cartEntries) {
        this.cartEntries = cartEntries;
    }

    public String getFormattedTotal() {
        return formattedTotal;
    }

    public void setFormattedTotal(String formattedTotal) {
        this.formattedTotal = formattedTotal;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
