package com.logos.dto;

/**
 * Created by Anzhelika on 12/22/2016.
 */
public class CartEntryDTO {

    private int id;
    private ProductDTO product;
    private int quantity;
    private String formattedSubtotal;

    public CartEntryDTO() {
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getFormattedSubtotal() {
        return formattedSubtotal;
    }

    public void setFormattedSubtotal(String formattedSubtotal) {
        this.formattedSubtotal = formattedSubtotal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
