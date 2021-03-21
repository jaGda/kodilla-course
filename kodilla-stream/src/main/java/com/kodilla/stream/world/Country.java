package com.kodilla.stream.world;

import java.math.BigDecimal;

public class Country {
    private final BigDecimal peopleQuantity;

    public Country(BigDecimal peopleQuantity) {
        this.peopleQuantity = peopleQuantity;
    }

    public BigDecimal getPeopleQuantity() {
        return peopleQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Country country = (Country) o;

        return getPeopleQuantity() != null ? getPeopleQuantity().equals(country.getPeopleQuantity()) : country.getPeopleQuantity() == null;
    }

    @Override
    public int hashCode() {
        return getPeopleQuantity() != null ? getPeopleQuantity().hashCode() : 0;
    }
}
