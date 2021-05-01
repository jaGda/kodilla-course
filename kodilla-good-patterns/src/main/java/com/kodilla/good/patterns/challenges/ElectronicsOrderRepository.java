package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;

public class ElectronicsOrderRepository implements OrderRepository {

    @Override
    public boolean createSale(User user, Product product, LocalDateTime purchaseDate) {
        return false;
    }

}
