package com.airline.repository;

import com.airline.model.Aircraft;
import java.util.HashMap;
import java.util.Map;

public class AircraftRepository {
    private final Map<String, Aircraft> aircraftMap = new HashMap<>();

    public void save(Aircraft aircraft) {
        aircraftMap.put(aircraft.getId(), aircraft);
    }

    public Aircraft findById(String id) {
        return aircraftMap.get(id);
    }

    public Map<String, Aircraft> findAll() {
        return aircraftMap;
    }
}
