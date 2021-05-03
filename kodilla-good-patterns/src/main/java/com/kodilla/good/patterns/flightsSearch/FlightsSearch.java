package com.kodilla.good.patterns.flightsSearch;

public class FlightsSearch {

    public static void main(String[] args) {
        SearchService findDepartures = new SearchDepartures("Wrocław");
        findDepartures.find();

        System.out.println();

        SearchService findArrivals = new SearchArrivals("Wrocław");
        findArrivals.find();

        System.out.println();

        SearchService extendedDepartureSearch = new ExtendedDeparturesSearch("Gdańsk","Kraków","Wrocław");
        extendedDepartureSearch.find();
    }
}
