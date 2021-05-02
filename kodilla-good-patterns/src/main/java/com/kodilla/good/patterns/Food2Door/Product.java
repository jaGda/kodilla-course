package com.kodilla.good.patterns.Food2Door;

public class Product {

    private String product;
    private int price;
    private int quantity;
    private char category;

    public Product(String product, int price, int quantity, char category) {
        this.product = product;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public char getCategory() {
        return category;
    }

    public void setCategory(char category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product1 = (Product) o;

        if (getPrice() != product1.getPrice()) return false;
        if (getQuantity() != product1.getQuantity()) return false;
        if (getCategory() != product1.getCategory()) return false;
        return getProduct() != null ? getProduct().equals(product1.getProduct()) : product1.getProduct() == null;
    }

    @Override
    public int hashCode() {
        int result = getProduct() != null ? getProduct().hashCode() : 0;
        result = 31 * result + getPrice();
        result = 31 * result + getQuantity();
        result = 31 * result + (int) getCategory();
        return result;
    }

    @Override
    public String toString() {
        return "    {" + product + "|"
                + price + "pln|"
                + quantity + "|"
                + category + '}';
    }

}
