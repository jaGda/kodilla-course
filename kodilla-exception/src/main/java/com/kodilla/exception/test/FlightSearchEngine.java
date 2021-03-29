package com.kodilla.exception.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlightSearchEngine {

    public static String findFlight(Flight flight) throws RouteNotFoundException {

        Map<String, Boolean> airports = new HashMap<>();
        airports.put("Warsaw", true);
        airports.put("Berlin", false);
        airports.put("Gdansk", true);
        airports.put("Krakow", false);

        if (!airports.containsKey(flight.getDepartureAirport())) {
            throw new RouteNotFoundException("Destination airport isn't available!");
        }

        return airports.get(flight.getDepartureAirport()) ? "Places available" : "No places";
    }

    public static void main(String[] args) {
        List<Flight> flights = new ArrayList<>();
        flights.add(new Flight("Poznan", "Gdansk"));
        flights.add(new Flight("Gdansk", "Warsaw"));
        flights.add(new Flight("Berlin", "Warsaw"));
        flights.add(new Flight("Krakow", "Berlin"));

        flights.forEach(flight -> {
            try {
                System.out.println(findFlight(flight));
            } catch (RouteNotFoundException e) {
                System.out.println(e.getMessage());
            }
        });

    }
}
