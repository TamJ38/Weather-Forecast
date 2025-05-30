package com.weatherforecast.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Data
public class Forecast {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonProperty
    private String city;
    @JsonProperty
    private LocalDate date;
    @JsonProperty
    private Double maxTemperature;
    @JsonProperty
    private boolean above25;
    @JsonProperty
    private boolean rainy;

    public Forecast(String city, LocalDate date, Double maxTemperature, boolean above25, boolean rainy) {
        this.city = city;
        this.date = date;
        this.maxTemperature = maxTemperature;
        this.above25 = above25;
        this.rainy = rainy;
    }

    public Forecast() {
    }

    public String getCity() {
        return this.city;
    }
}
