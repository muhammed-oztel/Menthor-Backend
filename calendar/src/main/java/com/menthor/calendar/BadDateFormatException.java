package com.menthor.calendar;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
class BadDateFormatException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public BadDateFormatException(String dateString) {
        super(dateString);
    }
}