package com.disneyChallenge.demo.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
@RestController
public class MyControllerAdvice extends ResponseEntityExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(NoSuchElementException.class)
    public final ResponseEntity<String> handle(NoSuchElementException ex, WebRequest request) {
       return new ResponseEntity<>("Element not exists, please change the request", HttpStatus.NOT_FOUND);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(IllegalArgumentException.class)
    public final ResponseEntity<String> handle(IllegalArgumentException ex, WebRequest request) {
       return new ResponseEntity<>("Input fiel is invalid, please check it", HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(RuntimeException.class)
    public final ResponseEntity<String> handle(RuntimeException ex, WebRequest request) {
        return new ResponseEntity<>("Server error, please try later", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
