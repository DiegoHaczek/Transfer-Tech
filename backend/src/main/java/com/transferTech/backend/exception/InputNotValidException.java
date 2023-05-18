package com.transferTech.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class InputNotValidException extends ResponseStatusException {
    public InputNotValidException(String message) { super(HttpStatus.BAD_REQUEST, message);}
}
