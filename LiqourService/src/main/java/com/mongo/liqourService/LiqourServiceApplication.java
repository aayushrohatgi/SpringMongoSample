package com.mongo.liqourService;

import java.io.FileNotFoundException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mongo.liqourService.dao.CountryWiseLiquorConsumptionDao;
import com.mongo.liqourService.dto.CountryLiqourConsumptionDto;
import com.mongo.liqourService.service.LiqourConsumptionReader;

@SpringBootApplication
public class LiqourServiceApplication implements CommandLineRunner {

	@Resource
	private LiqourConsumptionReader reader;

	@Resource
	private CountryWiseLiquorConsumptionDao consumptionDao;

	public static void main(String[] args) throws FileNotFoundException {
		SpringApplication.run(LiqourServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws FileNotFoundException {
		List<CountryLiqourConsumptionDto> dtos = getReader().readFromFile();
		getConsumptionDao().saveAll(dtos);
		getConsumptionDao().findByContinentCode("AS").stream().forEach(dto -> System.out.println(dto.getCountryName()));
		CountryLiqourConsumptionDto dto = getConsumptionDao().findByCountryName("India");
		System.out.println("Avg Beer pints a month per person in India: " + dto.getBeerServing());
		System.out.println("Avg Spirit servings a month per person in India: " + dto.getSpiritServing());
		System.out.println("Avg Wine glasses a month per person in India: " + dto.getWineServing());
		System.out.println("Avg alcohol consumtion(L) a month per person in India: " + dto.getPureAlcoholConsumption());
	}

	public CountryWiseLiquorConsumptionDao getConsumptionDao() {
		return consumptionDao;
	}

	public void setConsumptionDao(CountryWiseLiquorConsumptionDao consumptionDao) {
		this.consumptionDao = consumptionDao;
	}

	public LiqourConsumptionReader getReader() {
		return reader;
	}

	public void setReader(LiqourConsumptionReader reader) {
		this.reader = reader;
	}

}
