package com.productdetails.productDetails.VO;

import com.example.demo.entity.Product;
import com.productdetails.productDetails.entity.Details;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestTemplateVO {
	
	private Product product;
	private Details details;
	

}
