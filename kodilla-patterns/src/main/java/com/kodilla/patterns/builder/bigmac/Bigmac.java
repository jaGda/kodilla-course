package com.kodilla.patterns.builder.bigmac;

import java.util.ArrayList;
import java.util.List;

public class Bigmac {

    private final Bun bun;
    private final int burgers;
    private final Sauce sauce;
    private final List<Ingredients> ingredients;

    public static class BigmacBuilder {
        private Bun bun;
        private int burgers;
        private Sauce sauce;
        private final List<Ingredients> ingredients = new ArrayList<>();

        public BigmacBuilder Bun(Bun bun) {
            this.bun = bun;
            return this;
        }

        public BigmacBuilder Burgers(int burgers) {
            this.burgers = burgers;
            return this;
        }

        public BigmacBuilder Sauce(Sauce sauce) {
            this.sauce = sauce;
            return this;
        }

        public BigmacBuilder Ingredients(Ingredients ingredient) {
            this.ingredients.add(ingredient);
            return this;
        }

        public Bigmac build() {
            return new Bigmac(bun, burgers, sauce, ingredients);
        }
    }

    private Bigmac(Bun bun, int burgers, Sauce sauce, List<Ingredients> ingredients) {
        this.bun = bun;
        this.burgers = burgers;
        this.sauce = sauce;
        this.ingredients = ingredients;
    }

    public Bun getBun() {
        return bun;
    }

    public int getBurgers() {
        return burgers;
    }

    public Sauce getSauce() {
        return sauce;
    }

    public List<Ingredients> getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        return "Bigmac{" +
                "bun=" + bun +
                ", burgers=" + burgers +
                ", sauce=" + sauce +
                ", ingredients=" + ingredients +
                '}';
    }
}
