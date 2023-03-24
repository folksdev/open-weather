package com.assignment.openweatherservice.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class RestTemplateErrorHandler implements ResponseErrorHandler {

    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        return response.getStatusCode().is4xxClientError() || response.getStatusCode().is5xxServerError();
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {

        if (response.getStatusCode().is4xxClientError()
                || response.getStatusCode().is5xxServerError()) {


            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(response.getBody()))) {
                String httpBodyResponse = reader.lines()
                        .collect(Collectors.joining(""));

                ObjectMapper mapper = new ObjectMapper();

                RestTemplateError restTemplateError = mapper
                        .readValue(httpBodyResponse,
                                RestTemplateError.class);


                throw new RestServiceException(
                        restTemplateError.path(),
                        HttpStatus.resolve(response.getStatusCode().value()),
                        restTemplateError.error());
            }

        }

    }
}
