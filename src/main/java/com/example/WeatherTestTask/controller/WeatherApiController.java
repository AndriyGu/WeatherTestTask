package com.example.WeatherTestTask.controller;

import com.example.WeatherTestTask.model.ResponseWeather;
import com.example.WeatherTestTask.service.WeatherApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/weather")
public class WeatherApiController {

    @Autowired
    WeatherApiService weatherApiService;

    public WeatherApiController(WeatherApiService weatherApiService) {
        this.weatherApiService = weatherApiService;
    }

    @GetMapping("/getWeatherByCityCountry/{city}/{country}")
    ResponseEntity<ResponseWeather> getWeatherByCityCountry(@PathVariable("city") String city,
                                                            @PathVariable("country") String country,
                                                            HttpServletRequest req
    ) throws IOException, InterruptedException {
        return weatherApiService.getWeatherByCityCountry(city, country, req);
    }
}
