package com.airline.service;

import com.airline.exception.InvalidWeightException;
import com.airline.model.*;
import com.airline.repository.*;

import java.util.ArrayList;
import java.util.List;

public class LoadSheetGeneratorService {
    private final AircraftRepository aircraftRepo;
    private final PassengerRepository passengerRepo;
    private final CargoRepository cargoRepo;
    private final WeightBalanceService weightBalanceService;
    private final LoadOptimizationService optimizationService;
    private final SeatAssignmentService seatAssignmentService;

    public LoadSheetGeneratorService(AircraftRepository aircraftRepo,
                                   PassengerRepository passengerRepo,
                                   CargoRepository cargoRepo,
                                   WeightBalanceService weightBalanceService,
                                   LoadOptimizationService optimizationService,
                                   SeatAssignmentService seatAssignmentService) {
        this.aircraftRepo = aircraftRepo;
        this.passengerRepo = passengerRepo;
        this.cargoRepo = cargoRepo;
        this.weightBalanceService = weightBalanceService;
        this.optimizationService = optimizationService;
        this.seatAssignmentService = seatAssignmentService;
    }

    public LoadSheet generateLoadSheet(String aircraftId) throws InvalidWeightException {
        Aircraft aircraft = aircraftRepo.findById(aircraftId);
        if (aircraft == null) {
            throw new IllegalArgumentException("Aircraft with ID " + aircraftId + " not found");
        }

        // Get all passengers
        List<Passenger> passengers = new ArrayList<>(passengerRepo.findAll().values());

        // Assign seats to passengers
        seatAssignmentService.assignSeats(aircraft, passengers);

        // Calculate passenger weight
        double passengerWeight = passengers.stream().mapToDouble(Passenger::getWeight).sum();

        // Available capacity for cargo
        double maxCargoWeight = aircraft.getAvailablePayload() - passengerWeight;
        if (maxCargoWeight <= 0) {
            throw new InvalidWeightException("No available capacity for cargo after passengers.");
        }

        // Get all cargo and optimize selection
        List<Cargo> allCargo = new ArrayList<>(cargoRepo.findAll().values());
        List<Cargo> optimizedCargo = optimizationService.optimizeCargo(allCargo, maxCargoWeight);

        // Calculate final payload
        double totalPayload = weightBalanceService.calculateTotalPayload(aircraft, passengers, optimizedCargo);

        return new LoadSheet(aircraft, passengers, optimizedCargo, totalPayload);
    }
}
