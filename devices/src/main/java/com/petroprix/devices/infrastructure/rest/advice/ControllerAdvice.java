package com.petroprix.devices.infrastructure.rest.advice;

import com.petroprix.devices.infrastructure.adapter.exception.DeviceException;
import com.petroprix.devices.infrastructure.rest.response.ErrorResponse;
import com.petroprix.devices.infrastructure.rest.response.ErrorResponseMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice(annotations = RestController.class)
public class ControllerAdvice {

    private static final Logger LOGGER = LogManager.getLogger(ControllerAdvice.class);

    @ExceptionHandler(DeviceException.class)
    public ResponseEntity<ErrorResponse> handleInput(DeviceException deviceException){
        LOGGER.error(deviceException.getErrorMessage());
        ErrorResponse errorResponse = new ErrorResponse(deviceException.getErrorMessage(), deviceException.getErrorCode().value());
        return ResponseEntity.status(deviceException.getErrorCode()).body(errorResponse);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<ErrorResponseMap> handleInvalidArguments(MethodArgumentNotValidException exception) {
        Map<String, String> errors = new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
        ErrorResponseMap errorResponseMap = new ErrorResponseMap(errors, HttpStatus.BAD_REQUEST.value());
        LOGGER.error("Uno o mas atributos son incorrectos");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponseMap);
    }

}

