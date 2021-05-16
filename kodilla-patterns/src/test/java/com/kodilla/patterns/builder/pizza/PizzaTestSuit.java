package com.kodilla.patterns.builder.pizza;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PizzaTestSuit {

    @Test
    void testPizzaNew() {
        //Given
        Pizza pizza = new Pizza.PizzaBuilder()
                .ingredients("Onion")
                .bottom("Thin")
                .sauce("Spicy")
                .ingredients("Mushrooms")
                .ingredients("Cheese")
                .ingredients("Tomato")
                .build();
        System.out.println(pizza);
        //When
        int howManyIngredients = pizza.getIngredients().size();
        //Then
        assertEquals(4, howManyIngredients);
    }
}