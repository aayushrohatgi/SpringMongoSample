package com.mongo.liqourService.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "consumptions")
public class CountryLiqourConsumptionDto {

	@Id
	private String countryName;
	
	private int beerServing;
	
	private int spiritServing;
	
	private int wineServing;
	
	private double pureAlcoholConsumption;
	
	private ContinentDto continent;
	
	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public int getBeerServing() {
		return beerServing;
	}

	public void setBeerServing(int beerServing) {
		this.beerServing = beerServing;
	}

	public int getSpiritServing() {
		return spiritServing;
	}

	public void setSpiritServing(int spiritServing) {
		this.spiritServing = spiritServing;
	}

	public int getWineServing() {
		return wineServing;
	}

	public void setWineServing(int wineServing) {
		this.wineServing = wineServing;
	}

	public double getPureAlcoholConsumption() {
		return pureAlcoholConsumption;
	}

	public void setPureAlcoholConsumption(double pureAlcoholConsumption) {
		this.pureAlcoholConsumption = pureAlcoholConsumption;
	}

	public ContinentDto getContinent() {
		return continent;
	}

	public void setContinent(ContinentDto continent) {
		this.continent = continent;
	}
}
