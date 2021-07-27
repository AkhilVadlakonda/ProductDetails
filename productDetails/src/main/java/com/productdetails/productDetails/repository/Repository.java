package com.productdetails.productDetails.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.productdetails.productDetails.entity.Details;

public interface Repository extends MongoRepository<Details,String>{
	
	Optional<Details> findById(String id);

}
