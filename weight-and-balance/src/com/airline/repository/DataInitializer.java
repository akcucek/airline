package com.airline.repository;

import com.airline.model.Aircraft;
import com.airline.model.Cargo;
import com.airline.model.GraphNode;
import com.airline.model.Passenger;

import java.util.Arrays;
import java.util.List;

/**
 * Preloads sample data into repositories for testing/demo purposes.
 */
public class DataInitializer {

    private final AircraftRepository aircraftRepo;
    private final PassengerRepository passengerRepo;
    private final CargoRepository cargoRepo;
    private final GraphRepository graphRepo;

    public DataInitializer(AircraftRepository aircraftRepo,
                           PassengerRepository passengerRepo,
                           CargoRepository cargoRepo,
                           GraphRepository graphRepo) {
        this.aircraftRepo = aircraftRepo;
        this.passengerRepo = passengerRepo;
        this.cargoRepo = cargoRepo;
        this.graphRepo = graphRepo;
    }

    /**
     * Loads default test data into repositories.
     */
    public void loadSampleData() {
        // ---- Aircraft ----
        Aircraft aircraft1 = new Aircraft("A320", "Airbus A320", 77000, 42000, 35000);
        Aircraft aircraft2 = new Aircraft("B737", "Boeing 737", 79000, 43000, 8500);

        aircraftRepo.save(aircraft1);
        aircraftRepo.save(aircraft2);

        // ---- Passengers ----
        List<Passenger> passengers = Arrays.asList(
                new Passenger("P1", "Alice", 70),
                new Passenger("P2", "Bob", 85),
                new Passenger("P3", "Charlie", 65)
        );
        passengers.forEach(passengerRepo::save);

        // ---- Cargo ----
        List<Cargo> cargo = Arrays.asList(
                new Cargo("C1", "Baggage", 500),
                new Cargo("C2", "Mail", 300)
        );
        cargo.forEach(cargoRepo::save);

        // ---- Graph Nodes ----
        GraphNode n1 = new GraphNode("Gate A");
        GraphNode n2 = new GraphNode("Security");
        GraphNode n3 = new GraphNode("Boarding");
        GraphNode n4 = new GraphNode("Runway");

        n1.addNeighbor(n2);
        n2.addNeighbor(n3);
        n3.addNeighbor(n4);

        graphRepo.save(n1);
        graphRepo.save(n2);
        graphRepo.save(n3);
        graphRepo.save(n4);
    }
}
