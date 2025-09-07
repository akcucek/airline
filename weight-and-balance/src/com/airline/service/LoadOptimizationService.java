package com.airline.service;

import com.airline.model.Cargo;
import java.util.ArrayList;
import java.util.List;

public class LoadOptimizationService {

    /**
     * Optimizes cargo selection based on available weight capacity.
     * For the sample output, we'll simply return the first few cargo items that fit.
     */
    public List<Cargo> optimizeCargo(List<Cargo> availableCargo, double maxWeight) {
        List<Cargo> selectedCargo = new ArrayList<>();
        double currentWeight = 0;

        for (Cargo cargo : availableCargo) {
            if (currentWeight + cargo.getWeight() <= maxWeight) {
                selectedCargo.add(cargo);
                currentWeight += cargo.getWeight();
            }
        }

        return selectedCargo;
    }
}
