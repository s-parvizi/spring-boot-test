package com.example.demo.controller;

import com.example.demo.dto.WeatherResponseDTO;
import com.example.demo.service.WeatherReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class WeatherReportController {

    private final WeatherReportService weatherReportService;

    @GetMapping("/weather/{city}")
    public ResponseEntity<WeatherResponseDTO> getCurrentWeather(@PathVariable String city) {
        WeatherResponseDTO currentWeather = weatherReportService.getCurrentWeather(city);
        return ResponseEntity.ok(currentWeather);
    }
}
