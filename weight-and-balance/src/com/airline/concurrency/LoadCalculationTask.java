package com.airline.concurrency;

import com.airline.model.Aircraft;
import com.airline.model.Cargo;
import com.airline.model.Passenger;
import com.airline.service.WeightBalanceService;

import java.util.List;
import java.util.concurrent.Callable;

/**
 * A task for calculating total payload in parallel.
 * Implements Callable so it can return a result.
 */
public class LoadCalculationTask implements Callable<Double> {

    private final WeightBalanceService weightBalanceService;
    private final Aircraft aircraft;
    private final List<Passenger> passengers;
    private final List<Cargo> cargo;

    public LoadCalculationTask(WeightBalanceService weightBalanceService,
                               Aircraft aircraft,
                               List<Passenger> passengers,
                               List<Cargo> cargo) {
        this.weightBalanceService = weightBalanceService;
        this.aircraft = aircraft;
        this.passengers = passengers;
        this.cargo = cargo;
    }

    @Override
    public Double call() throws Exception {
        return weightBalanceService.calculateTotalPayload(aircraft, passengers, cargo);
    }
}