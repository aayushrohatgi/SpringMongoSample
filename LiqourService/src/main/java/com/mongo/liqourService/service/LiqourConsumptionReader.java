package com.mongo.liqourService.service;

import java.io.FileNotFoundException;
import java.util.List;

import com.mongo.liqourService.dto.CountryLiqourConsumptionDto;

public interface LiqourConsumptionReader {

	public List<CountryLiqourConsumptionDto> readFromFile() throws FileNotFoundException;
}
