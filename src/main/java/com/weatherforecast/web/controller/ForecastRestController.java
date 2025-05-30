package com.weatherforecast.web.controller;

import com.weatherforecast.model.Forecast;
import com.weatherforecast.service.WeatherMapService;
import com.weatherforecast.service.impl.ForecastServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin()
@RestController
@RequestMapping("/api/forecast")
public class ForecastRestController {
    private final WeatherMapService weatherService;
    private final ForecastServiceImpl forecastServiceImpl;

    public ForecastRestController(WeatherMapService weatherService, ForecastServiceImpl forecastServiceImpl) {
        this.weatherService = weatherService;
        this.forecastServiceImpl = forecastServiceImpl;
    }

    @PostMapping("/fetch")
    public String fetchForecasts() {
        weatherService.fetchAndSaveForecasts();
        return "Forecasts are fetched and saved!";
    }

    @GetMapping
    public List<Forecast> getAllForecasts() {
        return forecastServiceImpl.getAll();
    }

    @GetMapping("/{city}")
    public List<Forecast> getAllForecasts(@PathVariable String city) {
        return forecastServiceImpl.findByCity(city);
    }

    @GetMapping("/above25")
    public List<Forecast> getAbove25() {
        return forecastServiceImpl.findByAbove25True();
    }

    @GetMapping("/rainy")
    public List<Forecast> getRainy() {
        return forecastServiceImpl.findByRainyTrue();
    }

    @GetMapping("/above25/{city}")
    public List<Forecast> getHotDays(@PathVariable String city) {
        return forecastServiceImpl.findByCityAndAbove25IsTrue(city);
    }

    @GetMapping("/rainy/{city}")
    public List<Forecast> getRainyDays(@PathVariable String city) {
        return forecastServiceImpl.findByCityAndRainyIsTrue(city);
    }
}
