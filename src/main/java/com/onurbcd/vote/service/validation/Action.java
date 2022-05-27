package com.onurbcd.vote.service.validation;

import com.onurbcd.vote.service.enums.Error;
import com.onurbcd.vote.service.exception.ApiException;
import org.springframework.http.HttpStatus;

public class Action {

    private final boolean checkConditionNotTrue;

    private Action(boolean checkConditionNotTrue) {
        this.checkConditionNotTrue = checkConditionNotTrue;
    }

    public void orElseThrow(Error error, Object... args) {
        if (checkConditionNotTrue) {
            throw new ApiException(error, HttpStatus.CONFLICT, args);
        }
    }

    public void orElseThrowNotFound(Error error, Object... args) {
        if (checkConditionNotTrue) {
            throw new ApiException(error, HttpStatus.NOT_FOUND, args);
        }
    }

    public static Action checkIf(boolean checkCondition) {
        return new Action(!checkCondition);
    }

    public static <T> Action checkIfNotNull(T value) {
        return new Action(value == null);
    }
}
