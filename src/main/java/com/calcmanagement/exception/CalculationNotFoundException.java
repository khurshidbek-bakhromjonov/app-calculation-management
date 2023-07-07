package com.calcmanagement.exception;

public class CalculationNotFoundException extends RuntimeException {

    public CalculationNotFoundException(String message) {
        super(message);
    }
}
