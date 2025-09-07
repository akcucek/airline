package com.airline.repository;

import com.airline.model.Passenger;
import java.util.HashMap;
import java.util.Map;

public class PassengerRepository {
    private final Map<String, Passenger> passengerMap = new HashMap<>();

    public void save(Passenger passenger) {
        passengerMap.put(passenger.getId(), passenger);
    }

    public Passenger findById(String id) {
        return passengerMap.get(id);
    }

    public Map<String, Passenger> findAll() {
        return passengerMap;
    }
}
