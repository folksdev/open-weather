package com.assignment.openweatherservice.exception;

public record RestTemplateError (
       String timestamp,
       String status,
       String error,
       String path
){ }
