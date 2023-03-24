package com.assignment.openweatherservice.dto;

public record WeatherResponse(
        Request request,
        Location location,
        Current current
) { }
