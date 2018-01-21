package com.packt.webstore.exception;

public class ProductNotFoundException extends RuntimeException {

    private final static long serialVersionUID = 132234624233524266L;

    private String productId;

    public ProductNotFoundException(String productId) {
        this.productId = productId;
    }

    public String getProductId() {
        return productId;
    }

}
