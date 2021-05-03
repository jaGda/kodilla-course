package com.kodilla.good.patterns.flightsSearch;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ExtendedDeparturesSearch implements SearchService {
    private final String departure;
    private final String through;
    private final String arrival;
    private final List<Flight> flights;

    public ExtendedDeparturesSearch(String departure, String through, String arrival) {
        this.departure = departure;
        this.through = through;
        this.arrival = arrival;
        this.flights = new ArrayList<>();
    }

    @Override
    public void find() {
        findDeparture(departure, through);
        findDeparture(through, arrival);
        flights.forEach(System.out::println);
    }

    private void findDeparture(String departure, String arrival) {
        FlightsBase.flights.stream()
                .filter(flight -> flight.getDeparture().equals(departure)
                        && flight.getArrival().equals(arrival))
                .sorted(Comparator.comparing(Flight::getDepartureTime))
                .forEach(flights::add);
    }
}
