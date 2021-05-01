package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;

public class OrderRequestRetriever {

    public OrderRequest retrieve() {

        User user = new User("Jan", "Kowalski", 123456L);
        Product product = new Product(54321L,
                "Smartphone Apple iPhone 11 Pro 4GB/256GB_green");

        LocalDateTime purchaseDay = LocalDateTime.now();

        return new OrderRequest(user, product, purchaseDay);
    }

}
