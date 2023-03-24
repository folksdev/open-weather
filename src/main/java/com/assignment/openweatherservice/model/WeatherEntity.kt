package com.assignment.openweatherservice.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import org.hibernate.annotations.GenericGenerator
import java.time.LocalDateTime

@Entity
data class WeatherEntity @JvmOverloads constructor(
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    val id: String? = "",
    val requestedCityName: String,
    val cityName: String,
    val country: String,
    val temperature: Int,
    val updatedTime: LocalDateTime,
    val responseLocalTime: LocalDateTime
)