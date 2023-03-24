package com.assignment.openweatherservice.dto;

public record Request(
        String type,
        String query,
        String language,
        String unit
) {}
