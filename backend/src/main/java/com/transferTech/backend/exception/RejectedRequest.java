package com.transferTech.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class RejectedRequest extends ResponseStatusException {
    public RejectedRequest(String message) { super(HttpStatus.ACCEPTED, message);}
}