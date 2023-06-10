package com.transferTech.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class CantBeEmptyException extends ResponseStatusException {
    public CantBeEmptyException(String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }
}