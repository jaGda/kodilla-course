package com.kodilla.stream.world;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class WorldTestSuite {

    @Test
    void testGetPeopleQuantity() {
        //Give
        Country china = new Country(new BigDecimal("1401585247"));
        Country india = new Country(new BigDecimal("1359527235"));
        Country usa = new Country(new BigDecimal("329256465"));
        Country brazil = new Country(new BigDecimal("208846892"));
        Country indonesia = new Country(new BigDecimal("262787403"));
        Country pakistan = new Country(new BigDecimal("207862518"));
        Country nigeria = new Country(new BigDecimal("203452505"));
        Country mexico = new Country(new BigDecimal("125959205"));
        Country ethiopia = new Country(new BigDecimal("108386391"));
        Country egypt = new Country(new BigDecimal("99413317"));
        Country germany = new Country(new BigDecimal("80457737"));
        Country france = new Country(new BigDecimal("67364357"));
        Country greatBritain = new Country(new BigDecimal("65105256"));
        Country italy = new Country(new BigDecimal("62246674"));

        Continent asia = new Continent();
        asia.addCountry(china);
        asia.addCountry(india);
        asia.addCountry(indonesia);
        asia.addCountry(pakistan);

        Continent africa = new Continent();
        africa.addCountry(nigeria);
        africa.addCountry(ethiopia);
        africa.addCountry(egypt);

        Continent america = new Continent();
        america.addCountry(usa);
        america.addCountry(brazil);
        america.addCountry(mexico);

        Continent europe = new Continent();
        europe.addCountry(germany);
        europe.addCountry(france);
        europe.addCountry(greatBritain);
        europe.addCountry(italy);

        World world = new World();
        world.addContinent(asia);
        world.addContinent(africa);
        world.addContinent(america);
        world.addContinent(europe);

        //When
        BigDecimal result = world.getPeopleQuantity();
        BigDecimal expectedResult = Stream.of(china, india, usa,
                brazil, indonesia, pakistan, nigeria,
                mexico, ethiopia, egypt, germany, france,
                greatBritain, italy)
                .map(Country::getPeopleQuantity)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println(result);
        System.out.println(expectedResult);

        //Then
        assertEquals(expectedResult, result);
    }

}