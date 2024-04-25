package com.petroprix.devices.infrastructure.adapter.exception;

public class DataBaseException extends RuntimeException{

    public DataBaseException() {
    }

    public DataBaseException(String message) {
        super(message);
    }
}
