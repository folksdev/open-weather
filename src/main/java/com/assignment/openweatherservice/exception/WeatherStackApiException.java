package com.assignment.openweatherservice.exception;

import java.util.Objects;

public class WeatherStackApiException extends RuntimeException {

    private ErrorResponse errorResponse;

    public WeatherStackApiException(ErrorResponse errorResponse) {
        this.errorResponse = errorResponse;
    }

    public ErrorResponse getErrorResponse() {
        return errorResponse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeatherStackApiException that = (WeatherStackApiException) o;
        return Objects.equals(errorResponse, that.errorResponse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(errorResponse);
    }
}
