package com.kodilla.stream.world;

import java.util.HashSet;
import java.util.Set;

public class Continent {

    private final Set<Country> countries = new HashSet<>();

    public boolean addCountry(Country country) {
        return countries.add(country);
    }

    public Set<Country> getCountries() {
        return new HashSet<>(countries);
    }
}
