package com.mongo.liqourService.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mongo.liqourService.dto.CountryLiqourConsumptionDto;

@Repository
public interface CountryWiseLiquorConsumptionDao extends MongoRepository<CountryLiqourConsumptionDto, String> {

	public List<CountryLiqourConsumptionDto> findByContinentCode(String code);
	
	public CountryLiqourConsumptionDto findByCountryName(String countryName);
}
