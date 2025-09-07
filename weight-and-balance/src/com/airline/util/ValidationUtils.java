package com.airline.util;

import com.airline.model.Aircraft;
import com.airline.model.Passenger;
import com.airline.model.Cargo;

/**
 * Utility class for validation methods used across services.
 */
public class ValidationUtils {

    public static void validateAircraft(Aircraft aircraft) {
        if (aircraft == null) {
            throw new IllegalArgumentException("Aircraft cannot be null");
        }
        if (aircraft.getMaxTakeoffWeight() <= 0 || aircraft.getOperatingEmptyWeight() <= 0) {
            throw new IllegalArgumentException("Aircraft weights must be positive");
        }
    }

    public static void validatePassenger(Passenger passenger) {
        if (passenger == null) {
            throw new IllegalArgumentException("Passenger cannot be null");
        }
        if (passenger.getWeight() <= 0) {
            throw new IllegalArgumentException("Passenger weight must be greater than 0");
        }
    }

    public static void validateCargo(Cargo cargo) {
        if (cargo == null) {
            throw new IllegalArgumentException("Cargo cannot be null");
        }
        if (cargo.getWeight() <= 0) {
            throw new IllegalArgumentException("Cargo weight must be greater than 0");
        }
    }
}
