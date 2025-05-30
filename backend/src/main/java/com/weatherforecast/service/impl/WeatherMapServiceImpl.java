package com.weatherforecast.service.impl;

import com.weatherforecast.model.Forecast;
import com.weatherforecast.repository.ForecastRepository;
import com.weatherforecast.service.WeatherMapService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Map;

@Service
public class WeatherMapServiceImpl implements WeatherMapService {
    private final ForecastRepository forecastRepository;

    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${weather.api.key}")
    private String apiKey;


    private final Map<String, double[]> cities = Map.of(
            "Skopje", new double[]{41.9973462, 21.4279956},
            "Pehchevo", new double[]{41.7621467, 22.8865173},
            "Ohrid", new double[]{41.1230977, 20.8016481}
    );

    public WeatherMapServiceImpl(ForecastRepository forecastRepository) {
        this.forecastRepository = forecastRepository;
    }

    @Override
    public void fetchAndSaveForecasts() {
        for (Map.Entry<String, double[]> entry : cities.entrySet()) {
            String cityName = entry.getKey();
            double lat = entry.getValue()[0];
            double lon = entry.getValue()[1];

            String url = String.format(
                    "https://api.openweathermap.org/data/2.5/forecast/daily?lat=%f&lon=%f&cnt=16&units=metric&appid=%s",
                    lat, lon, apiKey
            );

            Map<String, Object> response = restTemplate.getForObject(url, Map.class);
            List<Map<String, Object>> list = (List<Map<String, Object>>) response.get("list");

            for (Map<String, Object> day : list) {
                long dt = ((Number) day.get("dt")).longValue();
                LocalDate date = Instant.ofEpochSecond(dt).atZone(ZoneId.systemDefault()).toLocalDate();

                Map<String, Object> temp = (Map<String, Object>) day.get("temp");
                double maxTemp = ((Number) temp.get("max")).doubleValue();

                boolean above25 = maxTemp > 25;

                boolean rainy = ((List<Map<String, Object>>) day.get("weather"))
                        .get(0).get("main").toString().toLowerCase().contains("rain");

                Forecast forecast = new Forecast(cityName, date, maxTemp, above25, rainy);
                forecastRepository.save(forecast);
            }
        }
    }
}
