package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ElectronicsOrderService implements OrderService {

    @Override
    public boolean buy(User user, Product product, LocalDateTime purchaseDate) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        System.out.println(user.getName() + " " + user.getSurname()
                + " bought: " + product.getProduct() + " on "
                + purchaseDate.format(formatter) + "."
        );

        return true;
    }

}
