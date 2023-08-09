package com.example.demo.service;

import com.example.demo.dto.Response;
import com.example.demo.dto.WeatherResponseDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class WeatherReportService {

    private static final String API_KEY = "e9dc6bffa08dc878865969c6afbcbbdf";

    public WeatherResponseDTO getCurrentWeather(String city) {
        Response externalWeatherAPIResponse = getWeatherTemperatureFromWeatherAPI(city);

        String standardTemperature = externalWeatherAPIResponse.getMain().getTemp().toString();
        String celsiusTemperature = convertStandardToCelsius(standardTemperature);
        String fahrenheitTemperature = convertStandardToFahrenheit(standardTemperature);

        return new WeatherResponseDTO(standardTemperature, celsiusTemperature, fahrenheitTemperature);
    }

    private Response getWeatherTemperatureFromWeatherAPI(String city) {
        WebClient webClient = WebClient.builder()
                .baseUrl("https://api.openweathermap.org/data/2.5/")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();

        Response externalWeatherAPIResponse = webClient.get()
                .uri("weather?q=" + city + "&appid=" + API_KEY + "")
                .exchange()
                .flatMap(clientResponse -> clientResponse.bodyToMono(Response.class))
                .block();

        return externalWeatherAPIResponse;
    }

    private String convertStandardToCelsius(String kelvin) {
        double kelvinValue = Double.parseDouble(kelvin);
        Double celsiusValue = kelvinValue - 273.15;
        return String.valueOf(celsiusValue);
    }

    private String convertStandardToFahrenheit(String kelvin) {
        double kelvinValue = Double.parseDouble(kelvin);
        Double fahrenheitValue = 1.8 * (kelvinValue - 273.15) + 32;
        return String.valueOf(fahrenheitValue);
    }
}
