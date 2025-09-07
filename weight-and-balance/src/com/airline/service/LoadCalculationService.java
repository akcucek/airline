package com.airline.service;

import com.airline.model.Cargo;
import com.airline.model.Passenger;

import java.util.List;

/**
 * Performs detailed load distribution calculations (e.g., per zone, fuel balance).
 */
public class LoadCalculationService {

    public double calculatePassengerWeight(List<Passenger> passengers) {
        return passengers.stream().mapToDouble(Passenger::getWeight).sum();
    }

    public double calculateCargoWeight(List<Cargo> cargo) {
        return cargo.stream().mapToDouble(Cargo::getWeight).sum();
    }
}
