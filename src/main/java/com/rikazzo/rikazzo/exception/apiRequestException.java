package com.rikazzo.rikazzo.exception;

public class apiRequestException extends RuntimeException{

    public apiRequestException(String message) {
        super(message);
    }

    public apiRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}