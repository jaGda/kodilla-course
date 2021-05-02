package com.kodilla.good.patterns.Food2Door;

public class Main {

    public static void main(String[] args) {

        OrderService order = new OrderService("ExtraFoodShop", "banana", 'B', 125);
        order.runOrder();

    }

}
