package com.example.demo.dto;

import lombok.Data;

@Data
public class Sys{
	private String country;
	private int sunrise;
	private int sunset;
	private int id;
	private int type;
	private Object message;
}