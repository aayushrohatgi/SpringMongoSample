package com.mongo.liqourService.dto;

import com.opencsv.bean.CsvBindByName;

public class ConsumptionDto {
	
	@CsvBindByName
	private String country;
	
	@CsvBindByName
	private int beer_servings;
	
	@CsvBindByName
	private int spirit_servings;
	
	@CsvBindByName
	private int wine_servings;

	@CsvBindByName
	private double total_litres_of_pure_alcohol;

	@CsvBindByName
	private String continent;

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getBeer_servings() {
		return beer_servings;
	}

	public void setBeer_servings(int beer_servings) {
		this.beer_servings = beer_servings;
	}

	public int getSpirit_servings() {
		return spirit_servings;
	}

	public void setSpirit_servings(int spirit_servings) {
		this.spirit_servings = spirit_servings;
	}

	public int getWine_servings() {
		return wine_servings;
	}

	public void setWine_servings(int wine_servings) {
		this.wine_servings = wine_servings;
	}

	public double getTotal_litres_of_pure_alcohol() {
		return total_litres_of_pure_alcohol;
	}

	public void setTotal_litres_of_pure_alcohol(double total_litres_of_pure_alcohol) {
		this.total_litres_of_pure_alcohol = total_litres_of_pure_alcohol;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}
}
