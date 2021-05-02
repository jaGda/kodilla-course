package com.kodilla.good.patterns.Food2Door;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Producer implements OrderProcessor {

    private String producer;
    private String address;
    private final Set<Product> products = new HashSet<>();

    public Producer(String producer, String address) {
        this.producer = producer;
        this.address = address;
    }

    @Override
    public boolean process(String product, char category, int quantity) {
        Product foundProduct = findProduct(product, category);

        if (foundProduct != null && foundProduct.getQuantity() >= quantity) {
            foundProduct.setQuantity(foundProduct.getQuantity() - quantity);
            return true;
        } else return false;
    }

    private Product findProduct(String product, char category) {
        return products.stream()
                .filter(p -> p.getProduct().equals(product)
                        && p.getCategory() == category)
                .findFirst().orElse(null);
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public boolean addProduct(Product product) {
        return products.add(product);
    }

    @Override
    public String toString() {
        return "PRODUCER: '" + producer + "'\n"
                + "ADDRESS: '" + address + "'\n"
                + "PRODUCTS: \n" + productsToString();
    }

    private String productsToString() {
        return this.products.stream()
                .map(Product::toString)
                .collect(Collectors.joining("\n"));
    }

}
