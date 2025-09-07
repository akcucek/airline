package com.airline.model;

/**
 * Represents a passenger with name, weight and seat assignment.
 */
public class Passenger {
    private final String id;
    private final String name;
    private final double weight; // in kg
    private String seatNumber;

    public Passenger(String id, String name, double weight) {
        this.id = id;
        this.name = name;
        this.weight = weight;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public double getWeight() { return weight; }
    public String getSeatNumber() { return seatNumber; }
    public void setSeatNumber(String seatNumber) { this.seatNumber = seatNumber; }

    @Override
    public String toString() {
        return String.format("Passenger{id='%s', name='%s', weight=%.1f}",
                id, name, weight);
    }
}
