package com.assignment.openweatherservice.config;

import com.assignment.openweatherservice.exception.RestTemplateErrorHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    private HttpComponentsClientHttpRequestFactory  getClientHttpRequestFactory() {

        // Create an instance of Apache HttpClient
        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory
                = new HttpComponentsClientHttpRequestFactory();

        int connectTimeout = 5000;

        clientHttpRequestFactory.setConnectTimeout(connectTimeout);

        return clientHttpRequestFactory;
    }

    @Bean
    public RestTemplate getRestTemplate() {
        RestTemplate restTemplate = new RestTemplate(getClientHttpRequestFactory());
        restTemplate.setErrorHandler(new RestTemplateErrorHandler());
        return restTemplate;
    }
}
