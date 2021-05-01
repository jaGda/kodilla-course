package com.kodilla.good.patterns.challenges;

public class Product {

    private Long productID;
    private String product;

    public Product(Long productID, String product) {
        this.productID = productID;
        this.product = product;
    }

    public String getProduct() {
        return product;
    }

}
