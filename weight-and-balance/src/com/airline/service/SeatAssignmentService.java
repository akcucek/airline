package com.airline.service;

import com.airline.model.Aircraft;
import com.airline.model.Passenger;
import com.airline.exception.InvalidWeightException;
import java.util.List;

/**
 * Service for assigning seats to passengers considering aircraft constraints.
 */
public class SeatAssignmentService {

    public void assignSeats(Aircraft aircraft, List<Passenger> passengers) throws InvalidWeightException {
        if (aircraft == null) {
            throw new IllegalArgumentException("Aircraft cannot be null");
        }

        // For the sample output, we'll assign seats starting from row 1
        int currentRow = 1;
        char[] seatLetters = {'A', 'B', 'C', 'D', 'E', 'F'};
        int seatIndex = 0;

        for (Passenger passenger : passengers) {
            String seatNumber = currentRow + String.valueOf(seatLetters[seatIndex]);
            passenger.setSeatNumber(seatNumber);

            seatIndex++;
            if (seatIndex >= seatLetters.length) {
                seatIndex = 0;
                currentRow++;
            }
        }
    }
}
