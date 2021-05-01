package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;

public interface OrderRepository {

    boolean createSale(User user, Product product, LocalDateTime purchaseDate);

}
