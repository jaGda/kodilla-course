package com.kodilla.good.patterns.flightsSearch;

import java.time.LocalTime;

public class Flight {
    private final String departure;
    private final String arrival;
    private final LocalTime departureTime;
    private final LocalTime arrivalTime;

    public Flight(String departure, String arrival, LocalTime departureTime, LocalTime arrivalTime) {
        this.departure = departure;
        this.arrival = arrival;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public String getDeparture() {
        return departure;
    }

    public String getArrival() {
        return arrival;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Flight flight = (Flight) o;

        if (getDeparture() != null ? !getDeparture().equals(flight.getDeparture()) : flight.getDeparture() != null)
            return false;
        if (getArrival() != null ? !getArrival().equals(flight.getArrival()) : flight.getArrival() != null)
            return false;
        if (getDepartureTime() != null ? !getDepartureTime().equals(flight.getDepartureTime()) : flight.getDepartureTime() != null)
            return false;
        return getArrivalTime() != null ? getArrivalTime().equals(flight.getArrivalTime()) : flight.getArrivalTime() == null;
    }

    @Override
    public int hashCode() {
        int result = getDeparture() != null ? getDeparture().hashCode() : 0;
        result = 31 * result + (getArrival() != null ? getArrival().hashCode() : 0);
        result = 31 * result + (getDepartureTime() != null ? getDepartureTime().hashCode() : 0);
        result = 31 * result + (getArrivalTime() != null ? getArrivalTime().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Departure: " + departure + "," + departureTime +
                " | Arrival: " + arrival + "," + arrivalTime;
    }
}
