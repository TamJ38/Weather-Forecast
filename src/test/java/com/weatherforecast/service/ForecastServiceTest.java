package com.weatherforecast.service;

import com.weatherforecast.model.Forecast;
import com.weatherforecast.repository.ForecastRepository;
import com.weatherforecast.service.impl.ForecastServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ForecastServiceTest {

    @Autowired
    private ForecastServiceImpl forecastServiceImpl;
    @Autowired
    private ForecastRepository forecastRepository;

    @Test
    public void testFindByCity() {
        Forecast forecast = new Forecast("Skopje", LocalDate.now(), 26.0, true, false);
        forecastRepository.save(forecast);

        List<Forecast> results = forecastServiceImpl.findByCity("Skopje");

        assertFalse(results.isEmpty());
        assertEquals("Skopje", results.get(0).getCity());
        forecastRepository.delete(forecast);
    }
}
