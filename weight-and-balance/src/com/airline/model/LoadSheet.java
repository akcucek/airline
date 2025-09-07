package com.airline.model;

import java.util.List;

public class LoadSheet {
    private final Aircraft aircraft;
    private final List<Passenger> passengers;
    private final List<Cargo> cargo;
    private final double totalPayload;

    public LoadSheet(Aircraft aircraft, List<Passenger> passengers, List<Cargo> cargo, double totalPayload) {
        this.aircraft = aircraft;
        this.passengers = passengers;
        this.cargo = cargo;
        this.totalPayload = totalPayload;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LoadSheet {\n");
        sb.append("  Aircraft=").append(aircraft).append("\n");
        sb.append("  Passengers=[");

        // Format passengers
        for (int i = 0; i < passengers.size(); i++) {
            if (i > 0) sb.append(", ");
            sb.append(passengers.get(i));
        }
        sb.append("]\n");

        // Format cargo
        sb.append("  Cargo=[");
        for (int i = 0; i < cargo.size(); i++) {
            if (i > 0) sb.append(", ");
            sb.append(cargo.get(i));
        }
        sb.append("]\n");

        sb.append("  TotalPayload=").append(String.format("%.1f", totalPayload)).append(" kg\n");
        sb.append("  SeatAssignments:\n");

        // Sort and format seat assignments
        passengers.stream()
                 .sorted((p1, p2) -> p1.getSeatNumber().compareTo(p2.getSeatNumber()))
                 .forEach(p -> sb.append("    ")
                                .append(p.getId())
                                .append(" -> ")
                                .append(p.getSeatNumber())
                                .append("\n"));

        sb.append("}");
        return sb.toString();
    }
}
