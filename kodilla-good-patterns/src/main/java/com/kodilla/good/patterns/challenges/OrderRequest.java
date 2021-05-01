package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;

public class OrderRequest {

    private User user;
    private Product product;
    private LocalDateTime purchaseDate;

    public OrderRequest(User user, Product product, LocalDateTime purchaseDate) {
        this.user = user;
        this.product = product;
        this.purchaseDate = purchaseDate;
    }

    public User getUser() {
        return user;
    }

    public Product getProduct() {
        return product;
    }

    public LocalDateTime getPurchaseDay() {
        return purchaseDate;
    }

}
