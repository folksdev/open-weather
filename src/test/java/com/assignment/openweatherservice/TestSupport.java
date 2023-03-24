package com.assignment.openweatherservice;

import com.assignment.openweatherservice.model.WeatherEntity;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestSupport {

    public static final String WEATHER_API_ENDPOINT = "/v1/api/open-weather";
    public final String WEATHER_STACK_API_URL = "weather-base-api-url?access_key=api-key&query=";

    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public static String requestedCity = "amsterdam";

    public Instant getCurrentInstant() {
        String instantExpected = "2023-03-08T10:15:30Z";
        Clock clock = Clock.fixed(Instant.parse(instantExpected), Clock.systemDefaultZone().getZone());

        return Instant.now(clock);
    }

    public LocalDateTime getCurrentLocalDateTime(){
        return LocalDateTime.ofInstant(getCurrentInstant(), Clock.systemDefaultZone().getZone());
    }

    public WeatherEntity getSavedWeatherEntity(String responseLocalTime) {
        return new WeatherEntity("id",
                requestedCity,
                "Amsterdam",
                "Netherlands",
                2,
                getCurrentLocalDateTime(),
                LocalDateTime.parse(responseLocalTime, formatter));
    }

    public WeatherEntity getToSavdWeatherEntity(String responseLocalTime) {
        return new WeatherEntity( requestedCity,
                "Amsterdam",
                "Netherlands",
                2,
                getCurrentLocalDateTime(),
                LocalDateTime.parse(responseLocalTime, formatter));
    }
    public String getAmsterdamWeatherJson() {
        return """
                {
                    "request": {
                        "type": "City",
                        "query": "Amsterdam, Netherlands",
                        "language": "en",
                        "unit": "m"
                    },
                    "location": {
                        "name": "Amsterdam",
                        "country": "Netherlands",
                        "region": "North Holland",
                        "lat": "52.374",
                        "lon": "4.890",
                        "timezone_id": "Europe/Amsterdam",
                        "localtime": "2023-03-08 21:45",
                        "localtime_epoch": 1678311900,
                        "utc_offset": "1.0"
                    },
                    "current": {
                        "observation_time": "08:45 PM",
                        "temperature": 2,
                        "weather_code": 113,
                        "weather_icons": [
                            "https://cdn.worldweatheronline.com/images/wsymbols01_png_64/wsymbol_0008_clear_sky_night.png"
                        ],
                        "weather_descriptions": [
                            "Clear"
                        ],
                        "wind_speed": 11,
                        "wind_degree": 70,
                        "wind_dir": "ENE",
                        "pressure": 992,
                        "precip": 0,
                        "humidity": 87,
                        "cloudcover": 0,
                        "feelslike": -2,
                        "uv_index": 1,
                        "visibility": 10,
                        "is_day": "no"
                    }
                }
                """;
    }

    public String getErrorResponseJson() {
        return """
                {
                    "success": false,
                    "error": {
                        "code": 105,
                        "type": "https_access_restricted",
                        "info": "Access Restricted - Your current Subscription Plan does not support HTTPS Encryption."
                    }
                }
                """;
    }
}
