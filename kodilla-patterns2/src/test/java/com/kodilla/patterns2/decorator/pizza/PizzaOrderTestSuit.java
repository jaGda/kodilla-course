package com.kodilla.patterns2.decorator.pizza;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PizzaOrderTestSuit {

    @Test
    void testPizzaWithHamMushroomsExtraCheeseGetCost() {
        //Given
        PizzaOrder order = new HamPizzaDecorator(new MushroomsPizzaDecorator(new ExtraCheeseDecorator(new BasicPizzaOrder())));
        //When
        BigDecimal cost = order.getCost();
        //Then
        assertEquals(new BigDecimal(24), cost);
    }

    @Test
    void testPizzaWithHamMushroomsExtraCheeseGetDescription() {
        //Given
        PizzaOrder order = new HamPizzaDecorator(new MushroomsPizzaDecorator(new ExtraCheeseDecorator(new BasicPizzaOrder())));
        //When
        String desc = order.getDescription();
        //Then
        assertEquals("Bottom, sauce, cheese, extra cheese, mushrooms, ham", desc);
    }

}