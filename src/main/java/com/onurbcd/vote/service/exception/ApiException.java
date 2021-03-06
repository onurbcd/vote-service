package com.onurbcd.vote.service.exception;

import com.onurbcd.vote.service.enums.Error;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.io.Serial;
import java.util.function.Supplier;

@Getter
public class ApiException extends RuntimeException implements Supplier<ApiException> {

    @Serial
    private static final long serialVersionUID = -4588973589702747798L;

    private final Error error;

    private final HttpStatus httpStatus;

    public ApiException(Error error, String errorMessage, HttpStatus httpStatus) {
        super(errorMessage);
        this.error = error;
        this.httpStatus = httpStatus;
    }

    public ApiException(Error error, HttpStatus httpStatus, Object... args) {
        this(error, error.format(args), httpStatus);
    }

    @Override
    public ApiException get() {
        return this;
    }
}
