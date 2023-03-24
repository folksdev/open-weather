package com.assignment.openweatherservice.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.assignment.openweatherservice.constants.Constants.WEATHER_CACHE_NAME;

@Configuration
@EnableCaching
public class SpringCachingConfig {

    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager(WEATHER_CACHE_NAME);
    }

}
