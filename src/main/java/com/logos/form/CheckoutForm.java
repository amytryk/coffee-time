package com.logos.form;

/**
 * Created by Anzhelika on 12/25/2016.
 */
public class CheckoutForm {
    private int shippingId;
    private int shippingAddressId;

    public CheckoutForm() {
    }

    public int getShippingAddressId() {
        return shippingAddressId;
    }

    public void setShippingAddressId(int shippingAddressId) {
        this.shippingAddressId = shippingAddressId;
    }

    public int getShippingId() {

        return shippingId;
    }

    public void setShippingId(int shippingId) {
        this.shippingId = shippingId;
    }
}
