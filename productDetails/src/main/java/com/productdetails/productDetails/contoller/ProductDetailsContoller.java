package com.productdetails.productDetails.contoller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productdetails.productDetails.entity.Details;
import com.productdetails.productDetails.service.DetailsService;
import com.productdetails.productDetails.VO.RestTemplateVO;

@RestController
//@RequestMapping("/details")
public class ProductDetailsContoller {
	@Autowired
	private DetailsService detailsService;
	
	@GetMapping("/details/{id}")
	public Optional<Details> fetchDetails(@PathVariable String id) {
		Optional<Details> details = detailsService.fetchDetails(id);
//		ResponseEntity<Details> resp = new ResponseEntity<Details>(details, HttpStatus.OK);
		return details;
		}
	
	@PostMapping(value = "/details", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> saveDetails(@RequestBody Details details)
	{
		 detailsService.saveDetails(details);
		return new ResponseEntity<String>("Succesfully Inserted", HttpStatus.OK);
	}
	@GetMapping("/details/{id}")
	public RestTemplateVO getDetailsAlondWithProduct(@PathVariable String id )
	{
		return detailsService.getDetailsAlondWithProduct(id);
	}

}
