package com.weatherforecast.repository;

import com.weatherforecast.model.Forecast;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ForecastRepository extends JpaRepository<Forecast, Long> {
    List<Forecast> findByCity(String city);

    List<Forecast> findByRainyTrue();

    List<Forecast> findByAbove25True();

    List<Forecast> findByCityAndAbove25IsTrue(String city);

    List<Forecast> findByCityAndRainyIsTrue(String city);

    List<Forecast> findByCityAndDate(String city, LocalDate date);

    void deleteByCity(String city);

}
