package com.assignment.openweatherservice.repository;

import com.assignment.openweatherservice.model.WeatherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.Optional;

public interface WeatherRepository extends JpaRepository<WeatherEntity, Long> {

    Optional<WeatherEntity> findFirstByRequestedCityNameOrderByUpdatedTimeDesc(String city);

}
