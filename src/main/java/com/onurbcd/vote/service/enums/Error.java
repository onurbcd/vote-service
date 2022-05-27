package com.onurbcd.vote.service.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Error {

    INTERNAL_SERVER_ERROR("Internal Server Error"),

    CONSTRAINT_VIOLATION("Constraint Violation"),

    PSQL("PSQL Exception"),

    AGENDA_ID_IS_NULL("Agenda id is mandatory"),

    AGENDA_DOES_NOT_EXIST("Agenda with id '%s' does not exist in the database"),

    SESSION_ALREADY_OPENED("There is already an open voting session for the agenda with id '%s'"),

    SESSION_ID_IS_NULL("Session id is mandatory"),

    ASSOCIATE_ID_IS_NULL("Associate id is mandatory"),

    VOTE_RESULT_IS_NULL("Vote result is mandatory"),

    SESSION_DOES_NOT_EXIST("Session with id '%s' does not exist in the database"),

    SESSION_IS_CLOSED("Session with id '%s' is closed"),

    ASSOCIATE_DOES_NOT_EXIST("Associate with id '%s' does not exist in the database"),

    ASSOCIATE_ALREADY_VOTED("The associate with id '%s' has already voted for the agenda with with id '%s'");

    private final String message;

    public String format(Object... args) {
        return String.format(message, args);
    }
}
