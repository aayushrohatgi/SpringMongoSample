package com.mongo.liqourService.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mongo.liqourService.dto.ContinentDto;

@Repository
public interface ContinentDao extends MongoRepository<ContinentDto, String>{

}
