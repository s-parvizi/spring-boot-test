package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WeatherResponseDTO {

    private String standard;
    private String celsius;
    private String fahrenheit;
}
