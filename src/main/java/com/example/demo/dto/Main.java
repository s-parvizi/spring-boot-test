package com.example.demo.dto;

import lombok.Data;

@Data
public class Main{
	private Object temp;
	private Object tempMin;
	private int humidity;
	private int pressure;
	private Object tempMax;
}