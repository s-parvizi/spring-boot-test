package com.example.demo.dto;

import lombok.Data;

@Data
public class WeatherItem{
	private String icon;
	private String description;
	private String main;
	private int id;
}