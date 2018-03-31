package com.logos.form;

/**
 * Created by Anzhelika on 12/23/2016.
 */
public class CartForm {
    private int productId;
    private int quantity;

    public CartForm() {
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
