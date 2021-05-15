package com.kodilla.patterns.strategy.social;

public class Millennials extends User {
    public Millennials(String name) {
        super(name);
        this.socialPublisher = new FacebookPublisher();
    }
}
