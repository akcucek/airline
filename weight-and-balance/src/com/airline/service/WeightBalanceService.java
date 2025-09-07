package com.airline.service;

import com.airline.exception.InvalidWeightException;
import com.airline.model.Aircraft;
import com.airline.model.Cargo;
import com.airline.model.Passenger;

import java.util.List;

public class WeightBalanceService {

    /**
     * Calculates the total payload (passengers + cargo).
     */
    public double calculateTotalPayload(Aircraft aircraft,
                                        List<Passenger> passengers,
                                        List<Cargo> cargo) throws InvalidWeightException {
        double passengerWeight = passengers.stream()
                .mapToDouble(Passenger::getWeight)
                .sum();

        double cargoWeight = cargo.stream()
                .mapToDouble(Cargo::getWeight)
                .sum();

        double totalPayload = passengerWeight + cargoWeight;

        if (totalPayload > aircraft.getAvailablePayload()) {
            throw new InvalidWeightException(
                    String.format("Total payload (%.1f kg) exceeds aircraft capacity (%.1f kg)",
                            totalPayload, aircraft.getAvailablePayload()));
        }

        return totalPayload;
    }
}
