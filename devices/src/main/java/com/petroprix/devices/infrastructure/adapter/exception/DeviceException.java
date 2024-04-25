package com.petroprix.devices.infrastructure.adapter.exception;

import org.springframework.http.HttpStatus;

public class DeviceException extends RuntimeException{

    private HttpStatus errorCode;
    private String errorMessage;

    public DeviceException() {
    }

    public DeviceException(HttpStatus errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }


    public HttpStatus getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(HttpStatus errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
