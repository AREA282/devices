package com.petroprix.devices.domain.model.dto;

import org.springframework.http.HttpStatus;

public class CustomResponseDTO {

    private String code;

    private String message;

    private int state;

    private Object responseObject;

    public CustomResponseDTO() {
    }

    public CustomResponseDTO(String message, HttpStatus state) {
        this.message = message;
        this.state = state.value();
        this.code = state.name();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Object getResponseObject() {
        return responseObject;
    }

    public void setResponseObject(Object responseObject) {
        this.responseObject = responseObject;
    }
}
