package com.assignment.openweatherservice.exception;

import org.springframework.http.HttpStatus;

public class RestServiceException extends RuntimeException{

    private String serviceName;
    private HttpStatus statusCode;
    private String error;

    public RestServiceException(
            String serviceName,
            HttpStatus statusCode,
            String error) {

        super();
        this.serviceName = serviceName;
        this.statusCode = statusCode;
        this.error = error;
    }
}
