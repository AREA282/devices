package com.petroprix.devices.infrastructure.rest.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
@Getter
public class Response {

    private String message;
    private int statusCode;
}
