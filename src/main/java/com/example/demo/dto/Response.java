package com.example.demo.dto;

import java.util.List;
import lombok.Data;

@Data
public class Response{
	private int dt;
	private Coord coord;
	private int visibility;
	private List<WeatherItem> weather;
	private String name;
	private int cod;
	private Main main;
	private Clouds clouds;
	private int id;
	private Sys sys;
	private String base;
	private Wind wind;
}