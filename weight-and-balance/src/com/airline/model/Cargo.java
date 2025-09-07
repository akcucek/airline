package com.airline.model;

public class Cargo {
    private final String id;
    private final String description;
    private final double weight; // in kg

    public Cargo(String id, String description, double weight) {
        this.id = id;
        this.description = description;
        this.weight = weight;
    }

    public String getId() { return id; }
    public String getDescription() { return description; }
    public double getWeight() { return weight; }

    @Override
    public String toString() {
        return String.format("Cargo{id='%s', description='%s', weight=%.1f}",
                id, description, weight);
    }
}
