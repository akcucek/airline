package com.airline.exception;

/**
 * Thrown when the aircraft center of gravity (CG) is outside allowable limits,
 * which makes the aircraft unsafe to fly.
 */
public class BalanceOutOfRangeException extends Exception {
    public BalanceOutOfRangeException(String message) {
        super(message);
    }
}