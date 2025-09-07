package com.airline.exception;

/**
 * Thrown when the calculated or provided weight exceeds aircraft limits
 * or is invalid (negative, zero, etc.).
 */
public class InvalidWeightException extends Exception {
    public InvalidWeightException(String message) {
        super(message);
    }
}