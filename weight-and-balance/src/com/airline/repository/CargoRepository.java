package com.airline.repository;

import com.airline.model.Cargo;
import java.util.HashMap;
import java.util.Map;

public class CargoRepository {
    private final Map<String, Cargo> cargoMap = new HashMap<>();

    public void save(Cargo cargo) {
        cargoMap.put(cargo.getId(), cargo);
    }

    public Cargo findById(String id) {
        return cargoMap.get(id);
    }

    public Map<String, Cargo> findAll() {
        return cargoMap;
    }
}
