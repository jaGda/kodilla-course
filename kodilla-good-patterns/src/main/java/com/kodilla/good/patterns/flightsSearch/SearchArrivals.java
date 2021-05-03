package com.kodilla.good.patterns.flightsSearch;

public class SearchArrivals implements SearchService {
    private final String arrival;

    public SearchArrivals(String arrival) {
        this.arrival = arrival;
    }

    @Override
    public void find() {
        FlightsBase.flights.stream()
                .filter(flight -> flight.getArrival().equals(arrival))
                .forEach(System.out::println);
    }
}
