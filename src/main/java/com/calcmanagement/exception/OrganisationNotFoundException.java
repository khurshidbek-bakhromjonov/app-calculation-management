package com.calcmanagement.exception;

public class OrganisationNotFoundException extends RuntimeException {
    public OrganisationNotFoundException(String message) {
        super(message);
    }
}
