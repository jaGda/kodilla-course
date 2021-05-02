package com.kodilla.good.patterns.Food2Door;

public class OrderService {

    private final String producer;
    private final String product;
    private final char category;
    private final int quantity;

    public OrderService(String producer, String product, char category, int quantity) {
        this.producer = producer;
        this.product = product;
        this.category = category;
        this.quantity = quantity;
    }

    public void runOrder() {

        ProducersBase.showBase();
        Producer foundProducer = getProducer(producer);

        if (foundProducer != null && foundProducer.process(product, category, quantity)) {
            System.out.println("The order was completed.");
        } else {
            System.out.println("The order has not been processed.");
        }

        ProducersBase.showBase();
    }

    private Producer getProducer(String producer) {
        return ProducersBase.producers.stream()
                .filter(p -> p.getProducer().equals(producer))
                .findFirst()
                .orElse(null);
    }

}
