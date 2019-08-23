package com.mongo.liqourService.service.impl;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongo.liqourService.dao.ContinentDao;
import com.mongo.liqourService.dto.ConsumptionDto;
import com.mongo.liqourService.dto.ContinentDto;
import com.mongo.liqourService.dto.CountryLiqourConsumptionDto;
import com.mongo.liqourService.service.LiqourConsumptionReader;
import com.opencsv.bean.CsvToBeanBuilder;

@Service
public class LiqourConsumptionCSVReader implements LiqourConsumptionReader {

	private static final String csvFilename = "csv/drinks.csv";

	@Autowired
	private ContinentDao continentDao;
	
	@Override
	public List<CountryLiqourConsumptionDto> readFromFile() throws FileNotFoundException {
		List<ConsumptionDto> datas = new CsvToBeanBuilder<ConsumptionDto>(
				new FileReader(getClass().getClassLoader().getResource(csvFilename).getFile()))
						.withType(ConsumptionDto.class).build().parse();

		return populateConsumptionData(datas);
	}

	private List<CountryLiqourConsumptionDto> populateConsumptionData(List<ConsumptionDto> datas) {
		List<CountryLiqourConsumptionDto> dtos = new ArrayList<>();
		for (ConsumptionDto data : datas) {
			CountryLiqourConsumptionDto dto = new CountryLiqourConsumptionDto();
			dto.setCountryName(data.getCountry());
			dto.setBeerServing(data.getBeer_servings());
			dto.setSpiritServing(data.getSpirit_servings());
			dto.setWineServing(data.getWine_servings());
			dto.setPureAlcoholConsumption(data.getTotal_litres_of_pure_alcohol());
			ContinentDto continent = new ContinentDto();
			String continentCode = data.getContinent();
			continent.setCode(continentCode);
			setContinentName(continent, continentCode);
			getContinentDao().save(continent);
			dto.setContinent(continent);
			dtos.add(dto);
		}
		return dtos;
	}

	private void setContinentName(ContinentDto continent, String continentCode) {
		switch (continentCode) {
		case "AS":
			continent.setName("Asia");
			break;
		case "EU":
			continent.setName("Europe");
			break;
		case "AF":
			continent.setName("Africa");
			break;
		case "NA":
			continent.setName("North America");
			break;
		case "SA":
			continent.setName("South America");
			break;
		case "OC":
			continent.setName("Australia");
			break;
		}
	}

	public ContinentDao getContinentDao() {
		return continentDao;
	}

	public void setContinentDao(ContinentDao continentDao) {
		this.continentDao = continentDao;
	}
}
