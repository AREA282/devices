package com.petroprix.devices.infrastructure.rest.response;

import lombok.Getter;

import java.util.Map;
@Getter
public class ErrorResponseMap {

    Map<String, String> message;
    private int statusCode;

    public ErrorResponseMap(Map<String, String> message, int statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }

    public Map<String, String> getMessage() {
        return message;
    }

    public void setMessage(Map<String, String> message) {
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

}
