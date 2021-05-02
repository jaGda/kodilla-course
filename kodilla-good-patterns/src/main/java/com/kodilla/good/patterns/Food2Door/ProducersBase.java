package com.kodilla.good.patterns.Food2Door;

import java.util.HashSet;
import java.util.Set;

public class ProducersBase {

    public static final Set<Producer> producers;

    static {
        Product bananaA = new Product("banana", 8, 3125, 'A');
        Product bananaB = new Product("banana", 8, 3125, 'B');
        Product apple = new Product("apple", 12, 1115, 'B');
        Product carrotA = new Product("carrot", 3, 2231, 'A');
        Product carrotB = new Product("carrot", 3, 2231, 'B');
        Product carrotC = new Product("carrot", 3, 2231, 'C');
        Product onion = new Product("onion", 2, 2124, 'A');
        Product egg = new Product("egg", 6, 3200, 'B');
        Product salad = new Product("salad", 7, 525, 'C');
        Product pear = new Product("pear", 9, 825, 'A');

        Producer producer1 = new Producer("ExtraFoodShop", "Gdansk");
        producer1.addProduct(bananaA);
        producer1.addProduct(bananaB);
        producer1.addProduct(apple);
        producer1.addProduct(carrotA);
        producer1.addProduct(carrotB);
        producer1.addProduct(carrotC);

        Producer producer2 = new Producer("HealthyShop", "Gdynia");
        producer2.addProduct(onion);
        producer2.addProduct(egg);
        producer2.addProduct(salad);
        producer2.addProduct(pear);

        Producer producer3 = new Producer("GlutenFreeShop", "Sopot");
        producer3.addProduct(egg);
        producer3.addProduct(carrotB);
        producer3.addProduct(bananaA);
        producer3.addProduct(bananaB);
        producer3.addProduct(carrotC);
        producer3.addProduct(apple);

        producers = new HashSet<>();
        producers.add(producer1);
        producers.add(producer2);
        producers.add(producer3);
    }

    public static void showBase() {
        producers.forEach(System.out::println);
    }

}
