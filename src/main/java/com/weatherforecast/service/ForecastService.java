package com.weatherforecast.service;


import com.weatherforecast.model.Forecast;

import java.time.LocalDate;
import java.util.List;

public interface ForecastService {
    List<Forecast> getAll();

    List<Forecast> findByCity(String city);

    List<Forecast> findByRainyTrue();

    List<Forecast> findByAbove25True();

    List<Forecast> findByCityAndAbove25IsTrue(String city);

    List<Forecast> findByCityAndRainyIsTrue(String city);

    List<Forecast> findByCityAndDate(String city, LocalDate date);

    void deleteByCity(String city);
}
