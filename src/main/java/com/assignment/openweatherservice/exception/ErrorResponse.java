package com.assignment.openweatherservice.exception;

public record ErrorResponse (
        String success,
        Error error
) { }
