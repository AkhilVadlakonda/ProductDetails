package com.productdetails.productDetails.service;

import java.net.URI;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.Product;
import com.productdetails.productDetails.VO.RestTemplateVO;
import com.productdetails.productDetails.entity.Details;
import com.productdetails.productDetails.repository.Repository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DetailsService {
	@Autowired
	private Repository repo;
	
	@Autowired
	private RestTemplate restTemplate;

	public Optional<Details> fetchDetails(String id) {
		Optional<Details> details = repo.findById(id);
		return details;
	}

	public void  saveDetails(Details details) {
		details.setId(details.getId());
		details.setDate(new Date());
		repo.insert(details);
	}

	public RestTemplateVO getDetailsAlondWithProduct(String id)
	{
		log.info("Inside getDetailsAlondWithProduct method of Details Service");
		RestTemplateVO vo = new RestTemplateVO();
		Optional<Details> details = repo.findById(id);
		Details d = new Details();
		d.setId(details.toString());
		Product product = restTemplate.getForObject("http://localhost:8097/details/" + d.getId(), Product.class);
		vo.setDetails(d);
		vo.setProduct(product);
		return vo;
		
	}
	
}
