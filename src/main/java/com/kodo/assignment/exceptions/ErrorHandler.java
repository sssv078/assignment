package com.kodo.assignment.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.List;
import java.util.Map;

@ControllerAdvice
public class ErrorHandler {
    @ExceptionHandler(value = {ValidationBreachException.class})
    public ResponseEntity<Map<Integer, List<String>>> handleError (ValidationBreachException exception) {
        return new ResponseEntity(exception.getInValidMessages(), HttpStatus.EXPECTATION_FAILED);
    }
}