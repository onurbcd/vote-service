package com.onurbcd.vote.service.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Error {

    INTERNAL_SERVER_ERROR("Internal Server Error"),

    CONSTRAINT_VIOLATION("Constraint Violation"),

    PSQL("PSQL Exception");

    private final String message;

    public String format(Object... args) {
        return String.format(message, args);
    }
}
