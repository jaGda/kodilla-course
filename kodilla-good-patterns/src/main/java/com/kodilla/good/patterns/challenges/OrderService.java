package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;

public interface OrderService {

    boolean buy(User user, Product product, LocalDateTime purchaseDate);
}
