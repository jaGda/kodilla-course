package com.kodilla.good.patterns.flightsSearch;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

public class FlightsBase {
    public final static Set<Flight> flights;

    static {
        Flight flight1 = new Flight("Gdańsk", "Kraków", LocalTime.of(7, 0), LocalTime.of(9, 0));
        Flight flight2 = new Flight("Gdańsk", "Kraków", LocalTime.of(11, 0), LocalTime.of(13, 0));
        Flight flight3 = new Flight("Gdańsk", "Wrocław", LocalTime.of(8, 0), LocalTime.of(10, 30));
        Flight flight4 = new Flight("Gdańsk", "Wrocław", LocalTime.of(12, 30), LocalTime.of(15, 0));
        Flight flight5 = new Flight("Kraków", "Gdańsk", LocalTime.of(6, 30), LocalTime.of(8, 30));
        Flight flight6 = new Flight("Kraków", "Gdańsk", LocalTime.of(14, 15), LocalTime.of(16, 15));
        Flight flight7 = new Flight("Kraków", "Wrocław", LocalTime.of(9, 15), LocalTime.of(10, 0));
        Flight flight8 = new Flight("Kraków", "Wrocław", LocalTime.of(13, 10), LocalTime.of(14, 55));
        Flight flight9 = new Flight("Wrocław", "Gdańsk", LocalTime.of(8, 30), LocalTime.of(11, 0));
        Flight flight10 = new Flight("Wrocław", "Gdańsk", LocalTime.of(16, 0), LocalTime.of(18, 30));
        Flight flight11 = new Flight("Wrocław", "Kraków", LocalTime.of(12, 30), LocalTime.of(13, 15));
        Flight flight12 = new Flight("Wrocław", "Kraków", LocalTime.of(16, 25), LocalTime.of(17, 10));

        flights = new HashSet<>();

        flights.add(flight1);
        flights.add(flight2);
        flights.add(flight3);
        flights.add(flight4);
        flights.add(flight5);
        flights.add(flight6);
        flights.add(flight7);
        flights.add(flight8);
        flights.add(flight9);
        flights.add(flight10);
        flights.add(flight11);
        flights.add(flight12);
    }
}
