package com.kodilla.good.patterns.flightsSearch;

public class SearchDepartures implements SearchService {
    private final String departure;

    public SearchDepartures(String departure) {
        this.departure = departure;
    }

    @Override
    public void find() {
        FlightsBase.flights.stream()
                .filter(flight -> flight.getDeparture().equals(departure))
                .forEach(System.out::println);
    }
}
