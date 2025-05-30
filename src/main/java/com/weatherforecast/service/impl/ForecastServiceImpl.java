package com.weatherforecast.service.impl;

import com.weatherforecast.model.Forecast;
import com.weatherforecast.repository.ForecastRepository;
import com.weatherforecast.service.ForecastService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ForecastServiceImpl implements ForecastService {

    private final ForecastRepository forecastRepository;

    public ForecastServiceImpl(ForecastRepository forecastRepository) {
        this.forecastRepository = forecastRepository;
    }

    @Override
    public List<Forecast> getAll() {
        return forecastRepository.findAll();
    }

    @Override
    public List<Forecast> findByCity(String city) {
        return forecastRepository.findByCity(city);
    }

    @Override
    public List<Forecast> findByRainyTrue() {
        return forecastRepository.findByRainyTrue();
    }

    @Override
    public List<Forecast> findByAbove25True() {
        return forecastRepository.findByAbove25True();
    }

    @Override
    public List<Forecast> findByCityAndAbove25IsTrue(String city) {
        return forecastRepository.findByCityAndAbove25IsTrue(city);
    }

    @Override
    public List<Forecast> findByCityAndRainyIsTrue(String city) {
        return forecastRepository.findByCityAndRainyIsTrue(city);
    }

    @Override
    public List<Forecast> findByCityAndDate(String city, LocalDate date) {
        return forecastRepository.findByCityAndDate(city, date);
    }

    @Override
    public void deleteByCity(String city) {
        forecastRepository.deleteByCity(city);
    }
}
