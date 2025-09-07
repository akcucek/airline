package com.airline;

import com.airline.exception.InvalidWeightException;
import com.airline.model.*;
import com.airline.repository.*;
import com.airline.service.LoadOptimizationService;
import com.airline.service.LoadSheetGeneratorService;
import com.airline.service.SeatAssignmentService;
import com.airline.service.WeightBalanceService;

public class Main {
    public static void main(String[] args) {
        try {
            // Create repositories
            AircraftRepository aircraftRepo = new AircraftRepository();
            PassengerRepository passengerRepo = new PassengerRepository();
            CargoRepository cargoRepo = new CargoRepository();
            GraphRepository graphRepo = new GraphRepository();

            // Load sample data
            DataInitializer initializer = new DataInitializer(aircraftRepo, passengerRepo, cargoRepo, graphRepo);
            initializer.loadSampleData();

            // Initialize services
            WeightBalanceService weightBalanceService = new WeightBalanceService();
            LoadOptimizationService optimizationService = new LoadOptimizationService();
            SeatAssignmentService seatService = new SeatAssignmentService();

            // Create the load sheet generator service
            LoadSheetGeneratorService loadSheetService = new LoadSheetGeneratorService(
                    aircraftRepo,
                    passengerRepo,
                    cargoRepo,
                    weightBalanceService,
                    optimizationService,
                    seatService);

            // Generate and print load sheet
            LoadSheet sheet = loadSheetService.generateLoadSheet("A320");
            System.out.println("Final LoadSheet with Seats:\n" + sheet);

        } catch (InvalidWeightException e) {
            System.err.println("❌ Weight Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("❌ Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
