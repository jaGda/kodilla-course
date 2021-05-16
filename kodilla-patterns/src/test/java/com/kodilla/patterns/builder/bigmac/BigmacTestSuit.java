package com.kodilla.patterns.builder.bigmac;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BigmacTestSuit {

    @Test
    void testBigmacBuilder() {
        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .Bun(Bun.WITH_SESAME)
                .Sauce(Sauce.THOUSAND_ISLANDS)
                .Burgers(2)
                .Ingredients(Ingredients.CUCUMBER)
                .Ingredients(Ingredients.BACON)
                .Ingredients(Ingredients.SALAD)
                .Ingredients(Ingredients.SHRIMPS)
                .Ingredients(Ingredients.MUSHROOMS)
                .build();
        System.out.println(bigmac);

        //When & Then
        assertAll(
                () -> assertEquals(Bun.WITH_SESAME, bigmac.getBun()),
                () -> assertEquals(Sauce.THOUSAND_ISLANDS, bigmac.getSauce()),
                () -> assertEquals(2, bigmac.getBurgers()),
                () -> assertEquals(5, bigmac.getIngredients().size())
        );
    }
}