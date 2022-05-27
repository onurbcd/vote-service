package com.onurbcd.vote.service.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Error {

    INTERNAL_SERVER_ERROR("Internal Server Error"),

    CONSTRAINT_VIOLATION("Constraint Violation"),

    PSQL("PSQL Exception"),

    AGENDA_ID_IS_NULL("Agenda id is mandatory"),

    AGENDA_DOES_NOT_EXIST("Agenda with id '%s' does not exist in the database"),

    SESSION_ALREADY_OPENED("There is already an open voting session for the agenda with id '%s'");

    private final String message;

    public String format(Object... args) {
        return String.format(message, args);
    }
}
